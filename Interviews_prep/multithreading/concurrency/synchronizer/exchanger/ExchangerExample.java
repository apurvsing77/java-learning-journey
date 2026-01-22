package Interviews_prep.multithreading.concurrency.synchronizer.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(() -> {
            try {
                String myData1 = "Gift from A";
                // Give myData, receive theirData
                String received = exchanger.exchange(myData1);
                System.out.println("Thread A got: " + received);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();

        new Thread(() -> {
            try {
                String myData2 = "Gift from B";
                String received = exchanger.exchange(myData2);
                System.out.println("Thread B got: " + received);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
        new Thread(()->{// this will not work , exchanger works with only two thread.
           String myData3 = "gift to all ";
            try {
                String received = exchanger.exchange(myData3);
                System.out.println("Thread C got: " + received);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}