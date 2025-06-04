package Interwiews_prep.JAVA8.Supplier;

public class SupplierTest {
    public static void main(String[] args) {

     supplierInterface sup = () -> "hello , from Supplier greeting ";
        System.out.println(sup.processer());
    }
}
