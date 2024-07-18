package org.example.composite;

/**
 * @author CJW
 * @since 2024/7/10
 */
//组合节点
public class Operator implements Expression {
    protected Expression left;
    protected Expression right;

    public Operator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return 0;
    }
}
