package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.concreateImplementor;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.implementor.Colour;

import java.awt.*;

public class Green  implements Colour {
    @Override
    public void applyColour() {
        System.out.println("Appling Green Colour");
    }
}
