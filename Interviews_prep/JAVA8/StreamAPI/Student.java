package Interviews_prep.JAVA8.StreamAPI;

public class Student {
    private String name;
    private int age;
    private int rollNo;
    private String gender;
    private String course;
    private int marks;

    public Student(String name, int age, int rollNo, String gender, String course, int marks) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.gender = gender;
        this.course = course;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rollNo=" + rollNo +
                ", gender='" + gender + '\'' +
                ", course='" + course + '\'' +
                ", marks=" + marks +
                '}';
    }
}
