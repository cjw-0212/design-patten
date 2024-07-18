# design-patten-java(23种设计模式详解与案例实现)

## 七大设计原则

### 开闭原则

一个软件实体如类，模块应该对扩展开放对修改关闭。用抽象构建框架，用实现扩展细节。

通俗来讲就是如果要修改或添加功能，应该是扩展原来的代码而不是修改原来的代码，推荐使用子类继承等方式实现。

---



### 里氏代换原则

一个软件实体如果使用的是一个父类的话，那么一定适用于其子类，而且它察觉不出父类对象和子类对象的区别。也就是说，在软件里面，把父类都替换成它的子类，程序的行为没有变化。

里氏替换原则通俗的来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。它包含以下4层含义：

* 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法。

* 子类中可以增加自己特有的方法。

* 当子类的方法重载父类的方法时，方法的前置条件（即方法的形参）要比父类方法的输入参数更宽松。

* 当子类的方法实现父类的抽象方法时，方法的后置条件（即方法的返回值）要比父类更严格。

---



### 依赖倒转原则

高层模块不应该依赖低层模块，二者都应该依赖其抽象。即针对接口编程，不要针对实现编程。

 依赖倒置原则基于这样一个事实：相对于细节的多变性，抽象的东西要稳定的多。以抽象为基础搭建起来的架构比以细节为基础搭建起来的架构要稳定的多。在java中，抽象指的是接口或者抽象类，细节就是具体的实现类，使用接口或者抽象类的目的是制定好规范和契约，而不去涉及任何具体的操作，把展现细节的任务交给他们的实现类去完成。

依赖倒置原则的中心思想是面向接口编程，传递依赖关系有三种方式，以上的说的是是接口传递，另外还有两种传递方式：构造方法传递和setter方法传递，相信用过Spring框架的，对依赖的传递方式一定不会陌生。

在实际编程中，我们一般需要做到如下3点：

* 低层模块尽量都要有抽象类或接口，或者两者都有。

* 变量的声明类型尽量是抽象类或接口。

* 使用继承时遵循里氏替换原则。

---



### 接口隔离原则

接口隔离原则的含义是：建立单一接口，不要建立庞大臃肿的接口，尽量细化接口，接口中的方法尽量少。也就是说，我们要为各个类建立专用的接口，而不要试图去建立一个很庞大的接口供所有依赖它的类去调用。在程序设计中，依赖几个专用的接口要比依赖一个综合的接口更灵活。接口是设计时对外部设定的“契约”，通过分散定义多个接口，可以预防外来变更的扩散，提高系统的灵活性和可维护性。

采用接口隔离原则对接口进行约束时，要注意以下几点：

* 接口尽量小，但是要有限度。对接口进行细化可以提高程序设计灵活性是不挣的事实，但是如果过小，则会造成接口数量过多，使设计复杂化。所以一定要适度。

* 为依赖接口的类定制服务，只暴露给调用的类它需要的方法，它不需要的方法则隐藏起来。只有专注地为一个模块提供定制服务，才能建立最小的依赖关系。

* 提高内聚，减少对外交互。使接口用最少的方法去完成最多的事情。

---



### 组合/聚合复用原则

就是说要尽量的使用合成和聚合，而不是继承关系达到复用的目的。该原则就是在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分：新的对象通过向这些对象的委派达到复用已有功能的目的。

继承的缺点在于：父类的方法全部暴露给子类。父类如果发生变化，子类也得发生变化。聚合的复用的时候就对另外的类依赖的比较的少。

---



### 迪米特法则

迪米特法则又叫最少知道原则，通俗的来讲，就是一个类对自己依赖的类知道的越少越好。也就是说，对于被依赖的类来说，无论逻辑多么复杂，都尽量地的将逻辑封装在类的内部，对外除了提供的public方法，不对外泄漏任何信息。

一句话总结就是：一个对象应该对其他对象保持最少的了解。

---



### 单一职责原则

定义：不要存在多于一个导致类变更的原因。通俗的说，即一个类只负责一项职责，应该仅有一个引起它变化的原因。

遵循单一职责的优点有：

* 可以降低类的复杂度，一个类只负责一项职责，其逻辑肯定要比负责多项职责简单的多；

* 提高类的可读性，提高系统的可维护性；

* 变更引起的风险降低，变更是必然的，如果单一职责原则遵守的好，当修改一个功能时，可以显著降低对其他功能的影响。

---



## 设计模式的分类

总体来说设计模式分为三大类：

### 创建型模式五种：

工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式。

### 结构型模式七种：

适配器模式、装饰器模式、代理模式、外观模式、桥接模式、组合模式、享元模式。

### 行为型模式十一种：

策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式。

## 单例模式

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
* 类加载的时候就是实例化了，也就是说即使后续没使用到它也是存在的，占用了内存资源，但是占用内存很小就可以忽略不计，所以这种方式 是==推荐使用==的。

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
    /**
     * （关键字volatile保证对象实例化过程的顺序性）
     * 如果一个变量被volatile所修饰的话，在每次数据变化之后，其值都会被强制刷入主存。
     * 而其他处理器的缓存由于遵守了缓存一致性协议，也会把这个变量的值从主存加载到自己的缓存中。
     * 这就保证了一个volatile在并发编程中，其值在多个缓存中是可见的。
     */
    private static volatile LazyDoubleCheckSingleton instance=null;
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

### 静态工厂模式

就跟项目中的工具类的作用那样，使用类+静态方法，比如StringUtils.isEmpty()。

### 简单工厂模式
![简单工厂](D:\MyNote\picture\简单工厂.png)
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
* 所有的商品都由同一个工厂创造，工厂类职责较重，逻辑复杂
* 具体商品于工厂的耦合度高，影响扩展性

所以就有了工厂方法模式

### 工厂方法模式

定义一个创建对象的接口，但由子类决定要实例化的类是哪一个。相比于简单工厂模式，工厂方法模式把类实例化的过程推迟到子类。

工厂父类负责定义对外的接口，而工厂子类复杂创建具体的对象。

![image-20240705104652922](D:\MyNote\picture\image-20240705104652922.png)

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

![抽象工厂](D:\MyNote\picture\抽象工厂.png)

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

* 现有的工厂新增一种产品时，需要对抽象工厂进行修改，这样会涉及所有子类的修改。

适用场景：

* 系统有多个产品族，每次使用其中一个产品族，可以用抽象工厂和配置文件实现动态更换

