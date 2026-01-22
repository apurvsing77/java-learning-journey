package Interviews_prep.multithreading.RenterentLockExample;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InstrumentedLock implements Lock {
    private final ReentrantLock delegate = new ReentrantLock();
    private long lockAttempts = 0;
    private long lockSuccesses = 0;
    private long totalWaitTime = 0;
    
    @Override
    public void lock() {
        lockAttempts++;
        long start = System.nanoTime();
        delegate.lock();
        long end = System.nanoTime();
        lockSuccesses++;
        totalWaitTime += (end - start);
    }
    
    @Override
    public boolean tryLock() {
        lockAttempts++;
        boolean acquired = delegate.tryLock();
        if (acquired) lockSuccesses++;
        return acquired;
    }
    
    public double getAverageWaitNanos() {

        System.out.println("Total Wait Time: " + totalWaitTime);
        return lockSuccesses > 0 ? (double) totalWaitTime / lockSuccesses : 0;
    }
    
    public double getSuccessRate() {
        System.out.println("Lock Successes: " + lockSuccesses);
        System.out.println("Lock Attempts: " + lockAttempts);
        return lockAttempts > 0 ? (double) lockSuccesses / lockAttempts : 1.0;
    }
    
    // Implement other Lock methods...
    @Override public void lockInterruptibly() throws InterruptedException { delegate.lockInterruptibly(); }
    @Override public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return delegate.tryLock(time, unit);
    }
    @Override public void unlock() { delegate.unlock(); }
    @Override public Condition newCondition() {
        return delegate.newCondition();
    }

    public static void main(String[] args) {
        InstrumentedLock lock = new InstrumentedLock();
        lock.lock();
        lock.unlock();
        System.out.println("Average wait time: " + lock.getAverageWaitNanos());
        System.out.println("Success rate: " + lock.getSuccessRate());

    }


}