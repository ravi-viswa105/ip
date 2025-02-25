package hal9000.command;

import hal9000.Hal9000Exception;
import hal9000.Storage;
import hal9000.Ui;
import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;
import java.util.ArrayList;

/**
 * Handles Find Command
 */
public class FindCommand extends Command {

    private String userInput;

    /**
     * Constructs a Find Command with the user input
     * @param userInput The complete input provided by the user
     */
    public FindCommand(String userInput) {
        this.userInput = userInput;
    }

    /**
     *
     * @param taskList The ArrayList containing all of the tasks
     * @param ui The Ui object used to display output to the users
     * @param storage The Storage object used to save and load tasks locally
     * @throws Hal9000Exception Exception to throw if there is error in deleting task
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws Hal9000Exception {
        final String lineSeparator = "________________________________________________________________";
        UserInputParser parsedText = new UserInputParser(userInput);
        String FindWord = parsedText.findSearchName();
        if (FindWord == "") {
            System.out.println(lineSeparator + "\nPlease enter a word to find\n" + lineSeparator);
            return;
        }
        ArrayList<Integer> tasksWithWord = new ArrayList<>();
        for (int i = 1; i < taskList.getTaskCount() + 1; i++) {
            String taskName = taskList.getTaskName(i);
            if (taskName.contains(FindWord)) {
                tasksWithWord.add(i);
            }
        }
        if (!tasksWithWord.isEmpty()) {
            System.out.println(lineSeparator + "\nUser, these are the matching tasks in your list");
            for (int taskId : tasksWithWord) {
                System.out.println(taskId + ". " + taskList.taskToString(taskId));
            }
            System.out.println(lineSeparator);
        } else {
            System.out.println("No tasks with keyword: " + FindWord );
        }
    }

}
