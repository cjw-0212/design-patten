package org.example.factory.simple_factory;

/**
 * @author CJW
 * @since 2024/6/3
 */
public class TelevisionFactory {
    public static Television productTelevision(String brandName) {
        switch (brandName) {
            case "haier": {
                return new HaierTelevision();
            }
            case "xiaomi": {
                return new XiaoMiTelevision();
            }
            default: {
                return null;
            }
        }
    }
}
