package Interviews_prep.JAVA8.MapExample;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /**List<Student> list = Arrays.asList(new Student(101,"Apurv","vinod kumar","Rinku Devi","MCA"),
                new Student(102,"anubhav","alok kumar","priyanka Devi","B.tech"),
                new Student(103,"lacho","alok kumar","priyanka Devi","MCA"),
                new Student(104,"kk","vinod kumar","Rinku Devi","B.tech")
              );**/
        Student s1 = new Student(101,"Apurv","vinod kumar","Rinku Devi","MCA") ;
        Student s2 = new Student(101,"Apurv","vinod kumar","Rinku Devi","MCA");
        Student s3 = new Student(103,"lacho","alok kumar","priyanka Devi","MCA");
        Student s4 =  new Student(104,"kk","vinod kumar","Rinku Devi","B.tech");

//        Map<Integer,Student> stdmap1 =list.stream().collect(Collectors.toMap(Student::getId, Student -> Student));

//        Map<Integer,List<Student>> stdmap2 =list.stream().collect(Collectors.groupingBy(Student::getId ));
//        System.out.println(stdmap2);
//        System.out.println(stdmap1);


        Map<Student,String> stdMap = new HashMap<>();
        stdMap.put(s1,"pass");
        stdMap.put(s2,"Fail");
        stdMap.put(s3,"Fail");
        stdMap.put(s4,"pass");

        System.out.println(stdMap);
        System.out.println(stdMap.size());
    }
}
