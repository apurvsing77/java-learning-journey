package Interwiews_prep.ExceptionHandling;

public class DemoTest {
    public static void main(String[] args) {
        int a = 10;
        int b = 0;
        try {
            throw new ArithmeticException("This is an exception");
//            int x = a/b;
            //System.out.println("hellow");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
