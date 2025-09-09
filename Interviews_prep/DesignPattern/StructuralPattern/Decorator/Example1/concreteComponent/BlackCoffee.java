package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.concreteComponent;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;

public class BlackCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Black Coffee";
    }

    @Override
    public double getCost() {
        return 40.0;
    }
}
