package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.factory;

import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Car;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Truck;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.VehicleFactory;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products.HondaCar;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products.HondaTruck;

public class HondaFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new HondaCar();
    }

    @Override
    public Truck createTruck() {
        return new HondaTruck();
    }
}
