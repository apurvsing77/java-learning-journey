package Interviews_prep.multithreading.ExecutorFramework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static java.util.concurrent.Executors.*;

public class ExecutorServiceExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = newFixedThreadPool(4);
        
        // Submit Callable tasks
        List<Future<String>> futures = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            int taskId = i;
            Callable<String> task = () -> {
                Thread.sleep(1000);
                return "Task-" + taskId + " completed by " 
                       + Thread.currentThread().getName();
            };
            futures.add(executor.submit(task));
        }
        
        // Collect results
        for (Future<String> future : futures) {
            System.out.println(future.get());  // Blocks until ready
        }
        
        // Proper shutdown
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}