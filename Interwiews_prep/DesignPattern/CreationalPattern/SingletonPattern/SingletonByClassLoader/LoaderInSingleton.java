package Interwiews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByClassLoader;


public class LoaderInSingleton {
    private static LoaderInSingleton instance;

    private LoaderInSingleton() {
        System.out.println("Singleton constructor called by: " + this.getClass().getClassLoader());
    }

    public static LoaderInSingleton getInstance() {
        if (instance == null) {
            instance = new LoaderInSingleton();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("Singleton instance (" + this.hashCode() + ") doing something.");
    }
}

