package org.example.proxy.static_proxy;

/**
 * @author CJW
 * @since 2024/7/11
 */
//租房中介代理
public class IntermediaryProxy implements IRentHouse{
    private IRentHouse iRentHouse;
    public IntermediaryProxy(IRentHouse iRentHouse){
        this.iRentHouse=iRentHouse;
    }
    @Override
    public void rentHouse() {
        System.out.println("交中介费");
        iRentHouse.rentHouse();
        System.out.println("中介复杂维修管理");
    }
}
