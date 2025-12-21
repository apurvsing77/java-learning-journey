package Interviews_prep.JAVA8.collector;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MappingMethod {
    public static void main(String[] args){

        List<Persons> people = Arrays.asList(
                new Persons("Alice", 25),
                new Persons("Bob", 30),
                new Persons("Charlie", 25),
                new Persons("David", 30)
        );

        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange");
        Map<String , Long> fruitRepetitionCount = fruitsList.stream().collect(Collectors.mapping(

                String::toUpperCase,
                Collectors.groupingBy(
                        fruits -> fruits,
                        Collectors.counting()
                ))
        );


        Map<String , Long> fruitRepetitionCount2 = fruitsList.stream().collect(Collectors.groupingBy(
                String::toUpperCase,
                Collectors.counting()
        ));
        System.out.println("Fruit Repetition Count2: "+fruitRepetitionCount2);


        Map<Integer,String> personGroupByAge = people.stream().collect(Collectors.groupingBy(
                Persons::getAge,
                Collectors.mapping(
                        Persons::getName,
                        Collectors.joining(", ","[", "]")

                )
        ));
        IntSummaryStatistics stats = fruitsList.stream().collect(Collectors.mapping(
                String::length,
                Collectors.summarizingInt(Integer::intValue)
        ));

        String result = fruitsList.stream()
                .collect(Collectors.mapping(
                        fruit -> fruit.length() > 5 ? fruit.toUpperCase() : fruit,
                        Collectors.joining(" | ")
                ));

        Map<Integer, String> initialsByAge = people.stream()
                .collect(Collectors.groupingBy(
                        Persons::getAge,
                        Collectors.mapping(
                                p -> p.getName().substring(0, 1), // Get first letter
                                Collectors.joining("-","[", "]")
                        )
                ));


        System.out.println("Fruit Repetition Count: "+fruitRepetitionCount);
        /*

        System.out.println("Person Group By Age: "+personGroupByAge);
        System.out.println("Stats: "+stats);
        System.out.println("Filtered Result: "+result);
        System.out.println("Initials By Age: "+initialsByAge);
        */
    }
}


class Persons {
    String name;
    int age;

    Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
}