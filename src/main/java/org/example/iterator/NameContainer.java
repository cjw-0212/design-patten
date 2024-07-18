package org.example.iterator;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class NameContainer implements Container {
    private String[] names = {"A", "B", "C"};

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    private class NameIterator implements Iterator {
        int index;

        @Override
        public boolean hasNext() {
            return index < names.length;
        }

        @Override
        public Object next() {
            if (this.hasNext()) {
                return names[index++];
            }
            return null;
        }
    }
}
