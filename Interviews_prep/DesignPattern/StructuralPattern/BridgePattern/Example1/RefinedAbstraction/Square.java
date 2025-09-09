package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.RefinedAbstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.abstraction.Shape;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.implementor.Colour;

public class Square extends Shape {
    public Square(Colour colour) {
        super(colour);
    }

    @Override
    public void drow() {
        System.out.print("Drawing a Square and we are ");
        colour.applyColour();
    }
}
