package org.example.memento;

/**
 * @author CJW
 * @since 2024/7/17
 */
public class EditorMemento {
    //文本内容 （可以是属性、也可以是对象）
    private  String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
