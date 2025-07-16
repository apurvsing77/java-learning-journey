package Interviews_prep.DesignPrinciple.SOLID_Principle.LiskovSubstitutionPrinciple.BadCode;

class Rectangle {

    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getArea() {
        return width * height;
    }

}
class Square extends Rectangle {
    public void setWidth(int width) {
        this.width = width;  // Incorrect implementation, it doesn't maintain the square shape'
//        this.height = width; // Incorrect implementation, it doesn't maintain the square shape
    }
    public void setHeight(int height) {
//        this.width = height;  // Incorrect implementation, it doesn't maintain the square shape'
        this.height = height; // Incorrect implementation, it doesn't maintain the square shape
    }
}
public class Shape {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle area: " + rectangle.getArea());

        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(10);
        System.out.println("Square area: " + square.getArea());  // Incorrect output, it prints the area of the rectangle
    }
}
