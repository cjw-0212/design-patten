package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
public class LazyUnSafetySingleton {
    private static LazyUnSafetySingleton instance = null;

    private LazyUnSafetySingleton() {
        System.out.println("构造方法被调用");
    }

    public static LazyUnSafetySingleton getInstance() {
        if (instance == null) {
            instance = new LazyUnSafetySingleton();
        }
        return instance;
    }
}
