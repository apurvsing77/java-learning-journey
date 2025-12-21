package Interviews_prep.JAVA8.StreamAPI;

import java.util.Arrays;
import java.util.List;

public class StudentTest {
    public static void main(String[] args){
        Student student1 = new Student("John", 20, 1, "Male", "Computer Science", 85);
        Student student2 = new Student("Jane", 21, 2, "Female", "Computer Science", 90);
        Student student3 = new Student("Bob", 22, 3, "Male", "Computer Science", 75);
        Student student4 = new Student("Alice", 20, 4, "Female", "Computer Science", 80);
        Student student5 = new Student("Mike", 21, 5, "Male", "Computer Science", 70);

        List<Student> students = Arrays.asList(student1, student2, student3, student4, student5);
        students.stream().forEach(System.out::println);
    }
}
