package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.task.TaskList;
import hal9000.Ui;



public abstract class Command {
    public abstract void execute (TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception;

    public boolean isExit() {
        return false;
    }
}

