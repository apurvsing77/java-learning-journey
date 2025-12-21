package Interviews_prep.JAVA8.collector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args){
        List<Person> employees = Arrays.asList(
                new Person("Alice", "IT", 5000),
                new Person("Bob", "IT", 6000),
                new Person("Charlie", "HR", 4500),
                new Person("David", "HR", 4000),
                new Person("Eve", "IT", 5500)
        );

        List<String> fruitsList = Arrays.asList("Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange", "Apple", "Banana", "Orange");

        AtomicInteger index = new AtomicInteger(1);
        Map<Integer,String> fruitMap = fruitsList.stream().collect(Collectors.toMap(
                i -> index.getAndIncrement(),
                fruit->fruit,
                (existing, newOne)->existing
        ));

        System.out.println("Fruit Map: "+fruitMap);
        Map<String , Double> avgSalaryByDepartment = employees.stream().collect(Collectors.groupingBy(
                Person::getDepartment,
                Collectors.averagingDouble(Person::getSalary)
        ));

        Map<String , Long> fruitRepetitionCount = fruitMap.keySet().stream().collect(Collectors.groupingBy(
                fruitMap::get,
                Collectors.counting()
        ));
        System.out.println("Fruit Repetition Count: "+fruitRepetitionCount);



        System.out.println("Average Salary By Department: "+avgSalaryByDepartment);

    }
}

class Person {
    String name;
    String department;
    int salary;

    Person(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
    // getters omitted for brevity

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}