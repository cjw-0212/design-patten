package org.example.decorator;

/**
 * @author CJW
 * @since 2024/7/8
 */
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
