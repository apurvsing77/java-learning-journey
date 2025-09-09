package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateComponent;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.component.FoodItem;

public class Butrger implements FoodItem {
    @Override
    public String getDescription() {
        return "Base Butrger";
    }

    @Override
    public double getCost() {
        return 149.0;
    }
}
