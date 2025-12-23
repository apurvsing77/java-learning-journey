package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.abstraction.Car;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.concretImplementation.ElectricEngine;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.concretImplementation.PetrolEngine;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.implemntor.Engine;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.refineAbstraction.Sedan;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.refineAbstraction.Truck;

public class Main {
    public static void main(String[] args){

        Engine engine = new ElectricEngine();
        Car car = new Sedan(engine);
        car.drive();
        Engine engine3 = new PetrolEngine();
        Car car3 = new Sedan(engine3);
        car3.drive();


        Engine engine2 = new PetrolEngine();
        Car car2 = new Truck(engine2);
        car2.drive();
        Engine engine4 = new ElectricEngine();
        Car car4 = new Truck(engine4);
        car4.drive();
    }
}
