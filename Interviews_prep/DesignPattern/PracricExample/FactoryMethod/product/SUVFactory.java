package Interviews_prep.DesignPattern.PracricExample.FactoryMethod.product;

import Interviews_prep.DesignPattern.PracricExample.FactoryMethod.factory.CarFactory;

public class SUVFactory implements CarFactory {
    @Override
    public void createCar() {
        System.out.println("Creating SUV car");
    }
}
