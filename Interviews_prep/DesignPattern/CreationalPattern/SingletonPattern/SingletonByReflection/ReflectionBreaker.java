package Interviews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByReflection;


import java.lang.reflect.Constructor;

public class ReflectionBreaker {
    public static void main(String[] args) {
//        SingletonReflection instance1 = SingletonReflection.getInstance();
        SingletonReflection instance3 = null;    //SingletonReflection.getInstance();

        SingletonReflection instance2 = null;

        try {
            Constructor<?>[] constructors = SingletonReflection.class.getDeclaredConstructors();
            for (Constructor<?> constructor : constructors) {
                // Make the private constructor accessible
                constructor.setAccessible(true);
                instance2 = (SingletonReflection) constructor.newInstance();
                instance3 = (SingletonReflection) constructor.newInstance();
                break; // We only need to invoke it once
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance3.hashCode());
        System.out.println("Instance 3: " + instance2.hashCode());
//        System.out.println("Are they the same? " + (instance1 == instance3));


        System.out.println("Are they the same? " + (instance3 == instance2));
    }
}