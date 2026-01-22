package Interviews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RaceStartExample {
    
    public static void main(String[] args) throws InterruptedException {
        int numRunners = 5;
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numRunners);
        
        System.out.println("Race about to begin...");
        
        // Create runners
        for (int i = 1; i <= numRunners; i++) {
            new Thread(new Runner(i, startSignal, doneSignal)).start();
        }
        
        // Give time for all runners to get ready
        Thread.sleep(10000);
        
        System.out.println("On your marks... Get set...");
        Thread.sleep(5000);
        
        // Fire the start signal
        System.out.println("GO!");
        startSignal.countDown(); // All runners start simultaneously
        
        // Wait for all runners to finish
        doneSignal.await();
        
        System.out.println("Race finished!");
    }
    
    static class Runner implements Runnable {
        private final int id;
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        
        Runner(int id, CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.id = id;
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }
        
        @Override
        public void run() {
            try {
                System.out.println("Runner " + id + " ready at starting line");
                
                // Wait for the start signal
                startSignal.await();
                
                // Start running
                System.out.println("Runner " + id + " starts running...");
                Thread.sleep((long) (Math.random() * 4000)); // Simulate race time
                
                System.out.println("Runner " + id + " finished!");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
        System.out.println("result of race is : ");
                doneSignal.countDown();
            }
        }
    }
}