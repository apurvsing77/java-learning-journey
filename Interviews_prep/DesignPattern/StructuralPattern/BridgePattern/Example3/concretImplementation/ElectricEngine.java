package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.concretImplementation;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.implemntor.Engine;

public class ElectricEngine implements Engine {
    @Override
    public void start() {
        System.out.println("Electric Engine started");

    }
}
