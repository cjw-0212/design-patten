package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
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
