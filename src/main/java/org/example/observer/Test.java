package org.example.observer;

/**
 * @author CJW
 * @since 2024/7/15
 */
public class Test {
    public static void main(String[] args) {
        MessageService messageService=new MessageService();
        ObserverA observerA=new ObserverA(messageService);
        ObserverB observerB=new ObserverB(messageService);
        messageService.setMsg("买菜");
        messageService.setMsg("做饭");
    }
}
