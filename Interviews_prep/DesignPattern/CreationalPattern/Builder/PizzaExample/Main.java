package Interviews_prep.DesignPattern.CreationalPattern.Builder.PizzaExample;

public class Main {
    public static void main(String[] args){
        Pizza myOrder = new Pizza.PizzaBuilder("large","Stuffed crust")
                .addChese()
                .addMushrooms()
                .build();
        System.out.println(myOrder);
    }
}
