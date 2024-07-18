package org.example.observer;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class ObserverB implements Observer {
    private Subject subject;

    public ObserverB(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observerB得到消息" + msg);
    }
}
