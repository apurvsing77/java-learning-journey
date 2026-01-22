package Interviews_prep.multithreading.ExecutorFramework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueFullDemo {
    public static void main(String[] args) {
        // Create pool: 2 core, 4 max, queue size 2
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2, 4, 60, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),
            new ThreadPoolExecutor.CallerRunsPolicy()  // See different policies
        );
        
        executor.setRejectedExecutionHandler(new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Task rejected: " + r + 
                                 " Active threads: " + executor.getActiveCount() +
                                 " Queue size: " + executor.getQueue().size());
            }
        });
        
        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " started by " + 
                                 Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);  // 2-second task
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Task " + taskId + " completed");
            });
            System.out.println("Submitted task " + taskId + 
                             " - Queue size: " + executor.getQueue().size());
        }
        
        executor.shutdown();
    }
}

// Expected output pattern:
// Task 1-2: Run immediately (core threads)
// Task 3-4: Queued
// Task 5-6: Create new threads (up to max)
// Task 7+: Rejected (or handled by policy)