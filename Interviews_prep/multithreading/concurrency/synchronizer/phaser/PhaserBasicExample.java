package Interviews_prep.multithreading.concurrency.synchronizer.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserBasicExample {
    
    public static void main(String[] args) throws InterruptedException {
        // Create a phaser with initial 0 parties
        Phaser phaser = new Phaser() {
            // Override onAdvance to add custom behavior when phase advances
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                System.out.println("\n=== Phase " + phase + " completed! ===");
                System.out.println("Registered parties: " + registeredParties);
                System.out.println("Next phase: " + (phase + 1) + "\n");
                
                // Return false to continue, true to terminate
                return phase >= 3; // Terminate after phase 3
            }
        };
        
        System.out.println("Starting Phaser demonstration...");
        System.out.println("Initial registered parties: " + phaser.getRegisteredParties());
        
        // Phase 0: Register 3 workers
        System.out.println("\n=== Registering 3 workers for Phase 0 ===");
        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(i, phaser)).start();
        }
        
        Thread.sleep(2000); // Give workers time to register and start
        
        // Phase 1: Register 2 more workers
        System.out.println("\n=== Registering 2 more workers for Phase 1 ===");
        for (int i = 4; i <= 5; i++) {
            new Thread(new Worker(i, phaser)).start();
        }
        
        Thread.sleep(5000); // Let all phases complete
        
        // Check final state
        System.out.println("\n=== FINAL STATE ===");
        System.out.println("Current phase: " + phaser.getPhase());
        System.out.println("Registered parties: " + phaser.getRegisteredParties());
        System.out.println("Is terminated: " + phaser.isTerminated());
    }
    
    static class Worker implements Runnable {
        private final int id;
        private final Phaser phaser;
        
        Worker(int id, Phaser phaser) {
            this.id = id;
            this.phaser = phaser;
            
            // Register this worker as a new party
            phaser.register();
            System.out.println("Worker " + id + " registered. Total parties: " + 
                             phaser.getRegisteredParties());
        }
        
        @Override
        public void run() {
            try {
        // Phase 0 work
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
                System.out.println("Worker " + id + " starting Phase " + phaser.getPhase());
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println("Worker " + id + " completed Phase " + phaser.getPhase());
                
                // Wait for all workers to complete current phase
                int phase = phaser.arriveAndAwaitAdvance();

        // Phase 1 work
        System.out.println("********************************************************");
                System.out.println("Worker " + id + " starting Phase " + phase);
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println("Worker " + id + " completed Phase " + phase);
                
                // Wait for all workers
                phase = phaser.arriveAndAwaitAdvance();

        // Phase 2 work
        System.out.println("--------------------------------------------------");
                System.out.println("Worker " + id + " starting Phase " + phase);
                Thread.sleep((long) (Math.random() * 2000));
                System.out.println("Worker " + id + " completed Phase " + phase);
                
                // Deregister after Phase 2
                phaser.arriveAndDeregister();
                System.out.println("Worker " + id + " deregistered. Remaining: " + 
                                 phaser.getRegisteredParties());
                
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                phaser.arriveAndDeregister(); // Clean up on interruption
            }
        }
    }
}