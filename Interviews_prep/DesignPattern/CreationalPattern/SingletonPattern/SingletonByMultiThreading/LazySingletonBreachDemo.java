package Interviews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByMultiThreading;

public class LazySingletonBreachDemo implements Runnable {
    @Override
    public void run() {
        LazySingleton instance = LazySingleton.getInstance();
        System.out.println(Thread.currentThread().getName() + " - Instance HashCode: " + instance.hashCode());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new LazySingletonBreachDemo(), "Thread-1");
        Thread thread2 = new Thread(new LazySingletonBreachDemo(), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
