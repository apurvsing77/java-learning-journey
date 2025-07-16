package Interviews_prep;

public class ConstructorExample {

    int age;

    public ConstructorExample(int age) {
        this.age = age;
        System.out.println("This is Paramitrize Constructor"+age);
    }

    public ConstructorExample() {
        System.out.println("Default constructor");
    }
}
