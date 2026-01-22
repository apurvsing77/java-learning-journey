package Interviews_prep.multithreading.concurrency.synchronizer.exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

public class ExchangerBasicExample {
    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== PRODUCER-CONSUMER EXCHANGER DEMO ===\n");
        
        // Create an Exchanger for String objects
        Exchanger<String> exchanger = new Exchanger<>();
        
        // Create and start producer and consumer threads
        Thread producer = new Thread(new Producer(exchanger));
        Thread consumer = new Thread(new Consumer(exchanger));
        
        producer.start();
        consumer.start();
        
        // Wait for threads to complete
        producer.join();
        consumer.join();
        
        System.out.println("\n=== EXCHANGE COMPLETE ===");
    }
    
    // Producer thread - generates data
    static class Producer implements Runnable {
        private final Exchanger<String> exchanger;
        private int itemCount = 0;
        
        Producer(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }
        
        @Override
        public void run() {
            try {
                // Produce 5 items and exchange them
                for (int i = 1; i <= 5; i++) {
                    // Produce an item
                    Thread.sleep(1000 + (long)(Math.random() * 1000));
                    String producedItem = "Item-" + (++itemCount);
                    System.out.println("[Producer] Produced: " + producedItem);
                    
                    // Exchange with consumer
                    System.out.println("[Producer] Waiting to exchange with consumer...");
                    String consumerResponse = exchanger.exchange(producedItem);
                    
                    System.out.println("[Producer] Received from consumer: " + consumerResponse);
                    System.out.println("[Producer] Exchange #" + i + " completed!\n");
                }
                
                // Exchange termination signal
                System.out.println("[Producer] Sending termination signal...");
                exchanger.exchange("END");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Producer] Interrupted!");
            }
        }
    }
    
    // Consumer thread - processes data
    static class Consumer implements Runnable {
        private final Exchanger<String> exchanger;
        private int processedCount = 0;
        
        Consumer(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }
        
        @Override
        public void run() {
            try {
                String receivedItem;
                
                do {
                    // Wait for producer to have something to exchange
                    System.out.println("[Consumer] Waiting for producer...");
                    
                    // Exchange with producer (give acknowledgement, receive item)
                    String acknowledgement = "ACK-" + (processedCount + 1);
                    receivedItem = exchanger.exchange(acknowledgement);
                    
                    if (!receivedItem.equals("END")) {
                        // Process the item
                        System.out.println("[Consumer] Received from producer: " + receivedItem);
                        Thread.sleep(1500 + (long)(Math.random() * 1500));
                        
                        processedCount++;
                        System.out.println("[Consumer] Processed: " + receivedItem + 
                                         " (Total processed: " + processedCount + ")");
                    }
                    
                } while (!receivedItem.equals("END"));
                
                System.out.println("[Consumer] Received termination signal. Processed " + 
                                 processedCount + " items total.");
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("[Consumer] Interrupted!");
            }
        }
    }
}