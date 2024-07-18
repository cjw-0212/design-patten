package org.example.proxy.dynamic_proxy.jdk;

/**
 * @author CJW
 * @since 2024/7/11
 */
public class Cat implements Animal{
    private String name;
    public Cat() {
    }
    public Cat(String name) {
        this.name = name;
    }
    @Override
    public void wakeup() {
        System.out.println("小猫"+name+"早晨醒来啦");
    }
    @Override
    public void sleep() {
        System.out.println("小猫"+name+"晚上睡觉啦");
    }
}
