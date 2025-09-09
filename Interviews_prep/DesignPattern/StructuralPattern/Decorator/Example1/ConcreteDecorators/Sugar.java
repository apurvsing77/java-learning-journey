package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.ConcreteDecorators;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.decorator.CoffeeDecorator;

public class Sugar extends CoffeeDecorator {
    public Sugar(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 10.0;
    }
}
