package Interviews_prep.DesignPrinciple.SOLID_Principle.Example1;

abstract class ShippingMethod {

    protected String destination;
    protected double weight;

    public ShippingMethod(String destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public abstract double calculateCost() ;

    public abstract String getDetails() ;
}
