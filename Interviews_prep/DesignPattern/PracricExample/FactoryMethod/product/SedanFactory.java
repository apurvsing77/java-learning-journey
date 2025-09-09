package Interviews_prep.DesignPattern.PracricExample.FactoryMethod.product;

import Interviews_prep.DesignPattern.PracricExample.FactoryMethod.factory.CarFactory;

import javax.sql.rowset.CachedRowSet;

public class SedanFactory  implements CarFactory {
    @Override
    public void createCar() {
        System.out.println("Creating sedan car");
    }
}
