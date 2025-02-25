package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;
import hal9000.task.TaskType;

public class MarkCommand extends Command {

    private String userInput;
    private TaskType taskType;

    public MarkCommand(String userInput, TaskType taskType) {
        this.userInput = userInput;
        this.taskType = taskType;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        if (taskType == TaskType.MARK) {
            int markIndex = parsedText.findMarkIndex();
            taskList.markAsDone(markIndex);

            System.out.println(lineSeparator + "\n" +
                    "Of course, I have successfully marked the task as completed." + "\n" +
                    taskList.taskToString(markIndex) + "\n" + lineSeparator);

        } else if (taskType == TaskType.UNMARK) {
            int unmarkIndex = parsedText.findUnmarkIndex();
            taskList.markAsNotDone(parsedText.findUnmarkIndex());

            System.out.println(lineSeparator + "\n" +
                    "Of course, I have successfully marked the task as incomplete." + "\n" +
                    taskList.taskToString(unmarkIndex) + "\n" + lineSeparator);

        }
    }
}
