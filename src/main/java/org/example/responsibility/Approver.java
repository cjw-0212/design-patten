package org.example.responsibility;

/**
 * @author CJW
 * @since 2024/7/18
 */
public abstract class Approver {
    //下一个调用者
    Approver next ;
    //需要传入的名字
    String name ;

    public Approver(String name){
        this.name = name;
    }

    //设置下一个调用者
    public void setNext(Approver next) {
        this.next = next;
    }

    public abstract void processApprover(ApproveRequest approveRequest);
}
