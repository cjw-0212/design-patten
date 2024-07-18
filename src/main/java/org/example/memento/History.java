package org.example.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author CJW
 * @since 2024/7/17
 */
public class History {
    //备忘录可以保存多个状态
    private final List<EditorMemento> mementos = new ArrayList<>();

    // 保存备忘录对象的状态
    public void push(EditorMemento memento) {
        mementos.add(memento);
    }

    // 弹出（移除）最近保存的备忘录对象，并返回它
    public EditorMemento pop() {
        int lastIndex = mementos.size() - 1;
        EditorMemento lastMemento = mementos.get(lastIndex);
        mementos.remove(lastIndex);
        return lastMemento;
    }

}
