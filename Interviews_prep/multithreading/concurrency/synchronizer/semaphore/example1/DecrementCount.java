package Interviews_prep.multithreading.concurrency.synchronizer.semaphore.example1;

import java.util.concurrent.Semaphore;

class DecrementCount{

    String name;
    Semaphore sem;

    DecrementCount(Semaphore sem, String name){
        this.name=name;
        this.sem=sem;

        new Thread(r2).start();
    }

    Runnable r2=()->{
        try{
            System.out.println(name+" is waiting for a permit");

            sem.acquire();

            System.out.println(name+" gets a permit");

            for (int i = 0; i < 5; i++) {

                Shared.count--;
                System.out.println(name+":"+ Shared.count);
                Thread.sleep(1000);

            }
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        };
        System.out.println(name+" release the permit:");

        sem.release();

    };
}