## 建造者模式

对于一些复杂的对象，由于创建的过程比较复杂，可以由一个创建者返回给客户端一个完整的对象，而客户端无需知道具体的创建细节。

允许用户通过指定类型和内容来创建他们，不需要知道内部对象具体的创建细节。

![建造者](D:\MyNote\picture\建造者.png)

```java
//食物类
public class Meal {
    private String food;
    private String drink;
}
//抽象套餐构造者
public abstract class MealBuilder {
    //对于同一包内的类和其子类可见
    protected Meal meal=new Meal();
    public abstract void setDrink();
    public abstract void setFood();
    public Meal getMeal(){
        return this.meal;
    }
}
//套餐A构造者
public class MealBuilderA extends MealBuilder{
    @Override
    public void setDrink() {
        meal.setDrink("A套餐饮料");
    }

    @Override
    public void setFood() {
        meal.setFood("A套餐食物");
    }
}
//套餐B构造者
public class MealBuilderB extends MealBuilder{
    @Override
    public void setDrink() {
        meal.setDrink("B套餐饮料");
    }

    @Override
    public void setFood() {
        meal.setFood("B套餐食物");
    }
}
//指挥者类-服务员，只需要指定哪个套餐即可获取对象
public class Waiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal construct() {
        mealBuilder.setDrink();
        mealBuilder.setFood();
        return mealBuilder.getMeal();
    }
}

public class BuilderTest {
    @Test
    public void test(){
        Waiter waiter = new Waiter();
        waiter.setMealBuilder(new MealBuilderA());
        System.out.println(waiter.construct());
        waiter.setMealBuilder(new MealBuilderB());
        System.out.println(waiter.construct());
    }
}
```

缺点：

* 如果产品之间的差异性很大，就不适合适用建造者模式

## 原型模式

有时候需要多次创建某一类型的对象，为了简化创建过程，可以只创建一个对象然后通过克隆的方式复制出多个相同的对象。

### 浅克隆

只克隆该对象的基本类型参数，对于引用类型参数还是指向原来的

![浅克隆](D:\MyNote\picture\浅克隆.png)

```java
//附件类
public class Attachment {
}

//邮件类
public class Email implements Cloneable {
    private Attachment attachment = null;

    public Email(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return this.attachment;
    }

    @Override
    public Email clone() {
        try {
            return (Email) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}


public class ShallowTest {
    @Test
    public void test(){
        Email email=new Email(new Attachment());
        Email cloneEmail=email.clone();
        System.out.println(email==cloneEmail);//false
        System.out.println(email.getAttachment()==cloneEmail.getAttachment());//true
    }
}
```

### 深克隆

基本类型参数和引用类型参数都克隆出一份新的

![深克隆](D:\MyNote\picture\深克隆.png)

在Java语言中，通过覆盖Object的clone方法可以实现浅克隆，通过序列化可以实现深克隆。序列化时将对象写到流中，是原对象的拷贝，此时原对象还存在内存中，通过序列化将其写入流再读出即可实现深克隆。被序列化的类要实现Serializable接口。

```java
public class Attachment implements Serializable {
}

public class Email implements Serializable {
    private Attachment attachment = null;

    public Email(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public Email deepClone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);
            return (Email) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

public class DeepTest {
    @Test
    public void test(){
        Email email=new Email(new Attachment());
        Email cloneEmail=email.deepClone();
        System.out.println(email ==cloneEmail);//false
        System.out.println(email.getAttachment() == cloneEmail.getAttachment());//false
    }
}

/*也可以通过逐个克隆实现深克隆
Attachment cloneAttachment = (Attachment) this.attachment.clone();
Email cloneEmail = (Email) super.clone();
cloneEmail.setAttachment(cloneAttachment);
return cloneEmail;
*/
```

当创建对象新实例较为复杂时，使用原型模式可以简化对象的创建过程。

##  适配器模式

定义：将一个类的接口转换成客户期望的另一个接口，适配器让原本接口不兼容的类可以相互合作。这个定义还好，说适配器的功能就是把一个接口转成另一个接口。

```java
public class Mobile {
    /**
     * 手机需要依赖5V的电压接口
     */
    public void inoutPower(V5Power v5Power){
        System.out.println("手机需要5V的电压，现在是"+v5Power.provideV5()+"V");
    }
}

public interface V5Power {
    /**
     * 一个提供5V电压的接口
     */
    int provideV5();
}

public class V220Power {
    /**
     * 现在只有一个可以提供220V的
     */
    public int provideV220Power()
    {
        System.out.println("我提供220V交流电压。");
        return 220 ;
    }
}

public class V5PowerAdapter implements V5Power{
    private V220Power v220Power;
    public V5PowerAdapter(V220Power v220Power){
        this.v220Power=v220Power;
    }
    @Override
    public int provideV5() {
        //将电压适配为5V
        return v220Power.provideV220Power()-215;
    }
}

public class AdapterTest {
    @Test
    public void test(){
        Mobile mobile=new Mobile();
        V5Power v5Power=new V5PowerAdapter(new V220Power());
        mobile.inoutPower(v5Power);
    }
}
```

![image-20240705173337663](D:\MyNote\picture\image-20240705173337663.png)

## 桥接模式

桥接模式的目的是将抽象与实现分离，使它们可以独立地变化，该模式通过将一个对象的抽象部分与它的实现部分分离，使它们可以独立地改变。它通过组合的方式，而不是继承的方式，将抽象和实现的部分连接起来。

```java
//定义抽象接口
public interface DrawAPI {

    void drawCircle(int radius, int x, int y);
}

//抽象接口实现类
public class RedCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}

//抽象接口实现类
public class BlackCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: black, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}

//定义抽象实现
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}

//定义具体实现
public class Circle extends Shape{
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius,x,y);
    }
}

public class BridgeTest {
    @Test
    public void test(){
        Circle redCircle=new Circle(1,2,3,new RedCircle());
        Circle blackCircle=new Circle(1,2,3,new BlackCircle());
        redCircle.draw();
        blackCircle.draw();;
    }
}
```

![image-20240708161657713](D:\MyNote\picture\image-20240708161657713.png)

桥接模式的应用场景

* 在抽象和具体实现之间需要增加更多的灵活性的场景
* 一个类存在两个或多个独立变化的维度，而这两个或多个维度都需要独立进行扩展
* 不希望使用继承，或因为多层继承导致系统类的个数剧增

