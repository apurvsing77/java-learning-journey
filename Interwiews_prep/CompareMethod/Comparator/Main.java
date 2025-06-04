package Interwiews_prep.CompareMethod.Comparator;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<> (new MyComparetor());
        t.add(10);
        t.add(8);
        t.add(11);
        t.add(6);
        System.out.println("With sorting"+t);
    }
}
