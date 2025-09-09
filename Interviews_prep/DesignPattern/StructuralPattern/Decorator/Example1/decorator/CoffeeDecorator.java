package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.decorator;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;


public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}