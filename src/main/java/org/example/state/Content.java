package org.example.state;

/**
 * @author CJW
 * @since 2024/7/17
 */
//创建上下文类
public class Content {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handle(); // 调用当前状态的处理方法
    }
}
