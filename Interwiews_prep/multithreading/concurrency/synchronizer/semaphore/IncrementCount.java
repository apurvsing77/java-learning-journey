package Interwiews_prep.multithreading.concurrency.synchronizer.semaphore;

import java.util.concurrent.Semaphore;

class IncrementCount{

    String name;
    Semaphore sem;

    IncrementCount(Semaphore sem, String name){
        this.name=name;
        this.sem=sem;

        new Thread(r1).start();
}

Runnable r1=()->{
    try{
        System.out.println(name+" is waiting for a permit");

        sem.acquire();

        System.out.println(name+" gets a permit");

        for (int i = 0; i < 5; i++) {

            Shared.count++;
            System.out.println(name+":"+ Shared.count);
            Thread.sleep(1000);

        }
    }catch (InterruptedException e){
        throw new RuntimeException(e);
    };
//    sem.release();
    System.out.println(name+" release the permit:");


    };
}
