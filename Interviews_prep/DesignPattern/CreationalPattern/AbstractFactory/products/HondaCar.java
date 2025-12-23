package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products;


import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Car;

public class HondaCar implements Car {
    @Override
    public String getModel() {
        return "Honda Civic";
    }
}
