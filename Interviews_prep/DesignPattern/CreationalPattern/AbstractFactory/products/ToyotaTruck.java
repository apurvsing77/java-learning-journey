package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products;

import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Truck;

public class ToyotaTruck implements Truck {
    @Override
    public String getModel() {
        return "Toyota Tundra";
    }
}