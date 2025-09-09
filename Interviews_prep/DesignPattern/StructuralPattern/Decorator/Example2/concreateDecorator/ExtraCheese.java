package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateDecorator;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.component.FoodItem;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.decorator.FoodItemDecorater;

public class ExtraCheese extends FoodItemDecorater {
    public ExtraCheese(FoodItem foodDecorator) {
        super(foodDecorator);
    }
    @Override
    public String getDescription() {
        return foodDecorator.getDescription() + ", Extra Cheese";
    }
    @Override
    public double getCost() {
        return foodDecorator.getCost() + 10.0;
    }
}
