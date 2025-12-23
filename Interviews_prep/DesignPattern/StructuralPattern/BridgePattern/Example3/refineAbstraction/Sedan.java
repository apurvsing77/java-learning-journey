package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.refineAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.abstraction.Car;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.implemntor.Engine;

public class Sedan extends Car {
    public Sedan(Engine engine) {
        super(engine);
    }

    @Override
    public void drive() {

        System.out.println("Sedan is driving");
        engine.start();
        System.out.println("Sedan is running");

    }
}
