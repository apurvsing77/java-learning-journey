package StringProblems;

public class EqualsMethod {
    int i;
    String name;

    public EqualsMethod(int i, String name) {

        this.name=name;
        this.i=i;
    }

    public static void main(String[] args) {
      EqualsMethod e1= new EqualsMethod(12,"Apurv");
        EqualsMethod e2= new EqualsMethod(12,"Apurv");

        System.out.println(e1.equals(e2));
        String st1= new String("Apurv");
        String st2= new String("Apurv");
        System.out.println(st1.equals(st2));
    }
}