## 装饰模式

装饰者模式是结构性设计模式之一，其在不必改变类文件及不使用继承的情况下，动态地扩展一个对象的功能。它通过创建一个包装对象（即装饰）来包裹真实的对象。

```java
public abstract class Person {
    /**
     * Person 人有可以运动的抽象方法
     */
    public abstract void sport();
}

public class CommonPerson extends Person{
    @Override
    public void sport() {
        System.out.println("普通人运动只会走路");
    }
}

public abstract class Master extends Person{
    //定义一个抽象装饰者，存在一个抽象组件的引用，方便调用被装饰对象的方法
    private Person person;
    public Master(Person person){
        this.person=person;
    }
    //通过层层调用相同方法实现功能的扩展
    @Override
    public void sport() {
        person.sport();
    }
}

//具体装饰者
public class Ningzetao extends Master {
    public Ningzetao(Person person) {
        super(person);
    }

    //调用父类方法后添加扩展方法
    @Override
    public void sport() {
        super.sport();
        teachSwim();
    }

    public void teachSwim() {
        System.out.println("宁泽涛教游泳");
    }
}

//具体装饰者
public class Zoushiming extends Master {
    public Zoushiming(Person person){
        super(person);
    }
    @Override
    public void sport() {
        super.sport();
        teachBoxing();
    }
    public void teachBoxing(){
        System.out.println("邹市明教普通人拳击");
    }
}

public class DecoratorTest {
    @Test
    public void test(){
        CommonPerson commonPerson=new CommonPerson();
        commonPerson.sport();
        System.out.println();
        Master master1=new Ningzetao(commonPerson);
        master1.sport();
        System.out.println();
        Master master2=new Zoushiming(master1);
        master2.sport();
    }
}
```

![image-20240708164448343](D:\MyNote\picture\image-20240708164448343.png)

优点：

* 通过组合而非继承的方式，动态地扩展一个对象的功能，在运行时可以选择不同的装饰器从而实现不同的功能。
* 有效的避免了使用继承的方式扩展对象功能而带来的灵活性差、子类无限制扩张的问题。
* 具体组件类与具体装饰类可以独立变化，用户可以根据需要新增具体组件类跟装饰类，在使用时在对其进行组合，原有代码无须改变，符合"开闭原则"。

缺点：

* 因为所有对象均继承于最起始的Component，所以如果Component内部结构发生改变，则不可避免地影响到所有子类（装饰者于被装饰者）。如果基类改变，则势必影响对象的内部。
* 装饰模式比继承更容易出错，拍错也比较困难。对于多次装饰的对象，调试时寻找错误可能需要逐级排查，较为繁琐。所以一般只在必要的时候使用装饰者模式。
* 装饰层数不能过多，否则会影响效率。

乍一看装饰者模式跟代理模式好像，其实不然，两者最大的区别是：

* 装饰模式应该为所装饰的对象增强功能；
* 而代理模式对代理的对象施加控制，并不提供对象本身的增强功能。

## 组合模式

将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。

主要解决的问题

- 简化树形结构中对象的处理，无论它们是单个对象还是组合对象。
- 解耦客户端代码与复杂元素的内部结构，使得客户端可以统一处理所有类型的节点。

使用场景

- 当需要表示对象的层次结构时，如文件系统或组织结构。
- 当希望客户端代码能够以一致的方式处理树形结构中的所有对象时。

实现方式

- 统一接口：定义一个接口，所有对象（树枝和叶子）都实现这个接口。
- 组合结构：树枝对象包含一个接口的引用列表，这些引用可以是叶子或树枝。

```java
//统一接口
public interface Expression {
    double evaluate();
}

//叶子节点
public class Number implements Expression {
    private double val;

    public Number(double v) {
        this.val = v;
    }

    @Override
    public double evaluate() {
        return val;
    }
}

//组合节点
public class Operator implements Expression {
    protected Expression left;
    protected Expression right;

    public Operator(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double evaluate() {
        return 0;
    }
}

public class AddOperator extends Operator{
    public AddOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }
}

public class MulOperator extends Operator{
    public MulOperator(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }
}
```

![image-20240710164151803](D:\MyNote\picture\image-20240710164151803.png)

## 外观模式

供一个统一的接口，用来访问子系统中的一群接口，外观定义了一个高层的接口，让子系统更容易使用。其实就是为了方便客户的使用，把一群操作，封装成一个方法。其实就是为了方便客户的使用，把一群操作，封装成一个方法。

```java

public class HomeTheaterFacade
{
	private Computer computer;
	private Player player;
	private Light light;
	private Projector projector;
	private PopcornPopper popper;
 
	public HomeTheaterFacade(Computer computer, Player player, Light light, Projector projector, PopcornPopper popper)
	{
		this.computer = computer;
		this.player = player;
		this.light = light;
		this.projector = projector;
		this.popper = popper;
	}
 
	public void watchMovie()
	{
		/**
		 *  1、打开爆米花机
			2、制作爆米花
			3、将灯光调暗
			4、打开投影仪
			5、放下投影仪投影区
			6、打开电脑
			7、打开播放器
			8、将播放器音调设为环绕立体声
		 */
		popper.on();
		popper.makePopcorn();
		light.down();
		projector.on();
		projector.open();
		computer.on();
		player.on();
		player.make3DListener();
	}
	
	public void stopMovie()
	{
		popper.off();
		popper.stopMakePopcorn();
		light.up();
		projector.close();
		projector.off();
		player.off();
		computer.off();
	}
}
```

## 享元模式

主要解决的问题

- 避免因创建大量对象而导致的内存溢出问题。
- 通过共享对象，提高内存使用效率。

使用场景

- 当系统中存在大量相似或相同的对象。
- 对象的创建和销毁成本较高。
- 对象的状态可以外部化，即对象的部分状态可以独立于对象本身存在。

实现方式

- 定义享元接口：创建一个享元接口，规定可以共享的状态。
- 创建具体享元类：实现该接口的具体类，包含内部状态。
- 使用享元工厂：创建一个工厂类，用于管理享元对象的创建和复用。

应用实例

* Java中的String对象：字符串常量池中已经存在的字符串会被复用。

* 数据库连接池：数据库连接被复用，避免频繁创建和销毁连接。

优点

- 减少内存消耗：通过共享对象，减少了内存中对象的数量。
- 提高效率：减少了对象创建的时间，提高了系统效率。

