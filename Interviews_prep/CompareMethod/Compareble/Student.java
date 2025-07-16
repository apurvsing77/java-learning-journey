package Interviews_prep.CompareMethod.Compareble;

public class Student implements Comparable<Student>{
    int id ;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
    public  int compareTo(Student std){
        return this.name.compareTo(std.name);
    }
}
