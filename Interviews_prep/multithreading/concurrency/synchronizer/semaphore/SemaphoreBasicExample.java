package Interviews_prep.multithreading.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreBasicExample {
    
    public static void main(String[] args) {
        // Create a semaphore with 3 permits (3 resources available)
        Semaphore semaphore = new Semaphore(3);
        
        // Create 10 threads that will compete for 3 permits
        for (int i = 1; i <= 10; i++) {
            Thread worker = new Thread(new ResourceUser(i, semaphore));
            worker.start();
        }
    }
    
    static class ResourceUser implements Runnable {
        private final int id;
        private final Semaphore semaphore;
        
        ResourceUser(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }
        
        @Override
        public void run() {
            try {
                System.out.println("Thread " + id + " waiting to acquire permit...");
                System.out.println("Available permits: " + semaphore.availablePermits());
                
                // Acquire a permit (blocks if none available)
                semaphore.acquire();
                
                System.out.println("Thread " + id + " acquired permit. Available permits: " 
                                   + semaphore.availablePermits());
                
                // Simulate using the resource
                Thread.sleep(2000);
                
                System.out.println("Thread " + id + " finished using resource.");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Always release the permit
                semaphore.release();
                System.out.println("Thread " + id + " released permit. Available permits: " 
                                   + semaphore.availablePermits());
            }
        }
    }
}