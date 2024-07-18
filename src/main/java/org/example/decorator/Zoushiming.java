package org.example.decorator;

/**
 * @author CJW
 * @since 2024/7/8
 */
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
