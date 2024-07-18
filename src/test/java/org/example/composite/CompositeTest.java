package org.example.composite;

import org.junit.Test;

/**
 * @author CJW
 * @since 2024/7/10
 */
public class CompositeTest {
    @Test
    public void test(){
      Expression expression=new AddOperator(
              new Number(20),
              new MulOperator(
                      new Number(4),
                      new Number(5)
              )
      );
        System.out.println(expression.evaluate());
    }
}
