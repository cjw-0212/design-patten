package org.example.observer;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class ObserverA implements Observer {
    private Subject subject;

    public ObserverA(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observerA得到消息" + msg);
    }
}
