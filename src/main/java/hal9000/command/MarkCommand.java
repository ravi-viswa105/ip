package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;
import hal9000.task.TaskType;

/**
 * Handles marking and unmarking of tasks
 */
public class MarkCommand extends Command {

    private String userInput;
    private TaskType taskType;

    /**
     * Constructs a MarkCommand with the user's input
     * @param userInput The complete input provided by the user
     * @param taskType The type of the task (eg. Todo, Event or Deadline)
     */
    public MarkCommand(String userInput, TaskType taskType) {
        this.userInput = userInput;
        this.taskType = taskType;
    }

    /**
     *
     * @param taskList The ArrayList containing all of the tasks
     * @param ui The Ui object used to display output to the users
     * @param storage The Storage object used to save and load tasks locally
     * @throws Hal9000Exception Exception to throw if there is an error in adding task
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        if (taskType == TaskType.MARK) {
            int markIndex = parsedText.findMarkIndex();
            taskList.markAsDone(markIndex);

            System.out.println(lineSeparator + "\n" +
                    "Of course, I have successfully marked the task as completed." + "\n" +
                    taskList.printTask(markIndex) + "\n" + lineSeparator);

        } else if (taskType == TaskType.UNMARK) {
            int unmarkIndex = parsedText.findUnmarkIndex();
            taskList.markAsNotDone(parsedText.findUnmarkIndex());

            System.out.println(lineSeparator + "\n" +
                    "Of course, I have successfully marked the task as incomplete." + "\n" +
                    taskList.printTask(unmarkIndex) + "\n" + lineSeparator);

        }
    }
}
