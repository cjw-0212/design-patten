package org.example.composite;

/**
 * @author CJW
 * @since 2024/7/10
 */
//叶子节点
public class Number implements Expression {
    private double val;

    public Number(double v) {
        this.val = v;
    }

    @Override
    public double evaluate() {
        return val;
    }
}
