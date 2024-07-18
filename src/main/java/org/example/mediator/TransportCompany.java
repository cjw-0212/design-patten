package org.example.mediator;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class TransportCompany extends Participant{
    public TransportCompany(LogisticsCenter logisticsCenter) {
        super(logisticsCenter);
    }

    @Override
    public void send(String to, String message) {
        logisticsCenter.send("运输公司",to,message);
    }

    @Override
    public void receive(String message) {
        System.out.println("运输公司接到消息: " + message);
    }
}
