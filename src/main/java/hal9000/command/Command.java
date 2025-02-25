package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.task.TaskList;
import hal9000.Ui;

/**
 * Abstract class to abstract all commands
 * Tracks exit status to check if application should be exited
 */
public abstract class Command {
    public abstract void execute (TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception;

    /**
     * Sets isExit to false by default to continue loop
     * @return false if Command is not ExitCommand (Overridden in ExitCommand)
     */
    public boolean isExit() {
        return false;
    }
}

