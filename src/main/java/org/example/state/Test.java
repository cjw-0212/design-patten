package org.example.state;

/**
 * @author CJW
 * @since 2024/7/17
 */
public class Test {
    public static void main(String[] args) {
        Content content=new Content();
        ConcreteStateA concreteStateA = new ConcreteStateA();
        content.setState(concreteStateA);
        content.request();
        ConcreteStateB concreteStateB = new ConcreteStateB();
        content.setState(concreteStateB);
        content.request();
    }
}
