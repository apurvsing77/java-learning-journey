package Interwiews_prep.CompareMethod.Comparator;

class Fruit {
    String name;
    String color;

    Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return name + "(" + color + ")";
    }
}