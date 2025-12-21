package Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Factory;

import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Product.CircleProduct;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Product.RectangleProduct;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.Product.SquareProduct;
import Interviews_prep.DesignPattern.CreationalPattern.FactoryPattern.ShapeExample.ShapeProduct;

public class  ShapeFactory {
    private ShapeProduct shapeProduct;


    public ShapeFactory(ShapeProduct shapeProduct) {
        this.shapeProduct = shapeProduct;
    }
    public void callDrow(){
        shapeProduct.draw();
    }


    public static ShapeProduct createShape(String shapeType) {
        if (shapeType == null || shapeType.isEmpty()) {
            return null;
        }
        switch (shapeType.toLowerCase()) {
            case "circle":
                return new CircleProduct();
            case "rectangle":
                return new RectangleProduct();
            case "square":
                return new SquareProduct();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + shapeType);
        }
    }
}
