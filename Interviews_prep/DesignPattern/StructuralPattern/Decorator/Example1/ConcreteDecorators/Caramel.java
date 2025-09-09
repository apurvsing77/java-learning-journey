package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.ConcreteDecorators;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.decorator.CoffeeDecorator;

public class Caramel extends CoffeeDecorator {

    public Caramel(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + " with Caramel";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 30.0;
    }
}
