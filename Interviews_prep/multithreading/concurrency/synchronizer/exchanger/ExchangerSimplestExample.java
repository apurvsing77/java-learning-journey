package Interviews_prep.multithreading.concurrency.synchronizer.exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerSimplestExample {
    public static void main(String[] args) throws InterruptedException {
        // Create an Exchanger for String objects
        Exchanger<String> exchanger = new Exchanger<>();
        
        // Thread 1
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("Thread 1: I have 'Hello'");
                System.out.println("Thread 1: Waiting for Thread 2 to exchange...");
                
                // Exchange "Hello" with Thread 2
                String received = exchanger.exchange("Hello");
                
                System.out.println("Thread 1: Received '" + received + "' from Thread 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Thread 2
        Thread thread2 = new Thread(() -> {
            try {
                System.out.println("Thread 2: I have 'World'");
                System.out.println("Thread 2: Waiting for Thread 1 to exchange...");
                
                // Exchange "World" with Thread 1
                String received = exchanger.exchange("World");
                
                System.out.println("Thread 2: Received '" + received + "' from Thread 1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        // Start both threads
        thread1.start();
        thread2.start();
        
        // Wait for both to finish
        thread1.join();
        thread2.join();
        
        System.out.println("\nExchange completed!");
    }
}