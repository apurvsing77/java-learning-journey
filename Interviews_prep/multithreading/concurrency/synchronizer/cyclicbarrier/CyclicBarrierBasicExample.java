package Interviews_prep.multithreading.concurrency.synchronizer.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierBasicExample {
    
    public static void main(String[] args) {
        int numberOfThreads = 4;
        
        // Create a CyclicBarrier for 4 threads
        CyclicBarrier barrier = new CyclicBarrier(numberOfThreads, 
            () -> System.out.println("\n=== All threads reached barrier! Proceeding... ===\n"));
        
        System.out.println("Starting " + numberOfThreads + " computation threads...");
        
        // Create and start threads
        for (int i = 1; i <= numberOfThreads; i++) {
            Thread worker = new Thread(new ComputationWorker(i, barrier));
            worker.start();
        }
    }
    
    static class ComputationWorker implements Runnable {
        private final int id;
        private final CyclicBarrier barrier;
        
        ComputationWorker(int id, CyclicBarrier barrier) {
            this.id = id;
            this.barrier = barrier;
        }
        
        @Override
        public void run() {
            try {
                // Phase 1: Independent computation
                System.out.println("Thread " + id + " starting phase 1 computation...");
                Thread.sleep((long) (Math.random() * 3000));
                System.out.println("Thread " + id + " completed phase 1");
                
                // Wait for all threads to complete phase 1
                int arrivalIndex = barrier.await();
                System.out.println("Thread " + id + " passed barrier (arrival #" + arrivalIndex + ")");
                
                // Phase 2: Dependent computation (requires phase 1 results from all)
                System.out.println("Thread " + id + " starting phase 2 computation...");
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println("Thread " + id + " completed phase 2");
                
                // Wait for all threads to complete phase 2
                barrier.await();
                System.out.println("Thread " + id + " passed barrier again for phase 3");


                // Phase 3: Dependent computation (requires phase 1 results from all)
                System.out.println("Thread " + id + " starting phase 3 computation...");
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println("Thread " + id + " completed phase 3");

                // Wait for all threads to complete phase 2
                barrier.await();
                System.out.println("Thread " + id + " passed barrier again for final phase");


                // Phase 4: Final computation
                System.out.println("Thread " + id + " starting final phase...");
                Thread.sleep((long) (Math.random() * 1000));
                System.out.println("Thread " + id + " COMPLETED ALL WORK!");
                
            } catch (InterruptedException | BrokenBarrierException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread " + id + " interrupted!");
            }
        }
    }
}