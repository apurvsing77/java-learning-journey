package Interviews_prep.JAVA8.FunctionalInterface;

public class FunctionalTest {
    public static void main(String[] args) {
        MyFunctionalInterface obj = (int x, int y) -> x * y;
        System.out.println(obj.mult(12,10));
    }
}
