package org.example.memento;

/**
 * @author CJW
 * @since 2024/7/17
 */
public class Editor {
    //内容（可以是属性、也可以是对象）
    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    // 创建备忘录对象，保存当前状态
    public EditorMemento createMemento() {
        return new EditorMemento(content);
    }

    // 恢复备忘录对象保存的状态
    public void restoreMemento(EditorMemento memento) {
        content = memento.getContent();
    }
}
