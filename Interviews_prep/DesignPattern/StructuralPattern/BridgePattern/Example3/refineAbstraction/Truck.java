package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.refineAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.abstraction.Car;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.implemntor.Engine;

public class Truck extends Car {

    public Truck(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {

        System.out.println("Truck is driving");
        engine.start();
        System.out.println("Truck is running");

    }
}
