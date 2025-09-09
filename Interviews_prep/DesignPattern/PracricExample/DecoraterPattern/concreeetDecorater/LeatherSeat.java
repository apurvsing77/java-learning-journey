package Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.concreeetDecorater;

import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.component.Car;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.decorater.CarDecorator;

public class LeatherSeat extends CarDecorator {

    public LeatherSeat(Car car) {
        super(car);
    }
    @Override
    public void carModel(){
        carDecorator.carModel();
        System.out.println("+ leather Seat");
    }
}
