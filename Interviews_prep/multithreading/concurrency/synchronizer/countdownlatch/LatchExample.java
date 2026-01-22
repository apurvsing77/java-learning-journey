package Interviews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class LatchExample {
    public static void main(String[] args) throws InterruptedException {
        // Initialize latch for 3 events
        CountDownLatch latch = new CountDownLatch(3);

        Runnable task = () -> {
            System.out.println("Task finished by " + Thread.currentThread().getName());
            latch.countDown(); // Decrement count
        };

        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();

        latch.await(); // Main thread blocks here until count is 0
    System.out.println("Current Thread is "+Thread.currentThread().getName());
        System.out.println("All 3 tasks done. Proceeding...");
    }
}