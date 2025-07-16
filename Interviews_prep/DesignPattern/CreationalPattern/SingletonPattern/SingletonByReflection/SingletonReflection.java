package Interviews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByReflection;


class SingletonReflection {
    private static SingletonReflection instance;

    private SingletonReflection() {
        if (instance != null){
            throw new IllegalStateException("Singleton instance already created");
        }
        System.out.println("Singleton constructor called");
    }

    public static SingletonReflection getInstance() {
        if (instance == null) {
            instance = new SingletonReflection();
        }
        return instance;
    }
}
