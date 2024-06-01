# design-patten-java(设计模式详解与案例实现)

## 单例模式

### 目的

确保应用中只有一个对象存在，也就是保证一个类在内存中的对象唯一性。实现步骤如下：

* 私有化构造方法
* 在本类中new一个对象
* 使用一个共有的方法，将在类中创建的实例返回
### 实现方案
1. 饿汉式

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
* 在**类加载的时候就完成了对象的实例化，避免了线程同步的问题**。 
* 类加载的时候就是实例化了，也就是说即使后续没用使用到他也是存在的，占用了内存资源，但是占用内存很小就可以忽略不计，所以这种方式 是**推荐使用**的。
---

2. 懒汉式
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
* **被调用的时候才实例化**
* **存在线程安全问题**，在多线程并发的情况下当前一个线程判断为null进入后还未实例化之前，有新的线程进去就会创建多个对象。多线程测试结果如下：
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
* **线程安全**
* 每一个线程在获取实例的时候都需要进行同步，**效率太低**。
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
* 在判断null之后进行同步，**线程不安全**，在多线程并发的情况下当前一个线程判断为null进入后还未实例化之前，有新的线程通过if就会创建多个对象。
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
* 双重检查，**线程安全**。
* **兼具了延迟加载同时效率高**。
---
3. 内部类
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
* **外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存。**
---
4. 枚举方式
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
* 实现简单，**线程安全**

