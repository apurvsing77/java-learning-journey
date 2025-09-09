package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.concreateImplementor;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.implementor.Colour;

public class Red implements Colour {
    @Override
    public void applyColour() {
        System.out.println("Applying RED colour");
    }
}
