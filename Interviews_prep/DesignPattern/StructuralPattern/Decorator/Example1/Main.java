package Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1;

import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.Componet.Coffee;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.ConcreteDecorators.Caramel;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.ConcreteDecorators.Milk;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.ConcreteDecorators.Sugar;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.concreteComponent.BlackCoffee;
import Interviews_prep.DesignPattern.StructuralPattern.Decorator.Example1.concreteComponent.SimpleCoffee;

public class Main {

    public static void main(String[] args) {

        System.out.println("Price of Simple Coffee");
    Coffee coffee = new SimpleCoffee();
        System.out.println("Coffee name: "+coffee.getDescription()+"\nPrice: "+coffee.getCost());


    System.out.println("Price of Simple Coffee with Milk");
    Coffee coffeeWithMilk = new Milk(new SimpleCoffee());
        System.out.println("Coffee name: "+coffeeWithMilk.getDescription()+"\nPrice: "+coffeeWithMilk.getCost());

    System.out.println("Price of Simple Coffee with Milk And Sugar");
    Coffee cofeeWithMilkAndSugar = new Sugar(coffeeWithMilk);
    System.out.println("Coffee name: "+cofeeWithMilkAndSugar.getDescription()+"\nPrice: "+cofeeWithMilkAndSugar.getCost());


    System.out.println("Price of Simple Coffee with caramel");
    Coffee cofeeWithCaramel = new Caramel(new SimpleCoffee());
    System.out.println("Coffee name: "+cofeeWithCaramel.getDescription()+"\nPrice: "+cofeeWithCaramel.getCost());

        System.out.println("Price of Simple Coffee with caramel And Milk And Sugar");
        Coffee cofeeWithCaramelAndSugar = new Sugar(cofeeWithCaramel);
        Coffee cofeeWithCaramelAndSugarAndMilk = new Milk(cofeeWithCaramelAndSugar);
        System.out.println("Coffee name: "+cofeeWithCaramelAndSugarAndMilk.getDescription()+"\nPrice: "+cofeeWithCaramelAndSugarAndMilk.getCost());

        System.out.println("price of Black coffee");
        Coffee blackCoffee = new BlackCoffee();
        System.out.println("Coffee name: "+blackCoffee.getDescription()+"\nPrice: "+blackCoffee.getCost());

        System.out.println("price of Black coffee with caramel And Milk And Sugar");
        Coffee blackCoffeeWithCaramelAndSugarAndMilk = new Milk(new Sugar(new Caramel(new BlackCoffee())));
        System.out.println("Coffee name: "+blackCoffeeWithCaramelAndSugarAndMilk.getDescription()+"\nPrice: "+blackCoffeeWithCaramelAndSugarAndMilk.getCost());
    }
}
