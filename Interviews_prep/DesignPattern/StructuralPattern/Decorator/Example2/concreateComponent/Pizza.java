package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateComponent;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.component.FoodItem;

public class Pizza  implements FoodItem {
    @Override
    public String getDescription() {
        return "Base Pizza";
    }

    @Override
    public double getCost() {
        return 250.0;
    }
}
