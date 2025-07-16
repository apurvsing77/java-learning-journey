package Interviews_prep.multithreading.concurrentCollection;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
//        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Thread readThread =  new Thread(()->{
            System.out.println("Read thread started");
            for (String s :list){
                System.out.println(s);
            }
        });
        Thread writeThread =  new Thread(()->{
            System.out.println("Write thread started");
            list.add("E");
            list.add("F");
        });
        readThread.start();
        writeThread.start();
    }
}
