package org.example.bridge;

/**
 * @author CJW
 * @since 2024/7/8
 */
//定义具体实现
public class Circle extends Shape{
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}