缺点

- 增加系统复杂度：需要分离内部状态和外部状态，增加了设计和实现的复杂性。
- 线程安全问题：如果外部状态处理不当，可能会引起线程安全问题。

享元模式包含以下几个核心角色：

- 享元工厂（Flyweight Factory）:

  - 负责创建和管理享元对象，通常包含一个池（缓存）用于存储和复用已经创建的享元对象。

- 具体享元（Concrete Flyweight）:

  - 实现了抽象享元接口，包含了内部状态和外部状态。内部状态是可以被共享的，而外部状态则由客户端传递。

- 抽象享元（Flyweight）:

  - 定义了具体享元和非共享享元的接口，通常包含了设置外部状态的方法。

- 客户端（Client）:

  - 使用享元工厂获取享元对象，并通过设置外部状态来操作享元对象。客户端通常不需要关心享元对象的具体实现。

  ```java
  public interface Shape {
      void draw();
  }
  
  public class Circle implements Shape{
      private String color;
      private int x;
      private int y;
      private int radius;
  
      public Circle(String color){
          this.color = color;
      }
  
      public void setX(int x) {
          this.x = x;
      }
  
      public void setY(int y) {
          this.y = y;
      }
  
      public void setRadius(int radius) {
          this.radius = radius;
      }
  
      @Override
      public void draw() {
          System.out.println("Circle: Draw() [Color : " + color
                  +", x : " + x +", y :" + y +", radius :" + radius);
      }
  }
  
  
  public class ShapeFactory {
      private static final HashMap<String, Shape> circleMap = new HashMap<>();
  
      public static Shape getCircle(String color) {
          Circle circle = (Circle)circleMap.get(color);
          if(circle == null) {
              circle = new Circle(color);
              circleMap.put(color, circle);
              System.out.println("Creating circle of color : " + color);
          }
          return circle;
      }
  }
  
  public class FlyweightTest {
      private static final String colors[] =
              {"Red", "Green", "Blue", "White", "Black"};
      @Test
      public void test() {
          for (int i = 0; i < 20; ++i) {
              Circle circle =
                      (Circle) ShapeFactory.getCircle(getRandomColor());
              circle.setX(getRandomX());
              circle.setY(getRandomY());
              circle.setRadius(100);
              circle.draw();
          }
      }
      private static String getRandomColor() {
          return colors[(int) (Math.random() * colors.length)];
      }
      private static int getRandomX() {
          return (int) (Math.random() * 100);
      }
      private static int getRandomY() {
          return (int) (Math.random() * 100);
      }
  }
  ```

![image-20240710172741089](D:\MyNote\picture\image-20240710172741089.png)

## 代理模式

代理模式是常见的设计模式之一，顾名思义，代理模式就是代理对象具备真实对象的功能，并代替真实对象完成相应操作，并能够在操作执行的前后，对操作进行增强处理。（为真实对象提供代理，然后供其他对象通过代理访问真实对象）

### 静态代理

```java
//统一租房接口
public interface IRentHouse {
    void rentHouse();
}

//租房真实实现类
public class RentHouse implements IRentHouse{
    @Override
    public void rentHouse() {
        System.out.println("实现租房");
    }
}

//租房中介代理
public class IntermediaryProxy implements IRentHouse{
    private IRentHouse iRentHouse;
    public IntermediaryProxy(IRentHouse iRentHouse){
        this.iRentHouse=iRentHouse;
    }
    @Override
    public void rentHouse() {
        System.out.println("交中介费");
        iRentHouse.rentHouse();
        System.out.println("中介复杂维修管理");
    }
}

public class Test {
    public static void main(String[] args) {
        IRentHouse rentHouse=new RentHouse();
        IRentHouse intermediaryProxy=new IntermediaryProxy(rentHouse);
        intermediaryProxy.rentHouse();
    }
}
```

![image-20240711170712921](D:\MyNote\picture\image-20240711170712921.png)

### 动态代理

从静态代理的代码中可以发现，静态代理的缺点显而易见，那就是当真实类的方法越来越多的时候，这样构建的代理类的代码量是非常大的，所以就引进动态代理。

动态代理允许使用一种方法的单个类（代理类）为具有任意数量方法的任意类（真实类）的多个方法调用提供服务，看到这句话，可以容易的联想到动态代理的实现与反射密不可分。
JAVA 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为 java 语言的反射机制。

#### jdk动态代理（接口代理）

```java
//代理类
public class JdkDynamicProxy implements InvocationHandler {
    private Object bean;

    public JdkDynamicProxy(Object bean) {
        this.bean = bean;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("wakeup".equals(methodName)) {
            System.out.print("早安~~~");
        } else if ("sleep".equals(methodName)) {
            System.out.print("晚安~~~");
        }
        return method.invoke(bean, args);
    }
}

public class Test {
    public static void main(String[] args) {
        JdkDynamicProxy proxy=new JdkDynamicProxy(new Student("张三"));
        //创建代理实例，第二个参数要使用接口进行代理
        Person studnet= (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class},proxy);
        studnet.wakeup();
        studnet.sleep();

        proxy=new JdkDynamicProxy(new Doctor("陈医生"));
        Person doctor= (Person) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Person.class},proxy);
        doctor.wakeup();
        doctor.sleep();

        proxy=new JdkDynamicProxy(new Cat("喵喵"));
        Animal cat= (Animal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Animal.class},proxy);
        cat.wakeup();
        cat.sleep();

        proxy=new JdkDynamicProxy(new Dog("旺旺"));
        Animal dog= (Animal) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), new Class[]{Animal.class},proxy);
        dog.wakeup();
        dog.sleep();
    }
}
```

![image-20240711174152150](D:\MyNote\picture\image-20240711174152150.png)

总结对比：
1.静态代理中，代理类和真实类实现的是同一个接口，重写同样的方法；jdk动态代理中，代理类和真实类关系不大，代理类实现无侵入式的代码扩展。
2.静态代理中当接口中方法增加的时候，在代理类代码量也会增加，显然是不妥的；jdk动态代理解决了这个问题，当业务增加，代理类的代码不会增加。
3.jdk动态代理实现的是jdk自带InvocationHandler接口，实现了这个接口的类也叫拦截器类，也叫代理类。

![img](D:\MyNote\picture\277f0bd971074802b64ad2f329ba9396.png)

#### cglib动态代理

