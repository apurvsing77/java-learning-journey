package Interwiews_prep.multithreading.basicExample;

class SharedResource {
    synchronized void waitHere() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting...");
            wait();
            System.out.println(Thread.currentThread().getName() + " is resumed!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void notifyOne() {
        System.out.println("Notifier thread is notifying one thread...");
        notifyAll();
//        notify();
    }
}

public class NotifyOneExample {
    public static void main(String[] args) throws InterruptedException {
        SharedResource resource = new SharedResource();


        for (int i = 1; i <= 4; i++) {
            Thread t = new Thread(() -> resource.waitHere(), "WaitingThread-" + i);
            t.start();
        }

        Thread.sleep(2000);

        // Notifier thread
        Thread notifier = new Thread(() -> resource.notifyOne(), "NotifierThread");
        notifier.start();
    }
}
