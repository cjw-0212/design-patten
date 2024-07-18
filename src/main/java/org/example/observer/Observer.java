package org.example.observer;

/**
 * @author CJW
 * @since 2024/7/15
 */
//所有的观察者需要实现此接口
public interface Observer {
    void update(String msg);
}
