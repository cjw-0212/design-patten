package org.example.command;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class ControlPanel {
    private Command[] commands;

    public ControlPanel() {
        commands = new Command[9];
        for (int i = 0; i < 9; i++) {
            commands[i] = new NoCommand();
        }
    }

    public void setCommands(int index, Command command) {
        commands[index] = command;
    }

    public void keyPressed(int index) {
        commands[index].execute();
    }
}
