package Interviews_prep.DesignPattern.PracricExample.FactoryMethod.client;

import Interviews_prep.DesignPattern.PracricExample.FactoryMethod.factory.CarFactory;
import Interviews_prep.DesignPattern.PracricExample.FactoryMethod.factoryService.CarFactoryService;
import Interviews_prep.DesignPattern.PracricExample.FactoryMethod.product.SUVFactory;

public class Main {
    public static void main(String[] args) {
        CarFactoryService suvCae = new CarFactoryService(new SUVFactory());
        suvCae.createCar();
    }
}
