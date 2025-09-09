package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.RefinedAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.abstraction.Shape;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.implementor.Colour;

public class Circle extends Shape {
    public Circle(Colour colour) {
        super(colour);
    }

    @Override
    public void drow() {
        System.out.print("Drawing Circle and we are ");
        colour.applyColour();
    }
}
