package Interwiews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonBySerialization;
import java.io.*;

public class SerializationBreaker {
    public static void main(String[] args) {
        SingletonSerializableProtected instance1 = SingletonSerializableProtected.getInstance();
        SingletonSerializableProtected instance2 = null;

        // Serialize the singleton instance
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            oos.writeObject(instance1);
        } catch (IOException e) {
            e.printStackTrace();
        }

// Deserialize the singleton instance
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            instance2 = (SingletonSerializableProtected) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode());
        System.out.println("Are they the same? " + (instance1 == instance2));
    }
}