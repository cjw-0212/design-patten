package org.example.proxy.static_proxy;

/**
 * @author CJW
 * @since 2024/7/11
 */
public class Test {
    public static void main(String[] args) {
        IRentHouse rentHouse=new RentHouse();
        IRentHouse intermediaryProxy=new IntermediaryProxy(rentHouse);
        intermediaryProxy.rentHouse();
    }
}
