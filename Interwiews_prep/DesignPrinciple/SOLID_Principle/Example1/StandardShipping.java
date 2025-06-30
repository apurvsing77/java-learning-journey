package Interwiews_prep.DesignPrinciple.SOLID_Principle.Example1;

public class StandardShipping extends ShippingMethod {


    public StandardShipping(String destination, double weight) {
       super(destination, weight);
    }

    @Override
    public double calculateCost() {
        return weight * 15;
    }

    @Override
    public String getDetails() {
      return "Standard Shipping: " + destination + ", " + weight + "kg and total Cost is: "+15*weight;
    }
}
