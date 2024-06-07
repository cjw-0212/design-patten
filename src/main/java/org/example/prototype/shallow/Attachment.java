package org.example.prototype.shallow;

import java.io.Serializable;

/**
 * @author CJW
 * @since 2024/6/7
 */
public class Attachment implements Serializable,Cloneable{
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
