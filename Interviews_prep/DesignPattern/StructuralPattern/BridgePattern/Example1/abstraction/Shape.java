package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.abstraction;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.implementor.Colour;

public abstract class Shape {

    protected Colour colour;

    public Shape(Colour colour) {
        this.colour = colour;
    }

    abstract public  void drow();
}
