package Interviews_prep.JAVA8.collector;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args){

        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange");

        Map<String, Integer> fruitsCount = fruitsList.stream()
                .collect(Collectors.toMap(
                        fruit -> fruit,  // Key mapper
                        fruit -> 1,      // Value mapper (initialize count to 1)
                        (existing, newOne) -> existing + 1  // Merge function to increment count
                ));
        Map<String , Long> fruitsCount2 = fruitsList.stream().collect(Collectors.groupingBy(
                fruit -> fruit,
                       //OR
               // Function.identity(),
                Collectors.counting()
        ));
        Map<String , Long> withOutApple = fruitsList.stream().filter(fruits -> !fruits.equalsIgnoreCase("apple")).collect(Collectors.groupingBy(
                fruits -> fruits,
                Collectors.counting()
        ));
        Map<Integer , String> bylength = fruitsList.stream().collect(Collectors.groupingBy(
                String::length,
                TreeMap::new,
                Collectors.joining(", ")
//                Collectors.counting()
        ));
                System.out.println("Fruits Count: "+fruitsCount);
        System.out.println("Fruits Count2: "+fruitsCount2);
        System.out.println("Without Apple: "+withOutApple);
        System.out.println("Bylength: "+bylength);
    }
}
