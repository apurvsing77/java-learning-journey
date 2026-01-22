package Interviews_prep.multithreading.concurrency.synchronizer.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ServiceInitializationExample {
    
    public static void main(String[] args) throws InterruptedException {
        // Services that need to be initialized
        String[] services = {"Database", "Cache", "FileSystem", "Network", "Security"};
        CountDownLatch initializationLatch = new CountDownLatch(services.length);
        
        System.out.println("Starting service initialization...");
        
        // Initialize all services concurrently
        for (String service : services) {
            new Thread(new ServiceInitializer(service, initializationLatch)).start();
        }
        
        // Wait for all services to initialize (with timeout)
        boolean allInitialized = initializationLatch.await(10, TimeUnit.SECONDS);
        
        if (allInitialized) {
            System.out.println("\nAll services initialized successfully!");
            System.out.println("Starting main application...");
        } else {
            System.out.println("\nTimeout! Some services failed to initialize.");
            System.out.println("Remaining services: " + initializationLatch.getCount());
        }
    }
    
    static class ServiceInitializer implements Runnable {
        private final String serviceName;
        private final CountDownLatch latch;
        
        ServiceInitializer(String serviceName, CountDownLatch latch) {
            this.serviceName = serviceName;
            this.latch = latch;
        }
        
        @Override
        public void run() {
            try {
                System.out.println("Initializing " + serviceName + "...");
                
                // Simulate initialization time
                int initTime = (int) (Math.random() * 8000);
                Thread.sleep(initTime);
                
                // Simulate random failure
                if (Math.random() < 0.1) { // 10% chance of failure
                    throw new RuntimeException(serviceName + " initialization failed!");
                }
                
                System.out.println(serviceName + " initialized successfully in " + initTime + "ms");
                
            } catch (Exception e) {
                System.err.println("Error initializing " + serviceName + ": " + e.getMessage());
            } finally {
                // Always count down, whether successful or not
                latch.countDown();
            }
        }
    }
}