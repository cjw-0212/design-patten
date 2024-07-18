package org.example.proxy.static_proxy;

/**
 * @author CJW
 * @since 2024/7/11
 */
//租房真实实现类
public class RentHouse implements IRentHouse{
    @Override
    public void rentHouse() {
        System.out.println("实现租房");
    }
}
