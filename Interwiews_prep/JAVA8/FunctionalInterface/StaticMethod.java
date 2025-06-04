package Interwiews_prep.JAVA8.FunctionalInterface;

@FunctionalInterface
public interface StaticMethod {
    void  staticDisplay();

    static void show(){
        System.out.println("Static method in java");
    }
}
