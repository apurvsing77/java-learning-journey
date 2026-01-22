package Interviews_prep.multithreading.RenterentLockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketCounter {
    // FAIR lock - threads get tickets in arrival order
    private final Lock fairLock = new ReentrantLock(true);
    
    // UNFAIR lock (default) - threads compete, possibly starve
    private final Lock unfairLock = new ReentrantLock(false); // or new ReentrantLock()
    
    public void buyTicketFair() {
//        fairLock.lock();
        unfairLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " buying ticket");
            Thread.sleep(100); // Simulate work
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
//            fairLock.unlock();
            unfairLock.unlock();
        }
    }
    
    public void testFairness() {
        // Create 10 customers
        for (int i = 0; i < 10; i++) {
            new Thread(() -> buyTicketFair(), "Customer-" + i).start();
            try { Thread.sleep(10); } catch (Exception e) {} // Ensure order
        }
    }

    public static void main(String[] args){
        TicketCounter ticketCounter = new TicketCounter();
        ticketCounter.testFairness();
    }
}