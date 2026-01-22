package Interviews_prep.multithreading.ExecutorFramework; // Core Threads:

// - Created when pool starts or when first tasks arrive
// - NEVER die unless: pool.shutdown(), thread crashes
// - Even if idle for days, they stay alive
// - Like permanent employees

// Non-Core Threads (also called "extra" or "temporary"):
// - Created only when queue is full AND core threads busy
// - Die after keepAliveTime of inactivity
// - Maximum of (maxPoolSize - corePoolSize) can exist
// - Like temporary contractors

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Visualizing thread lifecycle:
public class ThreadLifecycleDemo {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,  // Core = 2 permanent threads
            5,  // Max = 5 total threads (2 core + 3 temporary)
            2, TimeUnit.SECONDS,  // Temporary threads die after 2s idle
            new SynchronousQueue<>()  // No queue - direct handoff
        );
        
        executor.prestartAllCoreThreads();  // Start core threads immediately
        
        System.out.println("Initial: " + executor.getPoolSize() + " threads");
        
        // Submit 5 tasks at once
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                try { Thread.sleep(1000); } catch (InterruptedException e) {}
            });
        }
        
        Thread.sleep(100);
        System.out.println("Under load: " + executor.getPoolSize() + " threads");
        
        Thread.sleep(3000);  // Wait for tasks to complete + keepAliveTime
        System.out.println("After idle: " + executor.getPoolSize() + " threads");
        // Output: Initial: 2, Under load: 5, After idle: 2
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}