package Interviews_prep.multithreading.concurrency.synchronizer.semaphore.DownloadManager;

import java.util.concurrent.*;
import java.util.concurrent.atomic.*;
import java.util.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadManager {

    // ========== CORE DATA STRUCTURES ==========

    // Semaphore to limit concurrent downloads to 3
    private final Semaphore downloadSemaphore = new Semaphore(3, true);

    // Priority queue for VIP downloads (higher priority number = higher priority)
    private final PriorityBlockingQueue<DownloadTask> pendingQueue =
            new PriorityBlockingQueue<>();

    // Track active downloads
    private final Map<String, DownloadTask> activeDownloads = new ConcurrentHashMap<>();
    private final Map<String, Future<?>> taskFutures = new ConcurrentHashMap<>();

    // For pause/resume functionality - use ReentrantLock with Condition
    private final Map<String, PauseController> pauseControllers = new ConcurrentHashMap<>();
    private volatile boolean globalPause = false;

    // For speed tracking
    private final Map<String, SpeedTracker> speedTrackers = new ConcurrentHashMap<>();
    private final ScheduledExecutorService speedMonitor = Executors.newScheduledThreadPool(1);

    // Thread pool for downloads
    private final ExecutorService downloadExecutor = Executors.newCachedThreadPool();
    private final ScheduledExecutorService timeoutExecutor = Executors.newScheduledThreadPool(1);

    // Statistics
    private final AtomicInteger totalDownloads = new AtomicInteger(0);
    private final AtomicInteger completedDownloads = new AtomicInteger(0);
    private final AtomicInteger failedDownloads = new AtomicInteger(0);
    private final AtomicLong totalBytesDownloaded = new AtomicLong(0);

    private volatile boolean shutdown = false;

    // ========== DOWNLOAD TASK CLASS ==========

    static class DownloadTask implements Comparable<DownloadTask> {
        final String downloadId;
        final String url;
        final String destination;
        final int priority;  // 1-10, 10 is highest
        final long timeoutSeconds;

        volatile long fileSize = 0;
        volatile long downloadedBytes = 0;
        volatile long startTime = 0;
        volatile long endTime = 0;
        volatile Status status = Status.PENDING;

        enum Status {
            PENDING, DOWNLOADING, PAUSED, COMPLETED, FAILED, CANCELLED, TIMEOUT
        }

        DownloadTask(String url, String destination, int priority, long timeoutSeconds) {
            this.downloadId = UUID.randomUUID().toString();
            this.url = url;
            this.destination = destination;
            this.priority = Math.max(1, Math.min(10, priority)); // Clamp 1-10
            this.timeoutSeconds = timeoutSeconds;
        }

        double getProgress() {
            if (fileSize <= 0) return 0.0;
            return (downloadedBytes * 100.0) / fileSize;
        }

        @Override
        public int compareTo(DownloadTask other) {
            // Higher priority first
            int priorityCompare = Integer.compare(other.priority, this.priority);
            if (priorityCompare != 0) return priorityCompare;
            // Then by submission time
            return Long.compare(this.startTime, other.startTime);
        }

        @Override
        public String toString() {
            return String.format("Download[%s] Priority:%d Progress:%.1f%% Status:%s",
                    downloadId.substring(0, 8), priority, getProgress(), status);
        }
    }

    // ========== PAUSE CONTROLLER WITH PROPER LOCKING ==========

    static class PauseController {
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition notPaused = lock.newCondition();
        private volatile boolean paused = false;

        void pause() {
            lock.lock();
            try {
                paused = true;
            } finally {
                lock.unlock();
            }
        }

        void resume() {
            lock.lock();
            try {
                paused = false;
                notPaused.signalAll();
            } finally {
                lock.unlock();
            }
        }

        void awaitIfPaused() throws InterruptedException {
            lock.lock();
            try {
                while (paused) {
                    notPaused.await();
                }
            } finally {
                lock.unlock();
            }
        }

        boolean isPaused() {
            return paused;
        }
    }

    // ========== SPEED TRACKER ==========

    static class SpeedTracker {
        private final String downloadId;
        private final AtomicLong bytesDownloaded = new AtomicLong(0);
        private final AtomicLong lastUpdateTime = new AtomicLong(System.currentTimeMillis());
        private volatile double currentSpeed = 0.0; // KB/s

        SpeedTracker(String downloadId) {
            this.downloadId = downloadId;
        }

        void updateBytes(long newBytes) {
            long currentTime = System.currentTimeMillis();
            long oldTime = lastUpdateTime.getAndSet(currentTime);
            long oldBytes = bytesDownloaded.getAndSet(newBytes);
            long timeDiff = currentTime - oldTime;

            if (timeDiff > 0 && newBytes > oldBytes) {
                // Calculate speed in KB/s
                long bytesDiff = newBytes - oldBytes;
                currentSpeed = (bytesDiff / 1024.0) / (timeDiff / 1000.0);
            }
        }

        double getSpeedKBps() {
            return currentSpeed;
        }

        String getFormattedSpeed() {
            if (currentSpeed < 1024) {
                return String.format("%.2f KB/s", currentSpeed);
            } else {
                return String.format("%.2f MB/s", currentSpeed / 1024);
            }
        }
    }

    // ========== DOWNLOAD MANAGER METHODS ==========

    public DownloadManager() {
        // Start speed monitoring thread
        speedMonitor.scheduleAtFixedRate(this::updateAllSpeeds, 0, 1, TimeUnit.SECONDS);

        // Start queue processor thread
        Thread queueProcessor = new Thread(this::processQueue);
        queueProcessor.setDaemon(true);
        queueProcessor.start();
    }

    // ========== PUBLIC API ==========

    /**
     * Submit a new download request
     */
    public String submitDownload(String url, String destination, int priority, long timeoutSeconds) {
        if (shutdown) {
            throw new IllegalStateException("DownloadManager is shutdown");
        }

        DownloadTask task = new DownloadTask(url, destination, priority, timeoutSeconds);
        pauseControllers.put(task.downloadId, new PauseController());
        speedTrackers.put(task.downloadId, new SpeedTracker(task.downloadId));

        pendingQueue.offer(task);
        totalDownloads.incrementAndGet();

        System.out.println("[" + new Date() + "] Submitted download: " + task);
        return task.downloadId;
    }

    /**
     * VIP download - high priority
     */
    public String submitVIPDownload(String url, String destination, long timeoutSeconds) {
        return submitDownload(url, destination, 10, timeoutSeconds); // Max priority
    }

    /**
     * Normal download - medium priority
     */
    public String submitNormalDownload(String url, String destination, long timeoutSeconds) {
        return submitDownload(url, destination, 5, timeoutSeconds);
    }

    /**
     * Low priority download
     */
    public String submitLowPriorityDownload(String url, String destination, long timeoutSeconds) {
        return submitDownload(url, destination, 1, timeoutSeconds);
    }

    /**
     * Pause a specific download
     */
    public boolean pauseDownload(String downloadId) {
        PauseController controller = pauseControllers.get(downloadId);
        if (controller != null) {
            controller.pause();

            DownloadTask task = activeDownloads.get(downloadId);
            if (task != null && task.status == DownloadTask.Status.DOWNLOADING) {
                task.status = DownloadTask.Status.PAUSED;
                System.out.println("[" + new Date() + "] Paused download: " + downloadId);
                return true;
            }
        }
        return false;
    }

    /**
     * Resume a specific download
     */
    public boolean resumeDownload(String downloadId) {
        PauseController controller = pauseControllers.get(downloadId);
        if (controller != null) {
            controller.resume();

            DownloadTask task = activeDownloads.get(downloadId);
            if (task != null && task.status == DownloadTask.Status.PAUSED) {
                task.status = DownloadTask.Status.DOWNLOADING;
                System.out.println("[" + new Date() + "] Resumed download: " + downloadId);
                return true;
            }
        }
        return false;
    }

    /**
     * Pause all downloads
     */
    public void pauseAll() {
        globalPause = true;
        for (String downloadId : activeDownloads.keySet()) {
            pauseDownload(downloadId);
        }
        System.out.println("[" + new Date() + "] Paused all downloads");
    }

    /**
     * Resume all downloads
     */
    public void resumeAll() {
        globalPause = false;
        for (String downloadId : activeDownloads.keySet()) {
            resumeDownload(downloadId);
        }
        System.out.println("[" + new Date() + "] Resumed all downloads");
    }

    /**
     * Cancel a download
     */
    public boolean cancelDownload(String downloadId) {
        // First check if it's in the pending queue
        for (DownloadTask task : pendingQueue) {
            if (task.downloadId.equals(downloadId)) {
                if (pendingQueue.remove(task)) {
                    task.status = DownloadTask.Status.CANCELLED;
                    System.out.println("[" + new Date() + "] Cancelled pending download: " + downloadId);
                    return true;
                }
            }
        }

        // Check if it's an active download
        Future<?> future = taskFutures.get(downloadId);
        if (future != null && !future.isDone()) {
            boolean cancelled = future.cancel(true);
            if (cancelled) {
                DownloadTask task = activeDownloads.remove(downloadId);
                if (task != null) {
                    task.status = DownloadTask.Status.CANCELLED;
                }
                taskFutures.remove(downloadId);
                downloadSemaphore.release(); // Release the slot
                System.out.println("[" + new Date() + "] Cancelled active download: " + downloadId);
                return true;
            }
        }
        return false;
    }

    /**
     * Get download status
     */
    public DownloadTask.Status getStatus(String downloadId) {
        DownloadTask task = activeDownloads.get(downloadId);
        if (task != null) {
            return task.status;
        }

        // Check pending queue
        for (DownloadTask t : pendingQueue) {
            if (t.downloadId.equals(downloadId)) {
                return t.status;
            }
        }

        return DownloadTask.Status.PENDING;
    }

    /**
     * Get download progress (0-100)
     */
    public double getProgress(String downloadId) {
        DownloadTask task = activeDownloads.get(downloadId);
        if (task != null) {
            return task.getProgress();
        }

        // Check pending queue
        for (DownloadTask t : pendingQueue) {
            if (t.downloadId.equals(downloadId)) {
                return t.getProgress();
            }
        }

        return 0.0;
    }

    /**
     * Get current download speed
     */
    public String getSpeed(String downloadId) {
        SpeedTracker tracker = speedTrackers.get(downloadId);
        return tracker != null ? tracker.getFormattedSpeed() : "0 KB/s";
    }

    /**
     * Get all active downloads
     */
    public List<DownloadTask> getActiveDownloads() {
        return new ArrayList<>(activeDownloads.values());
    }

    /**
     * Get pending downloads
     */
    public List<DownloadTask> getPendingDownloads() {
        return new ArrayList<>(pendingQueue);
    }

    /**
     * Get statistics
     */
    public void printStatistics() {
        System.out.println("\n=== DOWNLOAD MANAGER STATISTICS ===");
        System.out.println("Time: " + new Date());
        System.out.println("Total Downloads Submitted: " + totalDownloads.get());
        System.out.println("Completed Successfully: " + completedDownloads.get());
        System.out.println("Failed: " + failedDownloads.get());
        System.out.println("Active Downloads: " + activeDownloads.size());
        System.out.println("Pending in Queue: " + pendingQueue.size());
        System.out.println("Total Bytes Downloaded: " +
                String.format("%.2f MB", totalBytesDownloaded.get() / (1024.0 * 1024.0)));
        System.out.println("Available Download Slots: " + downloadSemaphore.availablePermits());

        // Show active downloads with speeds
        if (!activeDownloads.isEmpty()) {
            System.out.println("\nActive Downloads:");
            for (DownloadTask task : activeDownloads.values()) {
                System.out.printf("  %s - %s - Progress: %.1f%% - Speed: %s%n",
                        task.downloadId.substring(0, 8),
                        task.status,
                        task.getProgress(),
                        getSpeed(task.downloadId));
            }
        }
    }

    // ========== PRIVATE METHODS ==========

    /**
     * Process the download queue
     */
    private void processQueue() {
        while (!shutdown && !Thread.currentThread().isInterrupted()) {
            try {
                // Wait for available slot (non-blocking check)
                if (downloadSemaphore.tryAcquire(100, TimeUnit.MILLISECONDS)) {
                    // Get highest priority task
                    DownloadTask task = pendingQueue.poll();
                    if (task != null) {
                        startDownload(task);
                    } else {
                        downloadSemaphore.release(); // No task, release permit
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    /**
     * Start a download task
     */
    private void startDownload(DownloadTask task) {
        task.startTime = System.currentTimeMillis();
        task.status = DownloadTask.Status.DOWNLOADING;
        activeDownloads.put(task.downloadId, task);

        // Submit download with timeout
        Future<?> future = downloadExecutor.submit(() -> {
            try {
                downloadFile(task);
            } catch (Exception e) {
                handleDownloadError(task, e);
            }
        });

        taskFutures.put(task.downloadId, future);

        // Schedule timeout check if timeout is specified
        if (task.timeoutSeconds > 0) {
            timeoutExecutor.schedule(() -> {
                if (!future.isDone()) {
                    future.cancel(true);
                    task.status = DownloadTask.Status.TIMEOUT;
                    activeDownloads.remove(task.downloadId);
                    taskFutures.remove(task.downloadId);
                    downloadSemaphore.release();
                    failedDownloads.incrementAndGet();
                    System.out.println("[" + new Date() + "] Download timeout: " + task.downloadId);
                }
            }, task.timeoutSeconds, TimeUnit.SECONDS);
        }

        System.out.println("[" + new Date() + "] Started download: " + task);
    }

    /**
     * Actual file download logic
     */
    private void downloadFile(DownloadTask task) throws Exception {
        try {
            // Simulate file download (replace with actual download logic)
            System.out.println("[" + new Date() + "] Starting download: " + task.url);

            // Create destination directory
            Path destinationPath = Paths.get(task.destination);
            Files.createDirectories(destinationPath.getParent());

            // For demo purposes, simulate download with random data
            // In real implementation, use URL connection
            long fileSize = 10 * 1024 * 1024; // 10MB for demo
            task.fileSize = fileSize;

            try (FileOutputStream out = new FileOutputStream(destinationPath.toFile())) {
                byte[] buffer = new byte[8192];
                long totalRead = 0;
                Random random = new Random();

                while (totalRead < fileSize && !Thread.currentThread().isInterrupted()) {
                    // Check for pause
                    PauseController controller = pauseControllers.get(task.downloadId);
                    if (controller != null) {
                        controller.awaitIfPaused();
                    }

                    // Simulate reading data
                    int bytesToRead = (int) Math.min(buffer.length, fileSize - totalRead);
                    random.nextBytes(buffer);

                    // Check for interruption (cancellation/timeout)
                    if (Thread.currentThread().isInterrupted()) {
                        throw new InterruptedException("Download interrupted");
                    }

                    // Write to file
                    out.write(buffer, 0, bytesToRead);
                    totalRead += bytesToRead;
                    task.downloadedBytes = totalRead;

                    // Update speed tracker
                    SpeedTracker tracker = speedTrackers.get(task.downloadId);
                    if (tracker != null) {
                        tracker.updateBytes(totalRead);
                    }

                    // Update total bytes
                    totalBytesDownloaded.addAndGet(bytesToRead);

                    // Simulate network speed variation (10-100 KB/s)
                    Thread.sleep(random.nextInt(100) + 10);

                    // Update progress occasionally
                    if (totalRead % (1024 * 1024) == 0) { // Every MB
                        System.out.printf("[%s] Download %s: %.1f%% complete%n",
                                new Date(), task.downloadId.substring(0, 8), task.getProgress());
                    }
                }

                if (totalRead >= fileSize) {
                    // Download completed successfully
                    task.endTime = System.currentTimeMillis();
                    task.status = DownloadTask.Status.COMPLETED;
                    completedDownloads.incrementAndGet();

                    System.out.printf("[%s] Completed download: %s - Time: %dms - Avg Speed: %.2f KB/s%n",
                            new Date(), task.downloadId.substring(0, 8),
                            task.endTime - task.startTime,
                            (fileSize / 1024.0) / ((task.endTime - task.startTime) / 1000.0));
                }

            } catch (InterruptedException e) {
                throw e; // Re-throw to be handled by outer catch
            }

        } catch (Exception e) {
            throw e; // Re-throw to be handled by startDownload
        } finally {
            // Cleanup
            activeDownloads.remove(task.downloadId);
            taskFutures.remove(task.downloadId);
            downloadSemaphore.release();

            // Auto-remove speed tracker after some time
            ScheduledExecutorService cleanupExecutor = Executors.newSingleThreadScheduledExecutor();
            cleanupExecutor.schedule(() -> speedTrackers.remove(task.downloadId), 1, TimeUnit.MINUTES);
            cleanupExecutor.shutdown();
        }
    }

    /**
     * Handle download errors
     */
    private void handleDownloadError(DownloadTask task, Exception e) {
        task.endTime = System.currentTimeMillis();
        task.status = DownloadTask.Status.FAILED;
        failedDownloads.incrementAndGet();

        System.err.printf("[%s] Download failed: %s - %s%n",
                new Date(), task.downloadId, e.getMessage());

        if (e instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Update speed for all active downloads
     */
    private void updateAllSpeeds() {
        if (shutdown) return;

        for (DownloadTask task : activeDownloads.values()) {
            SpeedTracker tracker = speedTrackers.get(task.downloadId);
            if (tracker != null) {
                tracker.updateBytes(task.downloadedBytes);
            }
        }
    }

    /**
     * Shutdown the download manager
     */
    public void shutdown() {
        shutdown = true;

        System.out.println("[" + new Date() + "] Shutting down DownloadManager...");

        // Cancel all active downloads
        for (Future<?> future : taskFutures.values()) {
            future.cancel(true);
        }

        // Clear pending queue
        pendingQueue.clear();

        // Shutdown executors
        downloadExecutor.shutdown();
        timeoutExecutor.shutdown();
        speedMonitor.shutdown();

        try {
            if (!downloadExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
                downloadExecutor.shutdownNow();
            }

            if (!timeoutExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
                timeoutExecutor.shutdownNow();
            }

            if (!speedMonitor.awaitTermination(5, TimeUnit.SECONDS)) {
                speedMonitor.shutdownNow();
            }
        } catch (InterruptedException e) {
            downloadExecutor.shutdownNow();
            timeoutExecutor.shutdownNow();
            speedMonitor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        System.out.println("[" + new Date() + "] Download manager shutdown complete");
        printStatistics();
    }

    // ========== TEST MAIN METHOD ==========

    public static void main(String[] args) throws Exception {
        DownloadManager manager = new DownloadManager();

        System.out.println("=== DOWNLOAD MANAGER DEMO ===\n");

        // Submit downloads with different priorities
        List<String> downloadIds = new ArrayList<>();

        // VIP download (high priority) - should start immediately
        System.out.println("1. Submitting VIP download (priority 10)...");
        downloadIds.add(manager.submitVIPDownload(
                "http://example.com/vip_file.zip",
                "/tmp/downloads/vip_file.zip",
                30));

        Thread.sleep(1000); // Wait a bit

        // Normal downloads
        System.out.println("\n2. Submitting 3 normal downloads (priority 5)...");
        for (int i = 1; i <= 3; i++) {
            downloadIds.add(manager.submitNormalDownload(
                    "http://example.com/file" + i + ".zip",
                    "/tmp/downloads/file" + i + ".zip",
                    60));
        }

        Thread.sleep(2000); // Wait for some downloads to start

        // Low priority download
        System.out.println("\n3. Submitting low priority download (priority 1)...");
        downloadIds.add(manager.submitLowPriorityDownload(
                "http://example.com/low_priority.zip",
                "/tmp/downloads/low_priority.zip",
                90));

        // Show initial state
        Thread.sleep(3000);
        System.out.println("\n=== INITIAL STATE ===");
        manager.printStatistics();

        // Demonstrate pause/resume
        Thread.sleep(2000);
        System.out.println("\n=== DEMONSTRATING PAUSE/RESUME ===");
        System.out.println("Pausing first download...");
        manager.pauseDownload(downloadIds.get(0));
        Thread.sleep(3000);
        System.out.println("Resuming first download...");
        manager.resumeDownload(downloadIds.get(0));

        // Demonstrate priority - add another VIP while downloads are active
        Thread.sleep(2000);
        System.out.println("\n=== DEMONSTRATING PRIORITY ===");
        System.out.println("Adding another VIP download while others are active...");
        String newVipId = manager.submitVIPDownload(
                "http://example.com/new_vip.zip",
                "/tmp/downloads/new_vip.zip",
                30);
        downloadIds.add(newVipId);

        Thread.sleep(3000);
        System.out.println("New VIP download status: " + manager.getStatus(newVipId));

        // Demonstrate timeout (simulate by waiting)
        Thread.sleep(2000);
        System.out.println("\n=== DEMONSTRATING CANCELLATION ===");
        System.out.println("Cancelling one download...");
        if (downloadIds.size() > 2) {
            manager.cancelDownload(downloadIds.get(2));
        }

        // Let some downloads complete
        Thread.sleep(5000);

        // Final statistics
        System.out.println("\n=== FINAL STATISTICS ===");
        manager.printStatistics();

        // Shutdown
        Thread.sleep(2000);
        manager.shutdown();
    }
}