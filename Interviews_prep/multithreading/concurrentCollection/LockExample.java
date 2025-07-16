package Interviews_prep.multithreading.concurrentCollection;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Greate greate = new Greate();
        MyThread t1 = new MyThread(greate,"Apurv");
        MyThread t2 = new MyThread(greate,"Karan");

        t1.start();
        t2.start();
    }
}
class Greate{
    ReentrantLock l = new ReentrantLock();
    public void wish(String name) throws InterruptedException {
//        l.lock();
        System.out.println(name+"Come Fist");
        if (l.tryLock(11, TimeUnit.SECONDS)){
        for (int i = 0; i <5 ; i++) {
            try {
                Thread.sleep(2000);
                System.out.println("Calling by "+name);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
          }
            l.unlock();
        } else {
            System.out.println("Waited by "+name);

        }

    }
}
class MyThread extends Thread{
    Greate greate;
    String name;
    public MyThread(Greate greate,String name) {
        this.greate = greate;
        this.name = name;
    }
    public void run() {
        try {
            greate.wish(name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
