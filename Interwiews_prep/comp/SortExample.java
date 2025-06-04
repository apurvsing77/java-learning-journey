package Interwiews_prep.comp;

import java.util.ArrayList;
import java.util.Collections;


public class SortExample {
    public static void main(String[]args){
        ArrayList<Emp> emps =new ArrayList<>();
        emps.add(new Emp("Apurv",21312312,12));
        emps.add(new Emp("Poojisha",21312320,56));
        emps.add(new Emp("Anubhav",21312310,7));
        System.out.println(emps);
        Collections.sort(emps);
        //Comparable
        System.out.println(emps);


    }
}
