package org.example.proxy.dynamic_proxy.cglib;

import org.example.proxy.dynamic_proxy.jdk.Dog;
import org.example.proxy.dynamic_proxy.jdk.Student;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class Test {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy(new Student("张三"));
        Student student = (Student) proxy.getProxy();
        student.wakeup();
        student.sleep();

        proxy = new CglibProxy(new Dog("旺财"));
        Dog dog = (Dog) proxy.getProxy();
        dog.wakeup();
        dog.sleep();
    }
}
