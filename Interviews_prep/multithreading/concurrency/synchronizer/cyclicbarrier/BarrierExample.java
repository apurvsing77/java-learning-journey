package Interviews_prep.multithreading.concurrency.synchronizer.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class BarrierExample {
    public static void main(String[] args) {
        // Initialize barrier for 3 threads. 
        // The Runnable runs ONCE when all 3 arrive.
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println(">> BARRIER TRIPPED <<"));

        Runnable walker = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " arrived at barrier.");
                barrier.await(); // Wait for others
                System.out.println(Thread.currentThread().getName() + " crossed barrier.");

            } catch (Exception e) { e.printStackTrace(); }
        };

        new Thread(walker).start();
        new Thread(walker).start();
        new Thread(walker).start();
    }
}