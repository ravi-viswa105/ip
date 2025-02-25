package hal9000.command;

import hal9000.Ui;
import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;

public class DeleteCommand extends Command {

    private String userInput;

    public DeleteCommand(String userInput) {
        this.userInput = userInput;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        int deleteIndex = parsedText.findDeleteIndex();
        if (deleteIndex < 1 || deleteIndex > taskList.getTaskCount()) {
            throw new Hal9000Exception("You cannot delete this task as it is out of bounds");
        }

        System.out.println(lineSeparator + "\n" +
                "Of course, I have successfully deleted this task:" + "\n" +
                taskList.taskToString(deleteIndex));

        taskList.deleteTask(parsedText.findDeleteIndex());
        System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);
    }
}
