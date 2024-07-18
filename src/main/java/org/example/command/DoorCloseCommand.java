package org.example.command;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class DoorCloseCommand implements Command{
    private Door door;
    public DoorCloseCommand(Door door){
        this.door=door;
    }
    @Override
    public void execute() {
        door.close();
    }
}
