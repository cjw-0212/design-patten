package org.example.mediator;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class Test{
    public static void main(String[] args) {
        LogisticsCenter logisticsCenter=new LogisticsCenterImpl();
        TransportCompany transportCompany=new TransportCompany(logisticsCenter);
        Merchant merchant=new Merchant(logisticsCenter);

        logisticsCenter.register(transportCompany);
        logisticsCenter.register(merchant);

        transportCompany.send("Merchant", "快递已送达");
        merchant.send("TransportCompany", "收到，幸苦了");
    }
}
