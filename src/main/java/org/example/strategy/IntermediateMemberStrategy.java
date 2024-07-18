package org.example.strategy;

/**
 * @author CJW
 * @since 2024/7/18
 */
// 中级会员 打百分之10的折扣
public class IntermediateMemberStrategy implements MemberStrategy{
    @Override
    public double calcPrice(double price, int n) {
        double money = (price * n) - price * n * 0.1;
        return money;
    }
}


