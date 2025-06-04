package Interwiews_prep.DesignPattern.CreationalPattern.FactoryPattern.Product;

import Interwiews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeProduct;

public class RectangleProduct implements ShapeProduct {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}
