package org.example.proxy.dynamic_proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author CJW
 * @since 2024/7/11
 */
//代理类
public class JdkDynamicProxy implements InvocationHandler {
    private Object bean;

    public JdkDynamicProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("wakeup".equals(methodName)) {
            System.out.print("早安~~~");
        } else if ("sleep".equals(methodName)) {
            System.out.print("晚安~~~");
        }
        return method.invoke(bean, args);
    }
}
