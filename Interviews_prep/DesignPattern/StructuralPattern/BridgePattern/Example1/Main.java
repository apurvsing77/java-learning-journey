package Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1;

import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.RefinedAbstraction.Circle;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.RefinedAbstraction.Square;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.abstraction.Shape;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.concreateImplementor.Green;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.concreateImplementor.Red;
import Interviews_prep.DesignPattern.StructuralPattern.BridgePattern.Example1.implementor.Colour;

public class Main {
    public static void main(String[] args) {
        Colour red = new Red();
        Colour green = new Green();

        Shape circle = new Circle(red);
        circle.drow();
        Shape square = new Square(green);
        square.drow();

    }
}
