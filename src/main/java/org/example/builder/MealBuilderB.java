package org.example.builder;

/**
 * @author CJW
 * @since 2024/6/6
 */
public class MealBuilderB extends MealBuilder{
    @Override
    public void setDrink() {
        meal.setDrink("B套餐饮料");
    }

    @Override
    public void setFood() {
        meal.setFood("B套餐食物");
    }
}
