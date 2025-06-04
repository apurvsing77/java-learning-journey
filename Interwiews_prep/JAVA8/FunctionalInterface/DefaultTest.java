package Interwiews_prep.JAVA8.FunctionalInterface;

public class DefaultTest {

    public static void main(String[] args) {
        DefaultMethod def =(a,b) -> a+b;
        int result= def.show(10,12);
        System.out.println("Addition :"+result);
    }
}
