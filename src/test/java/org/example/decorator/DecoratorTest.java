package org.example.decorator;

import org.junit.Test;

/**
 * @author CJW
 * @since 2024/7/8
 */
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
