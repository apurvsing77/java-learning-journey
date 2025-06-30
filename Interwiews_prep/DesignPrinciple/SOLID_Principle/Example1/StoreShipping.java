package Interwiews_prep.DesignPrinciple.SOLID_Principle.Example1;

public class StoreShipping extends ShippingMethod {



    public StoreShipping(String destination, double weight) {
        super(destination, weight);
    }

    @Override
    public double calculateCost() {
        return 0;
    }

    @Override
    public String getDetails() {
      return "Store Shipping: " + destination + ", " + weight + "kg and total Cost is: "+0*weight;
    }
}
