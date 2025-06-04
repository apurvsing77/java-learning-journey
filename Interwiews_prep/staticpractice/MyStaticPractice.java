package Interviews_prep.staticpractice;

public class MyStaticPractice {
    static { System.out.println("static block");  } // Sequence - 1
    { System.out.println("initialization block"); } // Sequence - 4
    public MyStaticPractice() {
        System.out.println("constructor");          // Sequence - 5
    }
    public static void staticMethod(){       // Sequence - 3
        System.out.println("static method");
    }
    public void instanceMethod() {           // Sequence - 6
        System.out.println("instance method");
    }
    public static void main(String[] args) {
        System.out.println("main method");   // Sequence - 2
        staticMethod();
        MyStaticPractice obj = new MyStaticPractice();
        obj.instanceMethod();
        MyStaticPractice obj1 = new MyStaticPractice();
    }

}
