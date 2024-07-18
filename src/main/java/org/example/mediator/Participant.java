package org.example.mediator;

/**
 * @author CJW
 * @since 2024/7/15
 */
public abstract class Participant {
    // 中介者对象
    protected final LogisticsCenter logisticsCenter;

    public Participant(LogisticsCenter logisticsCenter) {
        this.logisticsCenter = logisticsCenter;
    }

    // 消息发送方法，根据传递给中介者
    public abstract void send(String to, String message);

    // 消息接收方法，由中介者调用
    public abstract void receive(String message);
}