从上面可以看出，jdk动态代理的前提条件是，要有接口存在，那还有许多场景是没有接口的，这个时候就需要cglib动态代理了，CGLIB(Code Generation Library)是一个基于ASM的字节码生成库，它允许我们在运行时对字节码进行修改和动态生成。CGLIB通过继承方式实现代理。

```java
public class CglibProxy implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();
    private Object bean;

    public CglibProxy(Object bean) {
        this.bean = bean;
    }

    public Object getProxy() {
        //设置需要创建子类的类
        enhancer.setSuperclass(bean.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        String methodName = method.getName();
        if (methodName.equals("wakeup")) {
            System.out.println("早安~~~");
        } else if (methodName.equals("sleep")) {
            System.out.println("晚安~~~");
        }
        return method.invoke(bean, objects);
    }
}

public class Test {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy(new Student("张三"));
        Student student = (Student) proxy.getProxy();
        student.wakeup();
        student.sleep();

        proxy = new CglibProxy(new Dog("旺财"));
        Dog dog = (Dog) proxy.getProxy();
        dog.wakeup();
        dog.sleep();
    }
}
```

![img](D:\MyNote\picture\4b05cd3ee6b74c6cb493522e677e0e6a.png)

cglib动态代理和jdk动态代理的区别显而易见，但是实现逻辑差不多，cglib代理类是通过实现MethodInterceptor，重写intercept方法，通过生成被代理类的子类来达到代理增强代码的目的；而Jdk代理是通过实现InvocationHandler，重写invoke方法，通过生成接口的代理类来达到代码增强的目的，所以jdk动态代理的实现需要接口，cglib则不需要。

## 模版方法模式

定义一个模板结构，将具体内容延迟到子类去实现。在不改变模板结构的前提下在子类中重新定义模板中的内容。

```java
public abstract class Worker
{
    protected String name;

    public Worker(String name)
    {
        this.name = name;
    }

    public final void workOneDay()
    {

        System.out.println("-----------------work start ---------------");
        enterCompany();
        computerOn();
        work();
        computerOff();
        exitCompany();
        System.out.println("-----------------work end ---------------");

    }

    public abstract void work();

    private void computerOff()
    {
        System.out.println(name + "关闭电脑");
    }

    private void computerOn()
    {
        System.out.println(name + "打开电脑");
    }

    public void enterCompany()
    {
        System.out.println(name + "进入公司");
    }

    void exitCompany()
    {
        System.out.println(name + "离开公司");
    }

}

public class ITWorker extends Worker{
    public ITWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("打代码");
    }
}

public class TestWorker extends Worker{
    public TestWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("测试代码");
    }
}

public class Test {
    public static void main(String[] args) {
        Worker itWorker=new ITWorker("a");
        itWorker.workOneDay();
        Worker testWorker=new TestWorker("b");
        testWorker.workOneDay();
    }
}
```

![image-20240712154409080](D:\MyNote\picture\image-20240712154409080.png)

## 命令模式

将请求封装成对象，将动作请求者和动作执行者解耦。

```java
public class Light {
    public void on()
    {
        System.out.println("打开电灯");
    }

    public void off()
    {
        System.out.println("关闭电灯");
    }
}

public class Door {
    public void open()
    {
        System.out.println("打开门");
    }

    public void close()
    {
        System.out.println("关闭门");
    }
}

//把命令封装成类
public interface Command {
    void execute();
}

public class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.on();
    }
}

public class LightOffCommand implements Command {
    private Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}

public class DoorOpenCommand implements Command{
    private Door door;
    public DoorOpenCommand(Door door){
        this.door=door;
    }
    @Override
    public void execute() {
        door.open();
    }
}

public class DoorCloseCommand implements Command{
    private Door door;
    public DoorCloseCommand(Door door){
        this.door=door;
    }
    @Override
    public void execute() {
        door.close();
    }
}

public class NoCommand implements Command{
    @Override
    public void execute() {

    }
}

public class ControlPanel {
    private Command[] commands;

    public ControlPanel() {
        commands = new Command[9];
        for (int i = 0; i < 9; i++) {
            commands[i] = new NoCommand();
        }
    }

    public void setCommands(int index, Command command) {
        commands[index] = command;
    }

    public void keyPressed(int index) {
        commands[index].execute();
    }
}

public class Test {
    public static void main(String[] args) {
        Light light=new Light();
        Door door=new Door();
        ControlPanel controlPanel=new ControlPanel();
        controlPanel.setCommands(0,new LightOnCommand(light));
        controlPanel.setCommands(1,new LightOffCommand(light));
        controlPanel.setCommands(2,new DoorOpenCommand(door));
        controlPanel.setCommands(3,new DoorCloseCommand(door));
        for (int i = 0; i < 9; i++) {
            controlPanel.keyPressed(i);
        }
    }
}
```

最后，继续来谈谈命令模式，命令模式就是把命令封装成对象，然后将动作请求者与动作执行者完全解耦，上例中遥控器的按钮和电器一毛钱关系都没吧。

还记得定义中提到了队列，命令模式如何用于队列呢，比如饭店有很多个点菜的地方，有一个做菜的地方，把点菜看作命令，做菜看作命令执行者，不断有人点菜就相当于把菜加入队列，对于做菜的只管从队列里面取，取一个做一个。

定义中还提到了日志，日志一般用于记录用户行为，或者在异常时恢复时用的，比如每个命令现在包含两个方法，一个执行execute，一个undo（上例中为了方便大家理解，没有写undo），我们可以把用户所有命令调用保存到日志中，比如用户操作不当了，电器异常了，只需要把日志中所有的命令拿出来执行一遍undo就完全恢复了，是吧，就是这么个意思。

## 迭代器模式

允许顺序访问一个聚合对象中的元素，同时不暴露对象的内部表示。提供一种统一的方法来遍历不同的聚合对象。当需要遍历一个聚合对象，而又不希望暴露其内部结构时。

```java
public interface Iterator {
    boolean hasNext();
    Object next();
}

public interface Container {
    Iterator getIterator();
}

public class NameContainer implements Container {
    private String[] names = {"A", "B", "C"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}

public class Test {
    public static void main(String[] args) {
        NameContainer nameContainer=new NameContainer();
        Iterator iterator = nameContainer.getIterator();
        while (iterator.hasNext()) {
            String name= (String) iterator.next();
            System.out.println(name);
        }
    }
}
```



## 观察者模式

