package org.example.proxy.dynamic_proxy.jdk;

/**
 * @author CJW
 * @since 2024/7/11
 */
public class Student implements Person{
    private String name;
    public Student() {
    }
    public Student(String name) {
        this.name = name;
    }
    @Override
    public void wakeup() {
        System.out.println("学生"+name+"早晨醒来啦");
    }
    @Override
    public void sleep() {
        System.out.println("学生"+name+"晚上睡觉啦");
    }
}
