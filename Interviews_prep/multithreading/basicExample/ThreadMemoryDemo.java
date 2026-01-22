package Interviews_prep.multithreading.basicExample; // Each thread gets its own stack

// Default stack sizes:
// - Linux x64: 1 MB
// - Windows: 1 MB  
// - macOS: 512 KB

// So 1000 threads = 1 GB memory JUST for stacks!
// Plus: Thread object (≈ 1 KB), ThreadLocal storage, metadata

import java.util.ArrayList;
import java.util.List;

// Code example showing memory consumption:
public class ThreadMemoryDemo {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        
        for (int i = 0; i < 1000; i++) {
            Thread t = new Thread(() -> {
                try {
                    Thread.sleep(10000); // Keep alive
                } catch (InterruptedException e) {}
            });
            t.start();
            threads.add(t);
        }
        
        Thread.sleep(2000);
        // Check memory usage in VisualVM/YourKit
        // You'll see ≈ 100MB extra memory!
    }
}