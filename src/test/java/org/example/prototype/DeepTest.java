package org.example.prototype;

import org.example.prototype.deep.Email;
import org.example.prototype.shallow.Attachment;
import org.junit.Test;

/**
 * @author CJW
 * @since 2024/6/7
 */
public class DeepTest {
    @Test
    public void test() throws CloneNotSupportedException {
        Email email=new Email(new Attachment());
        Email cloneEmail=email.clone();
        System.out.println(email ==cloneEmail);
        System.out.println(email.getAttachment() == cloneEmail.getAttachment());
    }
}
