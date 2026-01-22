package Interviews_prep.multithreading.ThreadSefty;

import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionExample {
    public static void main(String[] args) throws InterruptedException {
        HashMap<String, Integer> map = new HashMap<>();

        // Put initial values
        map.put("A", 1);
        map.put("B", 2);

        AtomicInteger nullCount = new AtomicInteger(0);
        AtomicInteger wrongCount = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(1);

        // Thread 1: Reader (checks for errors)
        Thread reader = new Thread(() -> {
            try {
                latch.await(); // Wait for signal to start
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 1_000_000; i++) { // More iterations
                Integer val = map.get("A");
                if (val == null) {
                    nullCount.incrementAndGet();
                    System.out.println("FOUND NULL! Iteration: " + i);
                } else if (val != 1) {
                    wrongCount.incrementAndGet();
                    System.out.println("FOUND WRONG VALUE: " + val + " at iteration: " + i);
                }
            }
        });

        // Thread 2: Writer (forces resizes)
        Thread writer = new Thread(() -> {
            try {
                latch.await(); // Wait for signal to start
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < 1_000_000; i++) {
                map.put("Key" + i, i);

                // Remove old keys to force more resizes
                if (i > 1000) {
                    map.remove("Key" + (i - 1000));
                }
            }
        });

        reader.start();
        writer.start();

        // Start both threads at the same time
        latch.countDown();

        reader.join();
        writer.join();

        System.out.println("\nResults after 1,000,000 iterations:");
        System.out.println("Null values found: " + nullCount.get());
        System.out.println("Wrong values found: " + wrongCount.get());
        System.out.println("Final map size: " + map.size());

    }
}