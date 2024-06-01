package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    private static class InstanceHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
