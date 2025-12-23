package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products;

import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Truck;

public class HondaTruck implements Truck {
    @Override
    public String getModel() {
        return "Honda Ridgeline";
    }
}
