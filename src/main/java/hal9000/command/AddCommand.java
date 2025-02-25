package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;
import hal9000.task.TaskType;

/**
 * Handles the addition of Todo, Events and Deadline tasks
 */
public class AddCommand extends Command {

    private String userInput;
    private TaskType taskType;

    /**
     * Constructs an AddCommand with the user's input and its corresponding task type
     * @param userInput The complete input provided by the user
     * @param taskType The type of the task (eg. Todo, Event or Deadline)
     */
    public AddCommand(String userInput, TaskType taskType) {
        this.userInput = userInput;
        this.taskType = taskType;
    }

    /**
     * Splits the user input and adds the task to the task list
     * @param taskList The ArrayList containing all of the tasks
     * @param ui The Ui object used to display output to the users
     * @param storage The Storage object used to save and load tasks locally
     * @throws Hal9000Exception Exception to throw if there is an error in adding task
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        if (taskType == TaskType.TODO) {

            taskList.addTask(parsedText.findTodoTaskName(), TaskType.TODO);

            System.out.println(lineSeparator + "\n" +
                    "I have successfully added this task:" + "\n" + "[T][ ] " + parsedText.findTodoTaskName());
            System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

        } else if (taskType == TaskType.DEADLINE) {

            taskList.addTask(parsedText.findDeadlineTaskName(), TaskType.DEADLINE, parsedText.findDeadlineBy());

            System.out.println(lineSeparator + "\n" +
                    "I have successfully added this task:" + "\n" + "[D][ ] " + parsedText.findDeadlineTaskName()
                    + " (by: " + parsedText.findDeadlineBy() + ")");
            System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

        } else if (taskType == TaskType.EVENT) {

            taskList.addTask(parsedText.findEventTaskName(), TaskType.EVENT, parsedText.findEventFrom(),
                    parsedText.findEventTo());

            System.out.println(lineSeparator + "\n" +
                    "I have successfully added this task:" + "\n" + "[E][ ] " + parsedText.findEventTaskName()
                    + " (from: " + parsedText.findEventFrom() + " to: " + parsedText.findEventTo() + ")");
            System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);


        }
    }
}
