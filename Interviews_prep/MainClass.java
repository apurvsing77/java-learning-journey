package Interviews_prep;

import Interviews_prep.Inheritance.Child;
import Interviews_prep.Inheritance.Parent;

public class MainClass {
    public static void main(String[] args) {
//        ConstructorExample cs = new ConstructorExample(24);
//        ConstructorExample cs2 = new ConstructorExample();
        //Inheritance Example

        // simple message
        System.out.println("abc");
        System.out.println("abc");
       Parent parent = new Parent();
           parent.show();
           parent.display();


        Child child = new Child();
           child.show();
           child.childDisplay();
//           child.display();





    }
}
