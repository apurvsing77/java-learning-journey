package Interviews_prep.multithreading.RenterentLockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DatabaseConnection {
    private final Lock connectionLock = new ReentrantLock();
    
    public void executeQuery() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " attempting to get lock");
        
        // This can be interrupted!
        connectionLock.lockInterruptibly();
        
        try {
            System.out.println(Thread.currentThread().getName() + " got lock, executing query");
            Thread.sleep(5000); // Long query
        } finally {
            connectionLock.unlock();
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        DatabaseConnection db = new DatabaseConnection();
        
        Thread queryThread = new Thread(() -> {
            try {
                db.executeQuery();
            } catch (InterruptedException e) {
                System.out.println("Query was CANCELLED: " + e.getMessage());
            }
        }, "Query-Thread");
        
        queryThread.start();
        Thread.sleep(100); // Let it try to get lock
        
        // Cancel the query after 100ms
        System.out.println("Cancelling query...");
        queryThread.interrupt();  // This works with lockInterruptibly()
        // With synchronized, interrupt would be ignored!
    }
}