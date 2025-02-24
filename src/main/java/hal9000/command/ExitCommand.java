package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.task.TaskList;

public class ExitCommand extends Command {

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        Ui.showExitMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }

}
