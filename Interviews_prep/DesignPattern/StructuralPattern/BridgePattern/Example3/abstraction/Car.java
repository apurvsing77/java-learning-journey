package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.abstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.implemntor.Engine;

public abstract class Car {

    protected Engine engine;

    protected Car(Engine engine){
        this.engine = engine;

    }
    public abstract void drive();
}
