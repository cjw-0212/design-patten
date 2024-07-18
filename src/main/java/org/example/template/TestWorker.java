package org.example.template;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class TestWorker extends Worker{
    public TestWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("测试代码");
    }
}
