package Interviews_prep.multithreading.RenterentLockExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RecursiveLockExample {
    private final Lock lock = new ReentrantLock();
    private int count = 0;
    
    public void outer() {
        lock.lock();
        try {
            System.out.println("Outer: lock count = " + ((ReentrantLock)lock).getHoldCount()+"Thread Name:"+Thread.currentThread().getName());
            inner();  // Re-enters same lock!
        } finally {
            lock.unlock();
        }
    }
    
    private void inner() {
        lock.lock();  // Same thread can re-acquire!
        try {
            System.out.println("Inner: lock count = " + ((ReentrantLock)lock).getHoldCount()+"Thread Name:"+Thread.currentThread().getName());
            count++;
        } finally {
            lock.unlock();
        }
    }
    
    public static void main(String[] args) {
        RecursiveLockExample example = new RecursiveLockExample();
        example.outer();  // Works fine - reentrant lock
    }
}