package org.example.composite;

/**
 * @author CJW
 * @since 2024/7/10
 */
public class MulOperator extends Operator{
    public MulOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
