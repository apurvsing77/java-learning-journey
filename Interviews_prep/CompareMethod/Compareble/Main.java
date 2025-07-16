package Interviews_prep.CompareMethod.Compareble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list =new ArrayList<>();
        list.add(new Student(101,"apurv"));
        list.add(new Student(102,"Aman"));
        list.add(new Student(103,"amit"));

        Collections.sort(list);
        for (Student st : list)
        System.out.println(st);
    }
}
