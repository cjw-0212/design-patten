package org.example.responsibility;

/**
 * @author CJW
 * @since 2024/7/18
 */
public class Test {
    public static void main(String[] args) {
        ApproveRequest approveRequest=new ApproveRequest(100000,10086);
        Level1Approver level1Approver=new Level1Approver("一级审批");
        Level2Approver level2Approver=new Level2Approver("二级审批");
        Level3Approver level3Approver=new Level3Approver("三级审批");

        level1Approver.setNext(level2Approver);
        level2Approver.setNext(level3Approver);

        level1Approver.processApprover(approveRequest);
    }
}
