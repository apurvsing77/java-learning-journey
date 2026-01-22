package Interviews_prep.multithreading.ThreadSefty;

import java.util.HashMap;

public class RaceConditionExample2 {
    static HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) throws InterruptedException {
        map.put("key", "initial");

        Thread writer = new Thread(() -> {
            while (true) {
                // Toggle between two values
                map.put("key", map.get("key").equals("initial") ? "changed" : "initial");
            }
        });

        Thread reader = new Thread(() -> {
            while (true) {
                String val1 = map.get("key");
                String val2 = map.get("key");
                if (!val1.equals(val2)) {
                    System.out.println("INCONSISTENCY! val1=" + val1 + " val2=" + val2);
                }
            }
        });

        writer.setDaemon(true);
        reader.setDaemon(true);
        writer.start();
        reader.start();

        Thread.sleep(1000); // Run for 1 second
    }
}