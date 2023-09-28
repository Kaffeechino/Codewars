package de.gfn.factoryPattern;

public class FactoryPatternExample {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("CIRCLE");
        circle.draw();

        Shape rectangle = shapeFactory.createShape("RECTANGLE");
        rectangle.draw();
    }
}
