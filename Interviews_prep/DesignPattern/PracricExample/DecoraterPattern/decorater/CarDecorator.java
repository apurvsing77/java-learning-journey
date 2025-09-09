package Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.decorater;

import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.component.Car;

public abstract class CarDecorator implements Car{
    protected Car carDecorator;

    public CarDecorator(Car car) {
        this.carDecorator = car;
    }

    public void carModel(){
        carDecorator.carModel();
    }
}
