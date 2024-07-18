package org.example.visitor;

/**
 * @author CJW
 * @since 2024/7/18
 */
//抽象元素接口 Shape
public interface Shape {
    void accept(Visitor visitor);
}

