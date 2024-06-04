package org.example.factory.abstract_factory;

import org.example.factory.simple_factory.Television;

/**
 * @author CJW
 * @since 2024/6/4
 */
public interface AbstractApplianceFactory {
    Television productTelevision();
    AirConditioner productAirConditioner();
}
