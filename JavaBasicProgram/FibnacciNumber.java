package JavaBasicProgram;

public class FibnacciNumber {

    public static void main(String args[]) {
        int n1, n2, n3;
        n1 = 0;
        n2 = 1;
        System.out.print(n1 + " " + n2 + " ");
        for (int i = 3; i <= 10; i++) {
            n3 = n1 + n2;
            System.out.print(n3 + " ");
            n1 = n2;
            n2 = n3;

        }

    }
}
//
//package JavaBasicProgram;
//
//public class FibnacciNumber {
//
//    // Recursive method to find the nth Fibonacci number
//    public static int fibonacci(int n) {
//        if (n <= 1) {
//            return n; // Base case: return n if it's 0 or 1
//        } else {
//            return fibonacci(n - 1) + fibonacci(n - 2); // Recursive call
//        }
//    }
//
//    public static void main(String[] args) {
//        int terms = 3; // Number of Fibonacci terms to display
//
//        for (int i = 0; i < terms; i++) {
//            System.out.print(fibonacci(i) + " ");
//        }
//    }
//}
