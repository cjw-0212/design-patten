package org.example.factory.factory_method;

import org.example.factory.simple_factory.Television;
import org.example.factory.simple_factory.XiaoMiTelevision;

/**
 * @author CJW
 * @since 2024/6/4
 */
public class XiaoMiTelevisionFactory implements TelevisionFactory{
    @Override
    public Television produceTelevision() {
        return new XiaoMiTelevision();
    }
}
