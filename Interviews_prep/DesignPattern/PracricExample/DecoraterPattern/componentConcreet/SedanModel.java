package Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.componentConcreet;

import Interviews_prep.DesignPattern.PracricExample.DecoraterPattern.component.Car;

public class SedanModel implements Car {
    @Override
    public void carModel() {
        System.out.println("Sedan car");
    }
}
