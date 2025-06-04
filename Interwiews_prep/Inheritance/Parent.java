package Interviews_prep.Inheritance;

public class Parent {
    int age;
      private String deta ="java Reflection";
    private String deta2 ="java JDBC";
    private String deta4 ="java Servlet";

    private String deta3 ="java Springboot";



    public Parent() {
    }

    public Parent(int age) {
        this.age = age;
    }
    public  void show(){
        System.out.println("This is parent class show method");

    }
    public  int result(){

        return  20+40;
    }

public void display(){
        System.out.println("This is parent class Display method");

    }
    public static String staticMessage() {
        return "This is a static message";
    }
}
