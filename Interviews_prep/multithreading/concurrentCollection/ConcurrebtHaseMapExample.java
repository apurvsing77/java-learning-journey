package Interviews_prep.multithreading.concurrentCollection;

import java.util.HashMap;

public class ConcurrebtHaseMapExample {
    public static void main(String[] args) {
//        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        HashMap<String,Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);

        Thread readThread = new Thread(() -> {
            System.out.println("Read thread started");
            for(String key : map.keySet()) {
                System.out.println(key + " : " + map.get(key));
            }
        });
        Thread writeThread = new Thread(() -> {
            System.out.println("Write thread started");
            map.put("F", 5);
            map.put("E", 6);
        });
        readThread.start();
        writeThread.start();
    }
}
