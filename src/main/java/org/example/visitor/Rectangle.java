package org.example.visitor;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class Rectangle implements Shape {
    private int a;
    private int b;
    private int c;
    private int d;

    public Rectangle(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }
}

