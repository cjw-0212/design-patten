package org.example.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class MessageService implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }

    public void setMsg(String msg) {
        System.out.println("服务发送消息"+msg);
        this.msg = msg;
        notifyObservers();
    }
}
