package org.example.adapter;

import org.junit.Test;

/**
 * @author CJW
 * @since 2024/7/5
 */
public class AdapterTest {
    @Test
    public void test(){
        Mobile mobile=new Mobile();
        V5Power v5Power=new V5PowerAdapter(new V220Power());
        mobile.inoutPower(v5Power);
    }
}
