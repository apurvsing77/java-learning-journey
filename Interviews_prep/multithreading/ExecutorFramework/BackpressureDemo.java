package Interviews_prep.multithreading.ExecutorFramework;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class BackpressureDemo {
    public static void main(String[] args) {
        // Small pool, small queue - easily overwhelmed
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                  2,
                4,
                60,
                TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(2),
            new ThreadPoolExecutor.CallerRunsPolicy()  // The magic!
        );
        
        // Fast producer thread
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                final int taskId = i;
                long start = System.currentTimeMillis();
                
                executor.submit(() -> {
                    try {
                        Thread.sleep(1000);  // Task takes 1 second
                        System.out.println("Task " + taskId + " completed by " 
                                         + Thread.currentThread().getName());
                    } catch (InterruptedException e) {}
                });
                
                long end = System.currentTimeMillis();
                System.out.println("Submitted task " + taskId + " in " 
                                 + (end - start) + "ms");
                
                // Initially fast, then slows down when backpressure kicks in
            }
        }, "Producer-Thread");
        
        producer.start();
    }
}

// Output pattern:
// First 8 tasks: Submitted quickly (2 core + 2 queue + 4 max reached)
// Task 9+: Submission SLOWS DOWN because runs in Producer-Thread
// Producer-Thread is now busy executing task → can't submit quickly
// NATURAL BACKPRESSURE ACHIEVED!