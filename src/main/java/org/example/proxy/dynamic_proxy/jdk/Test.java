package org.example.proxy.dynamic_proxy.jdk;

import javax.print.Doc;
import java.lang.reflect.Proxy;

/**
 * @author CJW
 * @since 2024/7/11
 */
public class Test {
    public static void main(String[] args) {
        JdkDynamicProxy proxy=new JdkDynamicProxy(new Student("张三"));
        //创建代理实例，第二个参数要使用接口进行代理
        Person studnet= (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class},proxy);
        studnet.wakeup();
        studnet.sleep();

        proxy=new JdkDynamicProxy(new Doctor("陈医生"));
        Person doctor= (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class},proxy);
        doctor.wakeup();
        doctor.sleep();

        proxy=new JdkDynamicProxy(new Cat("喵喵"));
        Animal cat= (Animal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Animal.class},proxy);
        cat.wakeup();
        cat.sleep();

        proxy=new JdkDynamicProxy(new Dog("旺旺"));
        Animal dog= (Animal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Animal.class},proxy);
        dog.wakeup();
        dog.sleep();
    }
}
