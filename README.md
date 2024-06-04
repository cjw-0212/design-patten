# design-patten-java(设计模式详解与案例实现)

## 单例模式

[Java设计模式—单例设计模式(Singleton Pattern)完全解析_java单例设计模式那个好用-CSDN博客](https://blog.csdn.net/dmk877/article/details/50311791)

### 目的

确保应用中只有一个对象存在，也就是保证一个类在内存中的对象唯一性。实现步骤如下：

* 私有化构造方法
* 在本类中new一个对象
* 使用一个共有的方法，将在类中创建的实例返回

### 饿汉式

```java
public class HungrySingleton {
    private static final HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {
        System.out.println("构造方法被调用");
    }

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
```
```text
分单线程和多线程进行测试
```
```java
public class SingletonTest {
    @Test
    public void testGetInstanceByMultipleThread() {
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                System.out.println(HungrySingleton.getInstance());
            }).start();
        }
    }

    @Test
    public void testGetInstanceByOneThread() {
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
        System.out.println(HungrySingleton.getInstance());
    }
}
```
* 在==类加载的时候就完成了对象的实例化，避免了线程同步的问题==。 
* 类加载的时候就是实例化了，也就是说即使后续没用使用到他也是存在的，占用了内存资源，但是占用内存很小就可以忽略不计，所以这种方式 是==推荐使用==的。

### 懒汉式

```java
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
        System.out.println("构造方法被调用");
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```
* ==被调用的时候才实例化==
* ==存在线程安全问题==，在多线程并发的情况下当前一个线程判断为null进入后还未实例化之前，有新的线程进去就会创建多个对象。多线程测试结果如下：
```text
构造方法被调用
构造方法被调用
org.example.singleton.LazyUnSafetySingleton@1edcfaef
org.example.singleton.LazyUnSafetySingleton@3c24b1e8
org.example.singleton.LazyUnSafetySingleton@3c24b1e8
构造方法被调用
org.example.singleton.LazyUnSafetySingleton@3c24b1e8
构造方法被调用
构造方法被调用
org.example.singleton.LazyUnSafetySingleton@48bfe05f
org.example.singleton.LazyUnSafetySingleton@3bc039ea
```
---
```java
public class LazySyncSingleton {
    private static LazySyncSingleton instance = null;

    private LazySyncSingleton() {
        System.out.println("构造方法被调用");
    }

    public static synchronized LazySyncSingleton getInstance() {
        if (instance == null) {
            instance = new LazySyncSingleton();
        }
        return instance;
    }
}
```
* ==线程安全==
* 每一个线程在获取实例的时候都需要进行同步，==效率太低==。
---
```java
public class LazySyncSingleton {
    private static LazySyncSingleton instance = null;

    private LazySyncSingleton() {
        System.out.println("构造方法被调用");
    }
    public static  LazySyncSingleton getInstance() {
        if (instance == null) {
            synchronized (LazySyncSingleton.class){
                instance = new LazySyncSingleton();
            }
        }
        return instance;
    }
}
```
* 在判断null之后进行同步，==线程不安全==，在多线程并发的情况下当前一个线程判断为null进入后还未实例化之前，有新的线程通过if就会创建多个对象。
---
```java
public class LazyDoubleCheckSingleton {
    private static LazyDoubleCheckSingleton instance=null;
    private LazyDoubleCheckSingleton(){

    }
    public LazyDoubleCheckSingleton getInstance(){
        if (instance==null){
            synchronized (LazyDoubleCheckSingleton.class){
                if (instance==null){
                    instance=new LazyDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
```
* 双重检查，==线程安全==。
* ==兼具了延迟加载同时效率高==。

### 内部类

```java
public class InnerClassSingleton {
    private InnerClassSingleton() {
    }

    private static class InstanceHolder {
        private static final InnerClassSingleton instance = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return InstanceHolder.instance;
    }
}
```
* 线程安全，内部类是延时加载的，也就是说只会在第一次使用时加载。不使用就不加载，所以可以很好的实现单例模式。
* ==外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。==

### 枚举方式

```java
public enum EnumSingleton {
    /**
     * 枚举单例
     */
    INSTANCE;

    EnumSingleton() {

    }

    public void method() {
        System.out.println("自定义方法");
    }
}
```
* EnumSingleton.INSTANCE.method()调用方法
* 实现简单，==线程安全==

## 工厂模式

[设计模式 工厂模式 从卖肉夹馍说起_工厂模式 肉夹馍-CSDN博客](https://blog.csdn.net/lmj623565791/article/details/24460585)

### 静态工厂模式

就跟项目中的工具类的作用那样，使用类+静态方法，比如StringUtils.isEmpty()。

### 简单工厂模式

![image-20240604000947673](D:\MyNote\picture\image-20240604000947673.png)

工厂类的工厂方法根据传入的参数决定创建哪一类对象并返回，被创建的实例通常都有共同的父类。

```java
public abstract class Television {
    public String brandName;
}

public class HaierTelevision extends Television{
    public HaierTelevision(){
        this.brandName="haier";
    }
}

public class XiaoMiTelevision extends Television{
    public XiaoMiTelevision(){
        this.brandName="xiaomi";
    }
}

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

public class SimpleFactoryTest {
    @Test
    public void test(){
        Television television1 = TelevisionFactory.productTelevision("haier");
        System.out.println(television1.getBrandName());
        Television television2 = TelevisionFactory.productTelevision("xiaomi");
        System.out.println(television2.getBrandName());
    }
}
```

缺点：

* 要加入新的商品时，需要修改工厂的逻辑，违背了“开闭原则”
* 所有的商品都由同一个工厂创造，工厂类职业较重，逻辑复杂
* 具体商品于工厂的耦合度高，影响扩展性

所以就有了工厂方法模式

### 工厂方法模式

定义一个创建对象的接口，但由子类决定要实例化的类是哪一个。相比于简单工厂模式，工厂方法模式把类实例化的过程推迟到子类。

工厂父类负责定义对外的接口，而工厂子类复杂创建具体的对象。

![image-20240604003735623](D:\MyNote\picture\image-20240604003735623.png)

```java
public interface TelevisionFactory {
    Television produceTelevision();
}

public class HaierTelevisionFactory implements TelevisionFactory{
    @Override
    public Television produceTelevision() {
        return new HaierTelevision();
    }
}

public class XiaoMiTelevisionFactory implements TelevisionFactory{
    @Override
    public Television produceTelevision() {
        return new XiaoMiTelevision();
    }
}

public class FactoryMethodTest {
    @Test
    public void test(){
        TelevisionFactory factory1=new HaierTelevisionFactory();
        System.out.println(factory1.produceTelevision().getBrandName());
        TelevisionFactory factory2 = new XiaoMiTelevisionFactory();
        System.out.println(factory2.produceTelevision().getBrandName());
    }
}
```

优点：

* 加入新产品是无需修改工厂接口、其他工厂类和客户端代码，只需实现新的工厂类和新的产品即可

缺点：

* 每个具体工厂只负责创建一种产品
* 添加新产品需要同时添加产品类和对应的工厂类，系统类的数量过多，增加了复杂度

### 抽象工厂模式

相比简单工厂模式一个工厂只能创建一种产品，抽象工厂中每一个具体工厂可以创建多个具体产品

![image-20240604145559766](D:\MyNote\picture\image-20240604145559766.png)

```java
public abstract class AirConditioner {
    protected String brandName;
    public String getBrandName() {
        return brandName;
    }
}

public class HaierAirConditioner extends AirConditioner{
    public HaierAirConditioner() {
        this.brandName="海尔空调";
    }
}

public class XiaoMiAirConditioner extends AirConditioner{
    public XiaoMiAirConditioner(){
        this.brandName="小米空调";
    }
}

public interface AbstractApplianceFactory {
    Television productTelevision();
    AirConditioner productAirConditioner();
}

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
```

优点：

* 增加新的具体工厂和产品族时很方便，符合开闭原则

缺点：

* 现在的工厂新增一种产品时，需要对抽象工厂进行修改，这样会设计所有子类的修改。

适用场景：

* 系统有多个产品族，每次使用其中一个产品族，可以用抽象工厂和配置文件实现动态更换

