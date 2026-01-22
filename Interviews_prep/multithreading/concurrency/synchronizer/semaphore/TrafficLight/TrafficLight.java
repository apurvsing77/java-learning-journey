package Interviews_prep.multithreading.concurrency.synchronizer.semaphore.TrafficLight;

import java.util.concurrent.Semaphore;

import static java.lang.Thread.sleep;

public class TrafficLight {

    Semaphore sem;

    String name;

    public TrafficLight(Semaphore sem,String name) {
        this.name = name;
        this.sem = sem;


        new Thread(r1).start();
    }

    Runnable r1 = () ->{
        while(true) {
            try {
                System.out.println(name + " is waiting for a permit");
                sem.acquire();
                System.out.println(name + " gets a permit");
                System.out.println("Green");
                sleep(7000);
                System.out.println("Yellow");
                sleep(3000);
                System.out.println("Red");
                sleep(3000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
//                System.out.println(name + " was interrupted.");
                break;
            } finally {
                System.out.println(name + " releases the permit. STOP.");
                sem.release();
            }
            try {
                sleep(2000);
            }catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    };
}
