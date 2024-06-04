package org.example.factory;

import org.example.factory.factory_method.HaierTelevisionFactory;
import org.example.factory.factory_method.TelevisionFactory;
import org.example.factory.factory_method.XiaoMiTelevisionFactory;
import org.junit.Test;

/**
 * @author CJW
 * @since 2024/6/4
 */
public class FactoryMethodTest {
    @Test
    public void test(){
        TelevisionFactory factory1=new HaierTelevisionFactory();
        System.out.println(factory1.produceTelevision().getBrandName());
        TelevisionFactory factory2 = new XiaoMiTelevisionFactory();
        System.out.println(factory2.produceTelevision().getBrandName());
    }
}
