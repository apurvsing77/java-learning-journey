package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Client;


import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Factory.ShapeFactory;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Product.CircleProduct;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.ShapeProduct;

public class ShapeClient {
    public static void main(String[] args) {

//        ShapeProduct circle1 = new CircleProduct();
        ShapeFactory factory = new ShapeFactory(new CircleProduct());
        factory.callDrow();

//        ShapeProduct circle = ShapeFactory.createShape("circle");
//        if (circle != null) {
//            circle.draw();
//        }
//
        ShapeProduct rectangle = ShapeFactory.createShape("RECTANGLE"); // Case-insensitive
        if (rectangle != null) {
            rectangle.draw();
        }
//
//        ShapeProduct square = ShapeFactory.createShape("square");
//        if (square != null) {
//            square.draw();
//        }
//
//        try {
//            ShapeProduct unknown = ShapeFactory.createShape("triangle");
//            if (unknown != null) {
//                unknown.draw();
//            }
//        } catch (IllegalArgumentException e) {
//            System.err.println("Error: " + e.getMessage());
//        }
    }
}