package org.example.command;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class LightOnCommand implements Command{
    private Light light;
    public LightOnCommand(Light light){
        this.light=light;
    }
    @Override
    public void execute() {
        light.on();
    }
}
