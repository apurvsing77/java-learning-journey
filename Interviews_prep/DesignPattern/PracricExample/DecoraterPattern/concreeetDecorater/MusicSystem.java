package Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.concreeetDecorater;

import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.component.Car;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.decorater.CarDecorator;

public class MusicSystem extends CarDecorator {
    public MusicSystem(Car car) {
        super(car);
    }
    @Override
    public void carModel() {
        carDecorator.carModel();
        System.out.println("+ Music System");
    }
}
