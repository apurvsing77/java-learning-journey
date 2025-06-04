package Interwiews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonBySerialization;

import java.io.*;

public class SingletonSerializableProtected implements Serializable {
    private static final SingletonSerializableProtected instance = new SingletonSerializableProtected();

    private SingletonSerializableProtected() {
        System.out.println("Singleton constructor called");
    }

    public static SingletonSerializableProtected getInstance() {
        return instance;
    }

    // This method is called during deserialization to replace the deserialized object
    protected Object readResolve() {
        System.out.println("readResolve called");
        return getInstance(); // Return the existing instance
    }
}