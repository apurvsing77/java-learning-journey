package Interviews_prep.multithreading.RenterentLockExample;

//import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadManager {
    private final Lock downloadLock = new ReentrantLock();

    public void downloadFile(String url) throws InterruptedException {
        downloadLock.lockInterruptibly();  // User can Cancel it


        try {
            System.out.println("Thread Name : "+Thread.currentThread().getName());
            for (int progress = 0; progress <= 100; progress += 10) {
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException("User Has been Cancelled");
                }
                System.out.println("Downloading... " + progress + "%");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new InterruptedException("User Has been Cancelled");
                }
            }
        } finally {
            downloadLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DownloadManager downloadManager = new DownloadManager();

        Thread downloadThread = new Thread(() -> {
            try {
                downloadManager.downloadFile("https://example.com/file.zip");
                System.out.println("Download completed.");
            } catch (InterruptedException e) {
                System.out.println("Download interrupted: " + e.getMessage());
            }
        }, "download-thread");

        downloadThread.start();

        Thread.sleep(2000);
        downloadThread.interrupt();

        downloadThread.join();
    }
}