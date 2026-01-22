package Interviews_prep.multithreading.Syncronizetion;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class SyncPerformance {
    private int counter = 0;
    private final Object lock = new Object();
    private AtomicInteger atomicCounter = new AtomicInteger(0);
    private final CountDownLatch latch;

    // Constructor to pass latch
    public SyncPerformance(CountDownLatch latch) {
        this.latch = latch;
    }

    public void testMethodSync() {
        try {
            latch.await(); // Wait for signal to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10_000_000; i++) {
            methodSync();
        }
        System.out.println("Method Sync: " + counter);
    }

    public synchronized void methodSync() {
        counter++;
    }

    public void testBlockSync() {
        try {
            latch.await(); // Wait for signal to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10_000_000; i++) {
            blockSync();
        }
        System.out.println("Block Sync: " + counter);
    }

    public void blockSync() {
        synchronized(lock) {
            counter++;
        }
    }

    public void testAtomic() {
        try {
            latch.await(); // Wait for signal to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10_000_000; i++) {
            atomicCounter.incrementAndGet();
        }
        System.out.println("Atomic: " + atomicCounter.get());
    }

    public static void main(String[] args) throws InterruptedException {
        // Create separate latches for each test to avoid interference
        CountDownLatch latch1 = new CountDownLatch(1);
        CountDownLatch latch2 = new CountDownLatch(1);
        CountDownLatch latch3 = new CountDownLatch(1);

        // Create separate instances for each test
        SyncPerformance test1 = new SyncPerformance(latch1);
        SyncPerformance test2 = new SyncPerformance(latch2);
        SyncPerformance test3 = new SyncPerformance(latch3);

        Thread t1 = new Thread(() -> test1.testMethodSync());
        Thread t2 = new Thread(() -> test2.testBlockSync());
        Thread t3 = new Thread(() -> test3.testAtomic());

        // Start all threads
        t1.start();
        t2.start();
        t3.start();

        // Give threads time to reach await point
        Thread.sleep(100);

        // Start all tests at the same time
        latch1.countDown();
        latch2.countDown();
        latch3.countDown();

        // Wait for all threads to complete
        t1.join();
        t2.join();
        t3.join();
    }
}

// Alternative: Using a single latch for coordinated start
class SyncPerformanceAlternative {
    private int counter = 0;
    private final Object lock = new Object();
    private AtomicInteger atomicCounter = new AtomicInteger(0);
    private CountDownLatch latch;

    // Setter for latch if you want to reuse the same instance
    public void setLatch(CountDownLatch latch) {
        this.latch = latch;
    }

    // Reset counters for fresh test
    public void reset() {
        counter = 0;
        atomicCounter.set(0);
    }

    // ... rest of the methods remain the same
}