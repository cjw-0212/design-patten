package org.example.bridge;

/**
 * @author CJW
 * @since 2024/7/8
 */
//抽象接口实现类
public class BlackCircle implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: black, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
