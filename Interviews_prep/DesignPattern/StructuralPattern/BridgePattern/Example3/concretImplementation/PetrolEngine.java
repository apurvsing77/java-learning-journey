package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.concretImplementation;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example3.implemntor.Engine;

public class PetrolEngine implements Engine {
    @Override
    public void start() {

        System.out.println("Petrol Engine started");
    }
}
