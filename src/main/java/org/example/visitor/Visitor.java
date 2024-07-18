package org.example.visitor;

/**
 * @author CJW
 * @since 2024/7/18
 */
//抽象访问者接口 Visitor
public interface Visitor {
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}

