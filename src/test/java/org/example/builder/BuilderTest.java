package org.example.builder;

import org.junit.Test;

/**
 * @author CJW
 * @since 2024/6/6
 */
public class BuilderTest {
    @Test
    public void test(){
        Waiter waiter = new Waiter();
        waiter.setMealBuilder(new MealBuilderA());
        System.out.println(waiter.construct());
        waiter.setMealBuilder(new MealBuilderB());
        System.out.println(waiter.construct());
    }
}
