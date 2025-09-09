package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateDecorator;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.component.FoodItem;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.decorator.FoodItemDecorater;

public class Mushrooms extends FoodItemDecorater {
    public Mushrooms(FoodItem foodItem) {
        super(foodItem);
    }
    @Override
    public String getDescription() {
        return foodDecorator.getDescription() + ", Mushrooms";
    }
    @Override
    public double getCost() {
        return foodDecorator.getCost() + 10.0;
    }
}
