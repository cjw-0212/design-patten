package org.example.strategy;

/**
 * @author CJW
 * @since 2024/7/18
 */
//抽象策略类
public interface MemberStrategy {
    // 一个计算价格的抽象方法
    //price商品的价格 n商品的个数
    double calcPrice(double price, int n);
}


