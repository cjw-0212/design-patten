package org.example.observer;


/**
 * @author CJW
 * @since 2024/7/15
 */
public interface Subject {
    /**
     * 注册一个观察着
     */
    void registerObserver(Observer observer);

    /**
     * 移除一个观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有的观察着
     */
    void notifyObservers();
}
