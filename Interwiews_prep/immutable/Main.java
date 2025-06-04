package Interwiews_prep.immutable;

public class Main {
    public static void main(String[] args) {
        Contact con = new Contact("32112332","12365478","4566987450");
        Employee emp = new Employee(111111,36,"apurv Kumar","C-6/17-roshan nagar",con);

        Contact con2 = new Contact("32112000332","120000365478","45600006987450");
        Employee emp2 = new Employee(100001,46,"Aman","C-6/17-ismilpur nagar",con2);


        System.out.println(emp);

        System.out.println(emp.hashCode());
        con = con2;
        emp = emp2;
        System.out.println("njhlafhl"+emp);
        System.out.println(emp.hashCode());

    }
}
