package Interviews_prep.DesignPattern.CreationalPattern.Builder.PizzaExample;

public class Pizza {

    private final String size;
    private final String dough;
    private final boolean cheese;
    private final boolean pepperoni;
    private final boolean mushrooms;

    private Pizza(PizzaBuilder pizzaBuilder){
        this.size = pizzaBuilder.size;
        this.dough = pizzaBuilder.dough;
        this.cheese = pizzaBuilder.cheese;
        this.pepperoni = pizzaBuilder.pepperoni;
        this.mushrooms = pizzaBuilder.mushrooms;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "size='" + size + '\'' +
                ", dough='" + dough + '\'' +
                ", cheese=" + cheese +
                ", pepperoni=" + pepperoni +
                ", mushrooms=" + mushrooms +
                '}';
    }

    public static class PizzaBuilder{
        private  String size;
        private  String dough;
        private  boolean cheese;
        private  boolean pepperoni;
        private  boolean mushrooms;

        public PizzaBuilder(String size, String dough){
            this.size = size;
            this.dough = dough;
        }

        public PizzaBuilder addChese(){
            this.cheese = true;
            return this;
        }

        public PizzaBuilder addPepperoni(){
            this.pepperoni = true;
            return this;
        }

        public PizzaBuilder addMushrooms(){
            this.mushrooms = true;
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }

    }
}
