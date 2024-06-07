package org.example.prototype.deep;

import org.example.prototype.shallow.Attachment;

import java.io.*;

/**
 * @author CJW
 * @since 2024/6/7
 */
public class Email implements Serializable,Cloneable{
    private Attachment attachment = null;

    public Email(Attachment attachment) {
        this.attachment = attachment;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Email deepClone() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Email) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Email clone() throws CloneNotSupportedException {
        Attachment cloneAttachment = (Attachment) this.attachment.clone();
        Email cloneEmail = (Email) super.clone();
        cloneEmail.setAttachment(cloneAttachment);
        return cloneEmail;
    }
}
