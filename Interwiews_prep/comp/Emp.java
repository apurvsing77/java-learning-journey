package Interwiews_prep.comp;



public class Emp implements Comparable<Emp> {

    private String name;
    private double phone;
    private int empId;

    @Override
    public int compareTo(Emp o) {
        return - this.name.compareTo(o.name);

    }

    public Emp (String name, double phone, int empId){
        this.name=name;
        this.phone=phone;
        this.empId=empId;
    }
    public String getName() {
        return name;
    }

    public double getPhone() {
        return phone;
    }

    public int getEmpId() {
        return empId;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", empId=" + empId +
                '}';
    }


}
