package Interviews_prep.immutable;

public final class Employee {

    private final int salary;
    private final int age;
    private final String name;
    private final String address;

    private  final Contact contactNumber;

    public Employee(int salary, int age, String name, String address, Contact contactNumber) {
        this.salary = salary;
        this.age = age;
        this.name = name;
        this.address = address;
        this.contactNumber = new Contact(contactNumber);    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Contact getContactNumber() {
        return new Contact(contactNumber);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "salary=" + salary +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNumber{"+
                  ", Personal Contact "+ contactNumber.getPersonal_contact() +
                ", Residential Contact "+contactNumber.getResidential_contact()+
                ", Emergency Contact " +contactNumber.getEmergency_contact()+
                '}';
    }
}
