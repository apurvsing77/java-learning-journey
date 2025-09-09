package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.decorator;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.component.FoodItem;

public abstract class FoodItemDecorater implements FoodItem {

    protected FoodItem foodDecorator;

    public FoodItemDecorater(FoodItem foodItem) {
        this.foodDecorator = foodItem;
    }

    @Override
    public String getDescription() {
        return foodDecorator.getDescription();
    }

    @Override
    public double getCost() {
        return foodDecorator.getCost();
    }
}
