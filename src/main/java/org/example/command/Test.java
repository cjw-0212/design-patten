package org.example.command;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class Test {
    public static void main(String[] args) {
        Light light=new Light();
        Door door=new Door();
        ControlPanel controlPanel=new ControlPanel();
        controlPanel.setCommands(0,new LightOnCommand(light));
        controlPanel.setCommands(1,new LightOffCommand(light));
        controlPanel.setCommands(2,new DoorOpenCommand(door));
        controlPanel.setCommands(3,new DoorCloseCommand(door));
        for (int i = 0; i < 9; i++) {
            controlPanel.keyPressed(i);
        }
    }
}
