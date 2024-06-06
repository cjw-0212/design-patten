package org.example.builder;

/**
 * @author CJW
 * @since 2024/6/6
 */
public abstract class MealBuilder {
    protected Meal meal=new Meal();
    public abstract void setDrink();
    public abstract void setFood();
    public Meal getMeal(){
        return this.meal;
    }
}
