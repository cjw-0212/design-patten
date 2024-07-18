package org.example.decorator;

/**
 * @author CJW
 * @since 2024/7/8
 */
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
