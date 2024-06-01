package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("构造方法被调用");
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