定义了对象之间的一对多的依赖，这样一来，当一个对象改变时，它的所有的依赖者都会收到通知并自动更新。

```java
public interface Subject {
    /**
     * 注册一个观察着
     */
    void registerObserver(Observer observer);

    /**
     * 移除一个观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知所有的观察着
     */
    void notifyObservers();
}

//所有的观察者需要实现此接口
public interface Observer {
    void update(String msg);
}

public class MessageService implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String msg;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(msg);
        }
    }

    public void setMsg(String msg) {
        System.out.println("服务发送消息"+msg);
        this.msg = msg;
        notifyObservers();
    }
}

public class ObserverA implements Observer {
    private Subject subject;

    public ObserverA(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observerA得到消息" + msg);
    }
}

public class ObserverB implements Observer {
    private Subject subject;

    public ObserverB(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(String msg) {
        System.out.println("observerB得到消息" + msg);
    }
}

public class Test {
    public static void main(String[] args) {
        MessageService messageService=new MessageService();
        ObserverA observerA=new ObserverA(messageService);
        ObserverB observerB=new ObserverB(messageService);
        messageService.setMsg("买菜");
        messageService.setMsg("做饭");
    }
}
```

![image-20240715164443422](D:\MyNote\picture\image-20240715164443422.png)

## 中介者模式

中介者模式是一种行为型设计模式，它用于**减少对象之间互相通信的复杂性**。中介者模式通过创建一个中介者对象，将对象之间的通信集中交给该对象来处理，而不是直接相互交流，是符合迪米特原则。
迪米特原则：减少对象之间的依赖，即一个对象应当对其它对象有尽可能少的了解。

```java
//抽象中介者（Mediator）：物流中心
//定义：用于协调各个同事对象之间交互的通用接口
public interface LogisticsCenter {
    // 参与方注册方法，用于新增参与方
    void register(Participant participant);

    // 发送信息方法，用于同事之间的信息传递
    void send(String from, String to, String message);
}

public abstract class Participant {
    // 中介者对象
    protected final LogisticsCenter logisticsCenter;

    public Participant(LogisticsCenter logisticsCenter) {
        this.logisticsCenter = logisticsCenter;
    }

    // 消息发送方法，根据传递给中介者
    public abstract void send(String to, String message);

    // 消息接收方法，由中介者调用
    public abstract void receive(String message);
}

public class TransportCompany extends Participant{
    public TransportCompany(LogisticsCenter logisticsCenter) {
        super(logisticsCenter);
    }

    @Override
    public void send(String to, String message) {
        logisticsCenter.send("运输公司",to,message);
    }

    @Override
    public void receive(String message) {
        System.out.println("运输公司接到消息: " + message);
    }
}

public class Merchant extends Participant {
    public Merchant(LogisticsCenter logisticsCenter) {
        super(logisticsCenter);
    }

    @Override
    public void send(String to, String message) {
        logisticsCenter.send("商家", to, message);
    }

    @Override
    public void receive(String message) {
        System.out.println("商家接收到消息: " + message);
    }
}

public class LogisticsCenterImpl implements LogisticsCenter {
    // 参与方列表，用于管理同事之间的交互关系
    private final Map<String, Participant> participants = new HashMap<>();

    // 参与方注册方法的实现，向同事列表中添加参与方
    @Override
    public void register(Participant participant) {
        participants.put(participant.getClass().getSimpleName(), participant);
    }

    // 发送信息方法的实现，根据接收方信息调用接收方的消息接收方法
    @Override
    public void send(String from, String to, String message) {
        Participant participant = participants.get(to);
        if (participant != null) {
            participant.receive("Message from " + from + ": " + message);
        }
    }
}

public class Test{
    public static void main(String[] args) {
        LogisticsCenter logisticsCenter=new LogisticsCenterImpl();
        TransportCompany transportCompany=new TransportCompany(logisticsCenter);
        Merchant merchant=new Merchant(logisticsCenter);

        logisticsCenter.register(transportCompany);
        logisticsCenter.register(merchant);

        transportCompany.send("Merchant", "快递已送达");
        merchant.send("TransportCompany", "收到，幸苦了");
    }
}
```

![image-20240715173706968](D:\MyNote\picture\image-20240715173706968.png)

* 如果对象之间的交互关系复杂且难以维护，或者对象之间需要大量的相互调用和信息传递，可以考虑使用中介者模式来简化对象之间的通信和协调。
* 如果对象之间紧密耦合，修改一个对象可能会影响到其他相关对象，使得系统难以进行扩展和维护。使用中介者模式可以降低对象之间的耦合度，使得对象可以独立变化和复用。
* 当系统中存在一个有组织结构的集合，并且该集合中的对象之间需要相互通信和协作时。比如，一个群聊系统中的参与者之间需要进行信息传递和交流，此时可以使用中介者模式来管理参与者之间的通信。
* 当需要集中化管理和控制一些公共行为或操作时。中介者模式可以充当一个中心协调者，负责管理和调度相关对象的行为或操作。例如，在一个电梯控制系统中，电梯调度器扮演中介者的角色，控制电梯的运行和调度。

## 备忘录模式

备忘录模式又称**快照模式**，是一种行为型设计模式。它可以在不破坏封装性的前提下捕获一个对象的内部状态，并在对象之外保存这个状态，以便在需要的时候**恢复到原先保存的状态**。

* 源发器（Originator）：需要保存和恢复状态的对象。它创建一个备忘录对象，用于存储当前对象的状态，也可以使用备忘录对象恢复自身的状态。
* 备忘录（Memento）：存储源发器对象的状态。备忘录对象可以包括一个或多个状态属性，源发器可以根据需要保存和恢复状态。
* 管理者（Caretaker）：负责保存备忘录对象，但不能修改备忘录对象的内容。它可以存储多个备忘录对象，并决定何时将备忘录恢复给源发器。

