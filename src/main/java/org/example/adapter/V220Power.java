package org.example.adapter;

/**
 * @author CJW
 * @since 2024/7/5
 */
public class V220Power {
    /**
     * 现在只有一个可以提供220V的
     */
    public int provideV220Power()
    {
        System.out.println("我提供220V交流电压。");
        return 220 ;
    }
}
