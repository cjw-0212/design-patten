package org.example.builder;

/**
 * @author CJW
 * @since 2024/6/6
 */
public class MealBuilderA extends MealBuilder{
    @Override
    public void setDrink() {
        meal.setDrink("A套餐饮料");
    }

    @Override
    public void setFood() {
        meal.setFood("A套餐食物");
    }
}
