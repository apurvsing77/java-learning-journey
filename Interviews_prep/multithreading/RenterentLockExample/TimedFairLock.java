package Interviews_prep.multithreading.RenterentLockExample;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

public class TimedFairLock {
    private final ReentrantLock lock = new ReentrantLock(true);
    private final Map<Thread, Long> entryTimes = new HashMap<>();
    private static final long MAX_WAIT_MS = 5000;
    
    public void lockWithMaxWait() throws TimeoutException, InterruptedException {
        lock.lock();
        try {
            Thread current = Thread.currentThread();
            entryTimes.put(current, System.currentTimeMillis());
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Lock: " + lock.getHoldCount());
            System.out.println("_***************************************_____");
            Thread.sleep(3000);
        } finally {
            lock.unlock();
        }
        
        // Check periodically
        while (!lock.tryLock()) {
            long waited = System.currentTimeMillis() - entryTimes.get(Thread.currentThread());
            System.out.println("Waited: " + waited);
            System.out.println("Max Wait: " + MAX_WAIT_MS);
            System.out.println("Thread: " + Thread.currentThread().getName());
            System.out.println("Lock: " + lock.getHoldCount());
      System.out.println("__________________________________________________");
            if (waited > MAX_WAIT_MS) {
                entryTimes.remove(Thread.currentThread());
                throw new TimeoutException("Waited too long for lock");
            }
            try { Thread.sleep(10); } catch (InterruptedException e) { break; }
        }
    }

    public static void main(String[] args) throws TimeoutException, InterruptedException {
        TimedFairLock lock = new TimedFairLock();
        lock.lockWithMaxWait();
    }
}