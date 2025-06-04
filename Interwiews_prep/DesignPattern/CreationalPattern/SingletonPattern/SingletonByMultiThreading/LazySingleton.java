package Interwiews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByMultiThreading;

public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        System.out.println("LazySingleton constructor called");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            // Potential race condition here!
            instance = new LazySingleton();
        }
        return instance;
    }
}
