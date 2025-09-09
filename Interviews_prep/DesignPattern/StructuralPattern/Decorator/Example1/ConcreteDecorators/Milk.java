package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.ConcreteDecorators;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.decorator.CoffeeDecorator;

public class Milk extends CoffeeDecorator {


    public Milk(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }

    @Override
    public String getDescription() {

        return decoratedCoffee.getDescription() + " with Milk";
    }
    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 20.0;
    }

}
