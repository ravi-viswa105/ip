package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;
import hal9000.task.TaskType;

public class AddCommand extends Command {

    private String userInput;
    private TaskType taskType;

    public AddCommand(String userInput, TaskType taskType) {
        this.userInput = userInput;
        this.taskType = taskType;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        if (taskType == TaskType.TODO) {

            taskList.addTask(parsedText.findTodoTaskName(), TaskType.TODO);

            System.out.println(lineSeparator + "\n" +
                    "I have successfully added this task:" + "\n" + taskList.printTask(taskList.getTaskCount()));
            System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

        } else if (taskType == TaskType.DEADLINE) {

            taskList.addTask(parsedText.findDeadlineTaskName(), TaskType.DEADLINE, parsedText.findDeadlineBy());

            System.out.println(lineSeparator + "\n" +
                    "I have successfully added this task:" + "\n" + taskList.printTask(taskList.getTaskCount()));
            System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

        } else if (taskType == TaskType.EVENT) {

            taskList.addTask(parsedText.findEventTaskName(), TaskType.EVENT, parsedText.findEventFrom(),
                    parsedText.findEventTo());

            System.out.println(lineSeparator + "\n" +
                    "I have successfully added this task:" + "\n" + taskList.printTask(taskList.getTaskCount()));
            System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);


        }
    }
}
