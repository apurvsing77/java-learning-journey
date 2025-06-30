package Interwiews_prep.DesignPrinciple.SOLID_Principle.Example1;

public class Main {
    public static void main(String[] args) {
        StandardShipping s1 = new StandardShipping("delhi",10);
        StandardShipping s2 = new StandardShipping("mumbai",11);
        ExpressShipping s3 = new ExpressShipping("jaipur",15);
//        StoreShipping s4 = new StoreShipping("Pune",15);


        ShipmentService service = new ShipmentService();
        service.addShipping(s1);
        service.addShipping(s2);
        service.addShipping(s3);
        service.addShipping(new StoreShipping("Pune",15));

        service.displayAllShipment();
        System.out.println(service.calculateTotalCost());

    }
}
