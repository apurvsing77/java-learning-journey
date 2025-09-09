package Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.concreeetDecorater;

import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.component.Car;
import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.decorater.CarDecorator;

public class SunRoof extends CarDecorator {
    public SunRoof(Car car) {
        super(car);
    }
    @Override
    public void carModel() {
        carDecorator.carModel();
        System.out.println(" + Sunroof car");
    }
}
