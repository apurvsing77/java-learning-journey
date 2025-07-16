package Interviews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.GoodCode;

public interface Shape {
    int getArea();
}

class Rectangle implements Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public int getArea() {
        return height * width;
    }
}
class Square implements Shape {
    int sideLength;

    public Square(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public int getArea() {
        return sideLength *sideLength;
    }
}
class Main {

    public static void main(String[] args) {

    Shape rectangle = new Rectangle(5, 10);
    Shape square = new Square(6);
    System.out.println("Rectangle area: " + rectangle.getArea());
    System.out.println("Square area: " + square.getArea());

    }
}
