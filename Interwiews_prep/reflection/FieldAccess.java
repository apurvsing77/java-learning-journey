package Interviews_prep.reflection;

import Interviews_prep.Inheritance.Parent;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldAccess {
    public static void main(String[] args) throws  Exception  {
        Parent instance = new Parent();

        Class<?> classDetails = instance.getClass();

        Field[] fields =classDetails.getDeclaredFields();
        for (Field field:fields) {
        field.setAccessible(true);

        Object obj = field.get(instance);
//            System.out.println(field.getName()+" ___"+obj);
            if (field.getName() == "deta3") {

                field.set(instance,"JAVAScript........");
            }
        }

//        for (Field field:fields) {
//            field.setAccessible(true);
//
//            Object obj = field.get(instance);
//            System.out.println(field.getName()+" ___"+obj);
//
//        }
        Arrays.stream(fields).map(field -> {
            try {
               return field.getName()+"---"+field.get(instance);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).forEach(System.out::println);

    }
}
//        String oldData = (String)field.get(instance);
//        System.out.println( oldData);
