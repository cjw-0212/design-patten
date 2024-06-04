package org.example.factory.abstract_factory;

import org.example.factory.simple_factory.Television;
import org.example.factory.simple_factory.XiaoMiTelevision;

/**
 * @author CJW
 * @since 2024/6/4
 */
public class XiaoMiFactory  implements AbstractApplianceFactory{
    @Override
    public Television productTelevision() {
        return new XiaoMiTelevision();
    }

    @Override
    public AirConditioner productAirConditioner() {
        return new XiaoMiAirConditioner();
    }
}
