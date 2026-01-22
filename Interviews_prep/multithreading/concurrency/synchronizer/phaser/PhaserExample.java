package Interviews_prep.multithreading.concurrency.synchronizer.phaser;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Register main thread (count=1)

        Runnable worker = () -> {
            System.out.println(Thread.currentThread().getName() + " doing work for Phase 1");
            phaser.arriveAndAwaitAdvance(); // Wait for phase 1 to end
            System.out.println(Thread.currentThread().getName() + " doing work for Phase 2");
            phaser.arriveAndAwaitAdvance(); // Finish and leave
            System.out.println(Thread.currentThread().getName() + " doing work for Phase 3");
            phaser.arriveAndDeregister();

        };

        // Dynamically add 2 new threads
        phaser.register(); new Thread(worker).start();
        phaser.register(); new Thread(worker).start();

        // Main thread manages phases

        System.out.println("Phase 0 complete (Start)");
        phaser.arriveAndAwaitAdvance(); // Trip barrier for Phase 1

        System.out.println("Phase 1 complete");
        phaser.arriveAndAwaitAdvance(); // Trip barrier for Phase 2

        System.out.println("Phase 2 complete");
        phaser.arriveAndAwaitAdvance();

        System.out.println("Phase 3 complete (End)");
        phaser.arriveAndDeregister();
    }
}