package org.example.singleton;

import org.junit.Test;

/**
 * @author CJW
 * @since 2024/5/31
 */
public class SingletonTest {
    @Test
    public void testGetInstanceByMultipleThread() {
        for (int i = 0; i < 10000; i++) {
            //System.out.println(HungrySingleton.getInstance());
            new Thread(EnumSingleton.INSTANCE::method).start();
        }
    }

    @Test
    public void testGetInstanceByOneThread() {
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
    }
}
