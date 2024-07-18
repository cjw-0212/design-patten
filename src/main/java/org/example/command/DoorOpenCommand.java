package org.example.command;

/**
 * @author CJW
 * @since 2024/7/12
 */
public class DoorOpenCommand implements Command{
    private Door door;
    public DoorOpenCommand(Door door){
        this.door=door;
    }
    @Override
    public void execute() {
        door.open();
    }
}
