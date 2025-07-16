package Interviews_prep.Inheritance;

public class Child extends Interviews_prep.Inheritance.Parent {
    int age;

    public Child(int age) {
        this.age = age;
    }
    public  void show(){
        System.out.println("This is child class show method");
    }

    public Child() {
    }

    public  void childDisplay(){
        System.out.println("This is Child class ChildDisplay method");

    }
}
