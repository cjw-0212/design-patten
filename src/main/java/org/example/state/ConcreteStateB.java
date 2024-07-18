package org.example.state;

/**
 * @author CJW
 * @since 2024/7/17
 */
public class ConcreteStateB implements State{
    @Override
    public void handle() {
        System.out.println("状态B");
    }
}
