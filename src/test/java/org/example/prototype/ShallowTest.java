package org.example.prototype;

import org.example.prototype.shallow.Attachment;
import org.example.prototype.shallow.Email;
import org.junit.Test;

/**
 * @author CJW
 * @since 2024/6/7
 */
public class ShallowTest {
    @Test
    public void test(){
        Email email=new Email(new Attachment());
        Email cloneEmail=email.clone();
        System.out.println(email==cloneEmail);
        System.out.println(email.getAttachment()==cloneEmail.getAttachment());
    }
}
