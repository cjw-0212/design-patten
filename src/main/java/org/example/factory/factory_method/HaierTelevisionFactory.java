package org.example.factory.factory_method;

import org.example.factory.simple_factory.HaierTelevision;
import org.example.factory.simple_factory.Television;

/**
 * @author CJW
 * @since 2024/6/4
 */
public class HaierTelevisionFactory implements TelevisionFactory{
    @Override
    public Television produceTelevision() {
        return new HaierTelevision();
    }
}
