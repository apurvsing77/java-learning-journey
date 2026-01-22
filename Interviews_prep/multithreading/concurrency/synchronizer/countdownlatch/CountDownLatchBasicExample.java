package Interviews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchBasicExample {
    
    public static void main(String[] args) throws InterruptedException {
        // Create a latch with count 3
        CountDownLatch latch = new CountDownLatch(3);
        
        // Create and start 3 worker threads
        for (int i = 1; i <= 3; i++) {
//            Thread worker = new Thread(new Worker(i, latch));
//            worker.start();
            int finalI = i;
            new Thread(new Worker(finalI,latch)).start();
        }
        
        System.out.println("Main thread waiting for all workers to complete...");
        
        // Main thread waits until count reaches zero
        latch.await();
        
        System.out.println("All workers completed. Main thread proceeding...");
    }
    
    static class Worker implements Runnable {
        private final int id;
        private final CountDownLatch latch;
        
        Worker(int id, CountDownLatch latch) {
            this.id = id;
            this.latch = latch;
        }
        
        @Override
        public void run() {
            try {
                System.out.println("Worker " + id + " starting task...");
                Thread.sleep((long) (Math.random() * 3000)); // Simulate work
                System.out.println("Worker " + id + " completed task.");
        System.out.println("------------------------------------");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                // Always count down, even if exception occurs
                latch.countDown();
                System.out.println("Worker " + id + " counted down. Remaining: " + latch.getCount());
            }
        }
    }
}