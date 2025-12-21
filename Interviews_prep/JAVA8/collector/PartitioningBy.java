package Interviews_prep.JAVA8.collector;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningBy {
    public static void main(String[] args){
        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple",                                                 "Banana", "Orange", "Apple", "Banana", "Orange");
        List<String> fruitsList2 = Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry");


        List<Persons2> people = Arrays.asList(
                new Persons2("Alice", 25, "IT"),
                new Persons2("Bob", 30, "HR"),
                new Persons2("Charlie", 22, "IT"),
                new Persons2("David", 35, "HR"),
                new Persons2("Eve", 28, "IT")
        );


        Map<Boolean, List<String>> partitionByLength = fruitsList.stream().collect(Collectors.partitioningBy(
                fruit -> fruit.length() >5
        ));
        System.out.println("Length of string based on length"+partitionByLength);

    Map<Boolean, List<String>> partitionByVowel = fruitsList.stream().collect(Collectors.partitioningBy(
            fruit -> "AEIOUaeiou".indexOf(fruit.charAt(0)) >= 0
    ));
    System.out.println("Partition By vowel : "+partitionByVowel);

        Map<Boolean, Long> countByLength = fruitsList2.stream().collect(
                Collectors.partitioningBy(
                fruit->fruit.length() >5,
                        Collectors.counting()
        ));
        System.out.println("Count of long names: " + countByLength.get(true));
        System.out.println("Count of short names: " + countByLength.get(false));

        Map<Boolean, String> joinedByVowel = fruitsList2.stream().collect(
                Collectors.partitioningBy(
                        fruit-> "AEIOUaeiou".indexOf(fruit.charAt(0)) >=0,
                        Collectors.joining(", ","[","]")
                ));

        System.out.println("Vowel-starting fruits: " + joinedByVowel.get(true));
        System.out.println("Consonant-starting fruits: " + joinedByVowel.get(false));

        Map<Boolean, Map<String, Long>> countByDepartment = people.stream().collect(Collectors.partitioningBy(
                department->department.getDepartment().equalsIgnoreCase("it"),

                Collectors.groupingBy(
                        Persons2::getDepartment,
                        Collectors.counting()
                )
        ));
        System.out.println("Count of IT department: " + countByDepartment.get(true));
        System.out.println("Count of non-IT department: " + countByDepartment.get(false));

        Map<Boolean,IntSummaryStatistics> ageStats = people.stream().collect(Collectors.partitioningBy(
                age->age.getAge() >= 30,
               Collectors.summarizingInt(Persons2::getAge)
               /* Collectors.groupingBy(
                        age->age,
                        Collectors.summarizingInt(Persons2::getAge)
                )*/
        ));
        System.out.println("Young employees stats: " + ageStats.get(false));
        System.out.println("Senior employees stats: " + ageStats.get(true));

    }
}

class Persons2 {
    String name;
    int age;
    String department;

    Persons2(String name, int age, String department) {
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
}