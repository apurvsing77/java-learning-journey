package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products;

import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Car;

public class ToyotaCar implements Car {
    @Override
    public String getModel() {
        return "Toyota Camry";
    }
}
