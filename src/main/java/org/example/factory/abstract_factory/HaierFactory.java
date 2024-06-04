package org.example.factory.abstract_factory;

import org.example.factory.simple_factory.HaierTelevision;
import org.example.factory.simple_factory.Television;

/**
 * @author CJW
 * @since 2024/6/4
 */
public class HaierFactory implements AbstractApplianceFactory{
    @Override
    public Television productTelevision() {
        return new HaierTelevision();
    }

    @Override
    public AirConditioner productAirConditioner() {
        return new HaierAirConditioner();
    }
}
