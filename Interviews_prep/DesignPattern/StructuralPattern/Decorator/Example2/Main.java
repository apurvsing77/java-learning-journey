package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.component.FoodItem;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateComponent.Butrger;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateComponent.Pizza;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateDecorator.ExtraCheese;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example2.concreateDecorator.Mushrooms;

public class Main {
    public static void main(String[] args) {
        FoodItem  foodItemPizza = new Pizza();
        FoodItem foodItemBurger = new Butrger();
        System.out.println("Pizza Price: "+foodItemPizza.getCost()+"\nPizza Description: "+foodItemPizza.getDescription());
        System.out.println("Burger Price: "+foodItemBurger.getCost()+"\nBurger Description: "+foodItemBurger.getDescription());

        // Burger with cheese and mushroom  and bacon

        FoodItem foodItemBurgerWithCheeseAndMushroom = new ExtraCheese(new Mushrooms(new Butrger()));
        System.out.println("Burger with cheese and mushroom and bacon\nPrice: "+foodItemBurgerWithCheeseAndMushroom.getCost()+"\nDescription: "+foodItemBurgerWithCheeseAndMushroom.getDescription());

    }
}
