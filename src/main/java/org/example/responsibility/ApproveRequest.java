package org.example.responsibility;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class ApproveRequest {
    private float price = 0.0f; //请求金额
    private int id = 0;
    //构造器
    public ApproveRequest( float price, int id) {
        this.price = price;
        this.id = id;
    }
    public float getPrice() { return price; }
    public int getId() { return id; }
}
