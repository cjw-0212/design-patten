package org.example.bridge;

/**
 * @author CJW
 * @since 2024/7/8
 */
//定义抽象实现
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
