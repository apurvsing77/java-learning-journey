package Interviews_prep.CompareMethod.Comparator;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAndSort {
    public static void main(String[] args) {
        List<Fruit> fruits = Arrays.asList(
            new Fruit("Apple", "Red"),
            new Fruit("Banana", "Yellow"),
            new Fruit("Grapes", "Green"),
            new Fruit("Cherry", "Red"),
            new Fruit("Lemon", "Yellow"),
            new Fruit("Pear", "Green")
        );

        Map<String, List<Fruit>> groupedAndSorted = fruits.stream()
            .collect(Collectors.groupingBy(
                Fruit::getColor,
                Collectors.collectingAndThen(
                    Collectors.toList(),
                    list -> {
                        list.sort(Comparator.comparing(Fruit::getName));
                        return list;
                    }
                )
            ));

        System.out.println("Grouped by color, sorted by name:");
        groupedAndSorted.forEach((color, fruitList) -> 
            System.out.println(color + " -> " + fruitList)
        );
    }
}
