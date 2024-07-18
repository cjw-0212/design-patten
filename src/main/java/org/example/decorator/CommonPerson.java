package org.example.decorator;

/**
 * @author CJW
 * @since 2024/7/8
 */
public class CommonPerson extends Person{
    @Override
    public void sport() {
        System.out.println("普通人运动只会走路");
    }
}
