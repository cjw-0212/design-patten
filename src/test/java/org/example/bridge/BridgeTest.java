package org.example.bridge;

import org.junit.Test;

/**
 * @author CJW
 * @since 2024/7/8
 */
public class BridgeTest {
    @Test
    public void test(){
        Circle redCircle=new Circle(1,2,3,new RedCircle());
        Circle blackCircle=new Circle(1,2,3,new BlackCircle());
        redCircle.draw();
        blackCircle.draw();;
    }
}
