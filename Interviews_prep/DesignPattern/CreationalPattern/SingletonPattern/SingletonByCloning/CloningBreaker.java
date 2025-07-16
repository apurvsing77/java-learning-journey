package Interviews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByCloning;

public class CloningBreaker {
    public static void main(String[] args) {
        SingletonCloneable instance1 = SingletonCloneable.getInstance();
        SingletonCloneable instance2 = null;

        try {
            instance2 = (SingletonCloneable) instance1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode());
        System.out.println("Are they the same? " + (instance1 == instance2));
    }
}
