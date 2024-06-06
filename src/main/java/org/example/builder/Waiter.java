package org.example.builder;

/**
 * @author CJW
 * @since 2024/6/6
 */
public class Waiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        mealBuilder.setDrink();
        mealBuilder.setFood();
        return mealBuilder.getMeal();
    }
}
