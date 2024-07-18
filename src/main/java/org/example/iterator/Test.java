package org.example.iterator;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class Test {
    public static void main(String[] args) {
        NameContainer nameContainer=new NameContainer();
        Iterator iterator = nameContainer.getIterator();
        while (iterator.hasNext()) {
            String name= (String) iterator.next();
            System.out.println(name);
        }
    }
}
