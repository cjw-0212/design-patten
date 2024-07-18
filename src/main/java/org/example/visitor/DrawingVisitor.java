package org.example.visitor;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class DrawingVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        // 画圆形
        System.out.println(String.format("Draw Circle, x=%d, y=%d, r=%d",
                circle.getX(), circle.getY(), circle.getRadius()));
    }
    @Override
    public void visitRectangle(Rectangle rectangle) {
        // 画矩形
        System.out.println(String.format("Draw Rectangle, x=%d, y=%d, w=%d, h=%d",
                rectangle.getA(), rectangle.getB(), rectangle.getC(), rectangle.getD()));
    }
}

