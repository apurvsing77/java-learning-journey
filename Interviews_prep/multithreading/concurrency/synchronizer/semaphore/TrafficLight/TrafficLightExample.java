package Interviews_prep.multithreading.concurrency.synchronizer.semaphore.TrafficLight;

import java.util.concurrent.Semaphore;

public class TrafficLightExample {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(4,true);

        new TrafficLight(sem,"East");
        new TrafficLight(sem,"West");
        new TrafficLight(sem,"North");
        new TrafficLight(sem,"South");
    }
}
