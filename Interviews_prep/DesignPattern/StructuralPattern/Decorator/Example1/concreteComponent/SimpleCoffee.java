package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.concreteComponent;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;

public class SimpleCoffee  implements Coffee{
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 50.0;
    }
}
