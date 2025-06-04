package Interwiews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        for (int i = 1; i <=3 ; i++) {
            new Thread(() -> {
                System.out.println("Java Version: " + System.getProperty("java.version"));
                System.out.println("Task Completed by Thread: " + Thread.currentThread().getId());
                latch.countDown();
                System.out.println(latch.getCount());
            }).start();
        }
        try {
            latch.await();
            System.out.println("All thread Com[pleted the process");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
