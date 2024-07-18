package org.example.adapter;

/**
 * @author CJW
 * @since 2024/7/5
 */
public class V5PowerAdapter implements V5Power{
    private V220Power v220Power;
    public V5PowerAdapter(V220Power v220Power){
        this.v220Power=v220Power;
    }
    @Override
    public int provideV5() {
        //将电压适配为5V
        return v220Power.provideV220Power()-215;
    }
}
