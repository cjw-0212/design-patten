package org.example.singleton;

/**
 * @author CJW
 * @since 2024/5/31
 */
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
