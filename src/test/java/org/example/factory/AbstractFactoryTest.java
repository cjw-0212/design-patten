package org.example.factory;

import org.example.factory.abstract_factory.AbstractApplianceFactory;
import org.example.factory.abstract_factory.HaierFactory;
import org.example.factory.abstract_factory.XiaoMiFactory;
import org.junit.Test;

/**
 * @author CJW
 * @since 2024/6/4
 */
public class AbstractFactoryTest {
    @Test
    public void test(){
        AbstractApplianceFactory factory1=new HaierFactory();
        System.out.println(factory1.productTelevision().getBrandName());
        System.out.println(factory1.productAirConditioner().getBrandName());
        AbstractApplianceFactory factory2=new XiaoMiFactory();
        System.out.println(factory2.productTelevision().getBrandName());
        System.out.println(factory2.productAirConditioner().getBrandName());
    }
}
