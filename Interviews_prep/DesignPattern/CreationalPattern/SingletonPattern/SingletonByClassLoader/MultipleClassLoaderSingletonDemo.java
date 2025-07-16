package Interviews_prep.DesignPattern.CreationalPattern.SingletonPattern.SingletonByClassLoader;

import java.io.File;

import java.net.URL;
import java.net.URLClassLoader;
import java.lang.reflect.Method;
public class MultipleClassLoaderSingletonDemo {
    public static void main(String[] args) throws Exception {
        // Create a temporary directory to hold a copy of the Singleton class
        File tempDir1 = new File("temp1");
        tempDir1.mkdirs();

        // Copy the Singleton.class file to both temporary directories
        String className = LoaderInSingleton.class.getName().replace('.', '/') + ".class";
        URL classUrl = LoaderInSingleton.class.getResource("/" + className);
        if (classUrl == null) {
            System.err.println("Error finding Singleton.class");
            return;
        }
        java.nio.file.Files.copy(java.nio.file.Paths.get(classUrl.toURI()), java.nio.file.Paths.get(tempDir1.getPath(), className));

        // Create two different URLClassLoader instances
        URLClassLoader classLoader1 = new URLClassLoader(new URL[]{tempDir1.toURI().toURL()});

        // Load the Singleton class through each class loader
        Class<?> singletonClass1 = classLoader1.loadClass(LoaderInSingleton.class.getName());

        // Get the getInstance() method using reflection
        Method getInstanceMethod1 = singletonClass1.getMethod("getInstance");

        // Invoke getInstance() on both loaded classes
        Object instanceFromLoader1 = getInstanceMethod1.invoke(null);

        System.out.println("Instance from ClassLoader 1: " + instanceFromLoader1.hashCode() + " (Loader: " + instanceFromLoader1.getClass().getClassLoader() + ")");

        // Clean up temporary directories
        deleteDirectory(tempDir1);


        File tempDir2 = new File("temp2");
        tempDir2.mkdirs();

        // Copy the Singleton.class file to both temporary directories
        String className2 = LoaderInSingleton.class.getName().replace('.', '/') + ".class";
        URL classUrl2 = LoaderInSingleton.class.getResource("/" + className2);
        if (classUrl2 == null) {
            System.err.println("Error finding Singleton.class");
            return;
        }
        java.nio.file.Files.copy(java.nio.file.Paths.get(classUrl2.toURI()), java.nio.file.Paths.get(tempDir2.getPath(), className));

        // Create two different URLClassLoader instances
        URLClassLoader classLoader2 = new URLClassLoader(new URL[]{tempDir2.toURI().toURL()});

        // Load the Singleton class through each class loader
        Class<?> singletonClass2 = classLoader2.loadClass(LoaderInSingleton.class.getName());

        // Get the getInstance() method using reflection
        Method getInstanceMethod2 = singletonClass2.getMethod("getInstance");

        // Invoke getInstance() on both loaded classes
        Object instanceFromLoader2 = getInstanceMethod2.invoke(null);

        System.out.println("Instance from ClassLoader 2: " + instanceFromLoader2.hashCode() + " (Loader: " + instanceFromLoader2.getClass().getClassLoader() + ")");

        // Clean up temporary directories
        deleteDirectory(tempDir2);



        System.out.println("Are they the same instance? " + (instanceFromLoader1 == instanceFromLoader2));


    }

    private static void deleteDirectory(File directory) {
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
            directory.delete();
        }
    }
}
