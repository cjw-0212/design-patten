package org.example.mediator;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class Merchant extends Participant {
    public Merchant(LogisticsCenter logisticsCenter) {
        super(logisticsCenter);
    }

    @Override
    public void send(String to, String message) {
        logisticsCenter.send("商家", to, message);
    }

    @Override
    public void receive(String message) {
        System.out.println("商家接收到消息: " + message);
    }
}
