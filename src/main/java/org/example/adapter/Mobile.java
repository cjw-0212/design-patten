package org.example.adapter;

/**
 * @author CJW
 * @since 2024/7/5
 */
public class Mobile {
    /**
     * 手机需要依赖5V的电压接口
     */
    public void inoutPower(V5Power v5Power){
        System.out.println("手机需要5V的电压，现在是"+v5Power.provideV5()+"V");
    }
}
