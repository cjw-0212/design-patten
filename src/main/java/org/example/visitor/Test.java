package org.example.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class Test {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10, 20, 5));
        shapes.add(new Rectangle(30, 40, 50, 60));
     
        Visitor visitor = new DrawingVisitor();
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}
