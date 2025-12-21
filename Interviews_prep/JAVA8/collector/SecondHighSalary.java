package Interviews_prep.JAVA8.collector;

import java.util.*;
import java.util.stream.Collectors;

public class SecondHighSalary {

    public static void main(String[] args){


    List<Employee> empList = Arrays.asList(

            new Employee(1000, "John"),
            new Employee(2000, "Jane"),
            new Employee(3000, "Bob"),
            new Employee(4000, "Alice"),
            new Employee(5000, "Mike"),
            new Employee(6000, "John2"),
            new Employee(10000, "Jane2"),
            new Employee(9000, "Bob2"),
            new Employee(9000, "Alice2"),
            new Employee(10000, "Mike2")

    );
        List<String> words = List.of("Java", "Stream", "API", "Code");
        List<Integer> nums = List.of(1, 2, 3, 2, 4, 5, 1);






        //Question 2: Group Words by Length
        Map<Integer ,List<String>> wordLength = words.stream().collect(Collectors.groupingBy(String::length));

        System.out.println("Word Length :"+wordLength);

                //Stream Operation  on second-Highest salary

   Optional<Integer> secondHighSalary = empList.stream().map(Employee::getSalary)
            .distinct()
            .sorted(Comparator.reverseOrder())
            .skip(1)
            .findFirst();
   if (secondHighSalary.isPresent()){
   int targetSalary = secondHighSalary.get();

        List<Employee> secondHighSalaryEarner = empList.stream()
                .filter(emp ->emp.getSalary() == targetSalary)
                .collect(Collectors.toList());


        System.out.println("Second High Salary: "+targetSalary);

        secondHighSalaryEarner.stream().forEach(emp ->
                System.out.println("Name : "+emp.getName()+" Salary : "+emp.getSalary()));
}

   //Question 3: Find Duplicate Elements in a List
        Set<Integer> seen = new HashSet<>();
        List<Integer> duplicateElement = nums.stream().filter(e-> !seen.add(e)).toList();

   System.out.println("Duplicate number is "+duplicateElement);


   }




}



class Employee{
    int salary;
    String name;
    Employee(int salary, String name ){
        this.salary = salary;
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}