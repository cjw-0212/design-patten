package org.example.memento;

/**
 * @author CJW
 * @since 2024/7/17
 */
public class Test {
    public static void main(String[] args) {
        Editor editor=new Editor();
        History history=new History();

        editor.setContent("Hello");
        history.push(editor.createMemento());
        editor.setContent("Hello,CJW");
        System.out.println("当前"+editor.getContent());
        editor.restoreMemento(history.pop());
        System.out.println("回滚一次"+editor.getContent());
    }
}
