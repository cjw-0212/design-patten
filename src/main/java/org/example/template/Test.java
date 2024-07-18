package org.example.template;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class Test {
    public static void main(String[] args) {
        Worker itWorker=new ITWorker("a");
        itWorker.workOneDay();
        Worker testWorker=new TestWorker("b");
        testWorker.workOneDay();
    }
}
