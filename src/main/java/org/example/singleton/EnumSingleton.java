package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
public enum EnumSingleton {
    /**
     * 枚举单例
     */
    INSTANCE;

    EnumSingleton() {

    }

    public void method() {
        System.out.println("自定义方法");
    }
}