```java
public class Editor {
    //内容（可以是属性、也可以是对象）
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // 创建备忘录对象，保存当前状态
    public EditorMemento createMemento() {
        return new EditorMemento(content);
    }

    // 恢复备忘录对象保存的状态
    public void restoreMemento(EditorMemento memento) {
        content = memento.getContent();
    }
}

public class EditorMemento {
    //文本内容 （可以是属性、也可以是对象）
    private  String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

public class History {
    //备忘录可以保存多个状态
    private final List<EditorMemento> mementos = new ArrayList<>();

    // 保存备忘录对象的状态
    public void push(EditorMemento memento) {
        mementos.add(memento);
    }

    // 弹出（移除）最近保存的备忘录对象，并返回它
    public EditorMemento pop() {
        int lastIndex = mementos.size() - 1;
        EditorMemento lastMemento = mementos.get(lastIndex);
        mementos.remove(lastIndex);
        return lastMemento;
    }

}

public class Test {
    public static void main(String[] args) {
        Editor editor=new Editor();
        History history=new History();

        editor.setContent("Hello");
        history.push(editor.createMemento());
        editor.setContent("Hello,CJW");
        System.out.println("当前"+editor.getContent());
        editor.restoreMemento(history.pop());
        System.out.println("回滚一次"+editor.getContent());
    }
}
```

优点：

状态保存与恢复：备忘录模式可以帮助我们保存对象的状态，并在需要时恢复到之前的状态。这在某些情况下非常有用，比如撤销操作或者程序崩溃后的恢复。
封装性和隔离性：可以确保对象的状态保存在备忘录对象中，而不会暴露给其他对象。这为对象的封装性和隔离性提供了保护，使得对象的状态变化对其他对象是透明的。
缺点：

内存占用：可能引起较大的内存占用，特别是当对象的状态较多且状态改变频繁时。每个备忘录对象都需要保存一份完整的状态，如果状态较多或者备忘录对象较多，可能会消耗大量内存。
性能开销：备忘录模式涉及到创建、存储和恢复状态的操作，这些操作可能引起一定的性能开销。特别是在状态较大或者对象较复杂的情况下，备忘录模式的性能可能会受到影响。

## 解释器模式

解释器模式字面意思，也即解释某些内容的含义。这种设计模式是实际开发中最不容易用到的。比如SQL解析，符号处理引擎，会用到解释器模式，属于更底层的开发人员才会用到的设计模式。对这部分内容了解即可。

## 状态模式

状态模式是一种行为型设计模式，它允许对象在内部状态改变时改变其行为，看起来像是对象更改了其类。状态模式将一个对象的状态作为一个独立的类来表示，这些状态的变化会导致对象的行为发生变化。

```java
public interface State {
    void handle();
}

public class ConcreteStateA implements State{
    @Override
    public void handle() {
        System.out.println("状态A");
    }
}


public class ConcreteStateB implements State{
    @Override
    public void handle() {
        System.out.println("状态B");
    }
}

//创建上下文类
public class Content {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(); // 调用当前状态的处理方法
    }
}

public class Test {
    public static void main(String[] args) {
        Content content=new Content();
        ConcreteStateA concreteStateA = new ConcreteStateA();
        content.setState(concreteStateA);
        content.request();
        ConcreteStateB concreteStateB = new ConcreteStateB();
        content.setState(concreteStateB);
        content.request();
    }
}
在上述代码中，状态模式中的状态（State）接口定义了状态相关的行为方法。具体状态类（ConcreteStateA和ConcreteStateB）实现了状态接口，具体实现了不同的状态行为。上下文类（Context）中包含一个状态对象，可以根据需要将当前状态切换为不同状态，并且会在状态改变时通知状体对象进行相应处理。
```

状态模式有以下优点：

* 增强了程序的可扩展性：由于状态和相应的行为被封装在不同的类中，因此可以相对容易地添加新的状态和行为。

* 将复杂的条件分支转换为轻量级的状态对象：通过使用状态模式，我们可以创建一组小而简单的状态类，每个状态类只负责实现特定的状态转换逻辑，而不是将所有逻辑都压缩到一个大的、难以维护和理解的“状态机”中。

* 促进代码的复用：将状态和相应的行为封装在不同的类中使得它们可以在多个对象之间共享，从而避免重复代码的出现。

缺点：

* 增加了类和对象的数量：由于需要定义独立的状态类，因此状态模式可能会增加类和对象的数量，这可能会增加系统的复杂性。

* 状态变化逻辑分散在多个状态类中：虽然该模式可以消除冗长的条件语句，但是状态之间的转换逻辑分散在多个状态类中，这可能会使代码难以理解和维护。

## 责任链模式

责任链模式：Chain of Responsibility Patten 。就是将链中的每一个结点看做是一个对象，每个结点处理请求均不同，且内部自动维护一个下一个结点对象。当请求从链条的首端出发时，会沿着链的路径依次传递给每一个结点的对象，直到有对象处理这个请求为止。

就是说每个结点会处理一件事情，如果结点间出现异常，那么链路就会中断。

一般比如说一个请假需要多个负责任审批，过五关斩六将等这些，都是责任链模式。

假设有一个学校有一个采购审批的需要，采购项目需要给领导审批，不同金钱范围，对应的审批领导的等级不同，

```java
public class ApproveRequest {
    private float price = 0.0f; //请求金额
    private int id = 0;
    //构造器
    public ApproveRequest( float price, int id) {
        this.price = price;
        this.id = id;
    }
    public float getPrice() { return price; }
    public int getId() { return id; }
}

public abstract class Approver {
    //下一个调用者
    Approver next ;
    //需要传入的名字
    String name ;

    public Approver(String name){
        this.name = name;
    }

    //设置下一个调用者
    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void processApprover(ApproveRequest approveRequest);
}

public class Level1Approver extends Approver{
    public Level1Approver(String name) {
        super(name);
    }

    @Override
    public void processApprover(ApproveRequest approveRequest) {
        if(approveRequest.getPrice() <= 5000) {
            System.out.println(" 请求编号 id= " + approveRequest.getId() + " 被 " + this.name + " 处理");
        }else {
            next.processApprover(approveRequest);
        }
    }
}

public class Level2Approver extends Approver{
    public Level2Approver(String name) {super(name); }
    @Override
    public void processApprover(ApproveRequest approveRequest) {
        if(approveRequest.getPrice() > 5000 && approveRequest.getPrice() <= 10000) {
            System.out.println(" 请求编号 id= " + approveRequest.getId() + " 被 " + this.name + " 处理");
        }else {
            next.processApprover(approveRequest);
        }
    }
}

public class Level3Approver extends Approver{
    public Level3Approver(String name) {
        super(name);
    }

    @Override
    public void processApprover(ApproveRequest approveRequest) {
        if(approveRequest.getPrice() >10000) {
            System.out.println(" 请求编号 id= " + approveRequest.getId() + " 被 " + this.name + " 处理");
        }else {
            next.processApprover(approveRequest);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        ApproveRequest approveRequest=new ApproveRequest(100000,10086);
        Level1Approver level1Approver=new Level1Approver("一级审批");
        Level2Approver level2Approver=new Level2Approver("二级审批");
        Level3Approver level3Approver=new Level3Approver("三级审批");

        level1Approver.setNext(level2Approver);
        level2Approver.setNext(level3Approver);

        level1Approver.processApprover(approveRequest);
    }
}
```

