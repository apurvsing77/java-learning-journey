package Interviews_prep.multithreading.concurrentCollection;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class CopyOnWriteArraySetExample {

    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();
//        HashSet<String> set = new HashSet<>();
        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");

        Thread readThread  = new Thread(() -> {
            System.out.println("Read Operation");
            for (String s  : set){
                System.out.println(s);
            }
        });
        Thread writeThread = new Thread(() ->{
            System.out.println("Write Operation");
            set.add("F");
            set.add("G");
            set.add("H");
        });
        readThread.start();
        writeThread.start();
    }
}
