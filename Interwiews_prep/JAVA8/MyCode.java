package Interwiews_prep.JAVA8;


import java.util.*;
import java.util.stream.*;
import java.util.function.Function;

class MyCode {
    public static void main (String[] args) {
        List<Integer> list = Arrays.asList(1,2,1,3,2,4,3,4,1,1,1,5,5,6,6,7);
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting()));
        System.out.println(map);
    }
}