![image-20240718165510996](D:\MyNote\picture\image-20240718165510996.png)

**优点：**

- 是命令发出者与执行者解耦。
- 一个命令可以被多个处理器执行，例如各种框架中的拦截器

**缺点：**

- 设计模式通病：类增多了。如果组链时候不合理，可能导致请求得不到执行，还有可能将链变成一个环，请求在里面循环，永远都完不了。

## 访问者模式

访问者模式是一种行为型设计模式，它将==算法与其所作用的对象分离开来==，使得能够在不改变对象结构的前提下，对对象中的元素进行新的操作。该模式的核心思想是，定义一个访问者对象，并将其传递给需要被访问的对象，在对象接受访问者的访问时，会调用访问者对象中的方法，在该方法中实现对象对于访问者的响应操作。

抽象访问者（Visitor）：定义了访问者可以访问的元素、如何访问元素的方法，不同的具体访问者可以实现不同的访问方式。

具体访问者（ConcreteVisitor）：实现抽象访问者中定义的方法，对元素进行具体的操作。

抽象元素（Element）：定义了接受访问者访问的方法，不同的具体元素可以实现该方法以不同的方式响应访问者的访问。

具体元素（ConcreteElement）：实现抽象元素中定义的接受访问者访问的方法，并在其中调用访问者的访问方法。

对象结构（Object Structure）：定义了具体元素的集合，并提供了遍历集合中元素的方法。
```java
//抽象元素接口 Shape
public interface Shape {
    void accept(Visitor visitor);
}

public class Circle implements Shape {
    private int x;
    private int y;
    private int radius;

    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void accept(Visitor visitor) {
        visitor.visitCircle(this);
    }
}

public class Rectangle implements Shape {
    private int a;
    private int b;
    private int c;
    private int d;

    public Rectangle(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public void accept(Visitor visitor) {
        visitor.visitRectangle(this);
    }
}

//抽象访问者接口 Visitor
public interface Visitor {
    void visitCircle(Circle circle);
    void visitRectangle(Rectangle rectangle);
}

public class DrawingVisitor implements Visitor {
    @Override
    public void visitCircle(Circle circle) {
        // 画圆形
        System.out.println(String.format("Draw Circle, x=%d, y=%d, r=%d",
                circle.getX(), circle.getY(), circle.getRadius()));
    }
    @Override
    public void visitRectangle(Rectangle rectangle) {
        // 画矩形
        System.out.println(String.format("Draw Rectangle, x=%d, y=%d, w=%d, h=%d",
                rectangle.getA(), rectangle.getB(), rectangle.getC(), rectangle.getD()));
    }
}

public class Test {
    public static void main(String[] args) {
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Circle(10, 20, 5));
        shapes.add(new Rectangle(30, 40, 50, 60));
     
        Visitor visitor = new DrawingVisitor();
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }
    }
}

```

![image-20240718173124192](D:\MyNote\picture\image-20240718173124192.png)

## 策略模式

策略模式是一种行为型模式，它将对象和行为分开，将行为定义为 `一个行为接口` 和 `具体行为的实现`。策略模式最大的特点是行为的变化，行为之间可以相互替换。每个if判断都可以理解为就是一个策略。本模式使得算法可独立于使用它的用户而变化

![image-20240718173244808](D:\MyNote\picture\image-20240718173244808.png)

```java
//抽象策略类
public interface MemberStrategy {
    // 一个计算价格的抽象方法
    //price商品的价格 n商品的个数
    double calcPrice(double price, int n);
}

// 普通会员——不打折
public class PrimaryMemberStrategy implements MemberStrategy { // 实现策略
    //重写策略方法具体实现功能
    @Override
    public double calcPrice(double price, int n) {
        return price * n;
    }
}

// 中级会员 打百分之10的折扣
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double price, int n) {
        double money = (price * n) - price * n * 0.1;
        return money;
    }
}

// 高级会员类 20%折扣
public class AdvanceMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double price, int n) {
        double money = price * n - price * n * 0.2;
        return money;
    }
}

// 上下文类/环境类
public class MemberContext {
    // 用户折扣策略接口
    private MemberStrategy memberStrategy;

    // 注入构造方法
    public MemberContext(MemberStrategy memberStrategy) {
        this.memberStrategy = memberStrategy;
    }

    // 计算价格
    public double qoutePrice(double goodsPrice, int n){
        // 通过接口变量调用对应的具体策略
        return memberStrategy.calcPrice(goodsPrice, n);
    }
}

public class Test {
    public static void main(String[] args) {

        // 具体行为策略
        MemberStrategy primaryMemberStrategy = new PrimaryMemberStrategy(); // 接口回调（向上转型）
        MemberStrategy intermediateMemberStrategy = new IntermediateMemberStrategy();
        MemberStrategy advanceMemberStrategy = new AdvanceMemberStrategy();

        // 用户选择不同策略
        MemberContext primaryContext = new MemberContext(primaryMemberStrategy);
        MemberContext intermediateContext = new MemberContext(intermediateMemberStrategy);
        MemberContext advanceContext = new MemberContext(advanceMemberStrategy);

        //计算一本300块钱的书
        System.out.println("普通会员的价格："+ primaryContext.qoutePrice(300,1));// 普通会员：300
        System.out.println("中级会员的价格："+ intermediateContext.qoutePrice(300,1));// 中级会员 270
        System.out.println("高级会员的价格："+ advanceContext.qoutePrice(300,1));// 高级会员240
    }
}
```

（1）优点

* 策略模式提供了对“开闭原则”的完美支持，用户可以在不 修改原有系统的基础上选择算法或行为，也可以灵活地增加 新的算法或行为。

* 策略模式提供了管理相关的算法族的办法。

* 策略模式提供了可以替换继承关系的办法。

* 使用策略模式可以避免使用多重条件转移语句。

（2）缺点

* 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
* 策略模式将造成产生很多策略类，可以通过使用享元模式在一 定程度上减少对象的数量。









































