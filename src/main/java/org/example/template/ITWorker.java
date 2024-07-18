package org.example.template;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class ITWorker extends Worker{
    public ITWorker(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("打代码");
    }
}
