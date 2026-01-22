package Interviews_prep.multithreading.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Only 2 permits available
        Semaphore semaphore = new Semaphore(2);

        Runnable guest = () -> {
            try {
                semaphore.acquire(); // Request permit (blocks if 0 left)
                System.out.println(Thread.currentThread().getName() + " entered club.");
                Thread.sleep(1000); // Simulate stay
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } finally {
                System.out.println(Thread.currentThread().getName() + " leaving club.");
                semaphore.release(); // Return permit
            }
        };

        // Start 5 threads trying to get in
        for (int i = 0; i < 5; i++) new Thread(guest).start();
    }
}