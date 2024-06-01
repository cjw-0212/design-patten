package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
public class LazySyncSingleton {
    private static LazySyncSingleton instance = null;

    private LazySyncSingleton() {
        System.out.println("构造方法被调用");
    }

    /*public static synchronized LazySyncSingleton getInstance() {
        if (instance == null) {
            instance = new LazySyncSingleton();
        }
        return instance;
    }
*/
    public static  LazySyncSingleton getInstance() {
        if (instance == null) {
            synchronized (LazySyncSingleton.class){
                instance = new LazySyncSingleton();
            }
        }
        return instance;
    }
}
