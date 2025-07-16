package Interviews_prep.DesignPrinciple.SOLID_Principle.Example1;

public class ExpressShipping extends ShippingMethod {



    public ExpressShipping(String destination, double weight) {
        super(destination, weight);
    }

    @Override
    public double calculateCost() {
        return weight * 30;
    }

    @Override
    public String getDetails() {
      return "Express Shipping: " + destination + ", " + weight + "kg and total Cost is: "+30*weight;
    }
}
