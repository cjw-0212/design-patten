package org.example.strategy;

/**
 * @author CJW
 * @since 2024/7/18
 */
// 普通会员——不打折
public class PrimaryMemberStrategy implements MemberStrategy { // 实现策略
    //重写策略方法具体实现功能
    @Override
    public double calcPrice(double price, int n) {
        return price * n;
    }
}

