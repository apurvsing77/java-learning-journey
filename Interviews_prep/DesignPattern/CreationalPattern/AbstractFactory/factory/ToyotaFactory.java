package Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.factory;

import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Car;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.Truck;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.VehicleFactory;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products.ToyotaCar;
import Interviews_prep.DesignPattern.CreationalPattern.AbstractFactory.products.ToyotaTruck;

public class ToyotaFactory implements VehicleFactory {
    @Override
    public Car createCar() {
        return new ToyotaCar();
    }

    @Override
    public Truck createTruck() {
        return new ToyotaTruck();
    }
}