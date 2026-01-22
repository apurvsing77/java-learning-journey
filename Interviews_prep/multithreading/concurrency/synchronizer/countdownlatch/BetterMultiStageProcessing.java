package Interviews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class BetterMultiStageProcessing {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int numTasks = 10;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        
        System.out.println("=== STAGE 1: Data Loading ===");
        CountDownLatch loadLatch = new CountDownLatch(numTasks);
        AtomicInteger successCount = new AtomicInteger(0);
        
        // Submit all loading tasks
        for (int i = 1; i <= numTasks; i++) {
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Loading task " + taskId);
                    Thread.sleep((long)(Math.random() * 2000));
                    
                    if (Math.random() < 0.8) {
                        successCount.incrementAndGet();
                        System.out.println("Task " + taskId + " loaded successfully");
                        return taskId; // Return successful task ID
                    } else {
                        System.out.println("Task " + taskId + " failed to load");
                        return -1; // Indicate failure
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return -1;
                } finally {
                    loadLatch.countDown();
                }
            });
        }
        
        loadLatch.await();
        System.out.println("\nSuccessful loads: " + successCount.get());
        
        System.out.println("\n=== STAGE 2: Data Processing ===");
        CountDownLatch processLatch = new CountDownLatch(successCount.get());
        
        // Re-submit only successful tasks
        // In real scenario, you would collect successful task IDs from Futures
        for (int i = 1; i <= numTasks; i++) {
            final int taskId = i;
            executor.submit(() -> {
                // Check if task was successful (in real app, check Future result)
                if (Math.random() < 0.8) { // Simulating successful tasks
                    try {
                        System.out.println("Processing task " + taskId);
                        Thread.sleep((long)(Math.random() * 1500));
                        System.out.println("Task " + taskId + " processed successfully");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    } finally {
                        processLatch.countDown();
                    }
                }
            });
        }
        
        processLatch.await();
        System.out.println("\nAll processing completed!");
        executor.shutdown();
    }
}