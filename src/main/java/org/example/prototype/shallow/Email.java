package org.example.prototype.shallow;

/**
 * @author CJW
 * @since 2024/6/7
 */
public class Email implements Cloneable {
    private Attachment attachment = null;

    public Email(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return this.attachment;
    }

    @Override
    public Email clone() {
        try {
            return (Email) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
