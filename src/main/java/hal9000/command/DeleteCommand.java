package hal9000.command;

import hal9000.Ui;
import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;

/**
 * Handles deletion of tasks
 */
public class DeleteCommand extends Command {

    private String userInput;

    /**
     * Constructs a DeleteCommand with the user's input
     * @param userInput The complete input provided by the user
     */
    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    /**
     * Deletes the task by the index specified by the user
     * @param taskList The ArrayList containing all of the tasks
     * @param ui The Ui object used to display output to the users
     * @param storage The Storage object used to save and load tasks locally
     * @throws Hal9000Exception Exception to throw if there is error in deleting task
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        int deleteIndex = parsedText.findDeleteIndex();
        if (deleteIndex < 1 || deleteIndex > taskList.getTaskCount()) {
            throw new Hal9000Exception("You cannot delete this task as it is out of bounds");
        }

        System.out.println(lineSeparator + "\n" +
                "Of course, I have successfully deleted this task:" + "\n" +
                taskList.printTask(deleteIndex));

        taskList.deleteTask(parsedText.findDeleteIndex());
        System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);
    }
}
