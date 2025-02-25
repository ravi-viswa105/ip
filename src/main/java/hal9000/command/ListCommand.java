package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.task.TaskList;
import hal9000.task.TaskType;

/**
 * Handles printing of list
 */
public class ListCommand extends Command {

    /**
     * Lists all the tasks in taskList
     * @param taskList The ArrayList containing all of the tasks
     * @param ui The Ui object used to display output to the users
     * @param storage The Storage object used to save and load tasks locally
     * @throws Hal9000Exception Exception to throw if there is error in deleting task
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        taskList.listTasks();
    }

}
