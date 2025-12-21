package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Product;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.ShapeProduct;

public class SquareProduct implements ShapeProduct {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}
