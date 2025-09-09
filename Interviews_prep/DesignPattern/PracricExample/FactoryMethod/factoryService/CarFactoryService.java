package Interviews_prep.DesignPattern.PracricExample.FactoryMethod.factoryService;

import Interviews_prep.DesignPattern.PracricExample.FactoryMethod.factory.CarFactory;

public class CarFactoryService {
    private CarFactory factory;

    public CarFactoryService(CarFactory factory) {
        this.factory = factory;
    }
    public  void createCar() {
        factory.createCar();
    }
}
