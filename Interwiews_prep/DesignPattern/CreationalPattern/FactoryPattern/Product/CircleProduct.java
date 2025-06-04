package Interwiews_prep.DesignPattern.CreationalPattern.FactoryPattern.Product;

import Interwiews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeProduct;

public class CircleProduct implements ShapeProduct {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}
