package Interwiews_prep.multithreading.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        Semaphore sem=new Semaphore(1, true);
        new IncrementCount(sem,"A");
        new DecrementCount(sem,"B");
//        new IncrementCount(sem,"C");
//        new DecrementCount(sem,"D");

    }
}





