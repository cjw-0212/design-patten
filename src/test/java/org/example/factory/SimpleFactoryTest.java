package org.example.factory;

import org.example.factory.simple_factory.Television;
import org.example.factory.simple_factory.TelevisionFactory;
import org.junit.Test;

/**
 * @author CJW
 * @since 2024/6/3
 */
public class SimpleFactoryTest {
    @Test
    public void test(){
        Television television1 = TelevisionFactory.productTelevision("haier");
        System.out.println(television1.getBrandName());
        Television television2 = TelevisionFactory.productTelevision("xiaomi");
        System.out.println(television2.getBrandName());
    }
}
