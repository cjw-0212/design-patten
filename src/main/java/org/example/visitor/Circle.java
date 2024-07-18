package org.example.visitor;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class Circle implements Shape {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }
}

