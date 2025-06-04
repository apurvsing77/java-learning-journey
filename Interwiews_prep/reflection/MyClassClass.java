package Interviews_prep.reflection;

import Interviews_prep.Inheritance.Parent;

import java.lang.reflect.Method;
import java.util.Arrays;

public class MyClassClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Class clazz = Class.forName("Interviews_prep.Inheritance.Parent");
        System.out.println(clazz.getPackage().getName());

        Method[] methods = clazz.getDeclaredMethods();
        Parent pr = new Parent();
//        Arrays.stream(methods).map(
//                (method)->method.getReturnType() + " " + method.getName())
//                .forEach(System.out::println);

        Arrays.stream(methods).map((method)-> {
            try {
                return method.getName() +"  kjkfk  "+method.invoke(pr);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);

    }
}
