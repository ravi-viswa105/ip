package hal9000.parser;

import hal9000.Hal9000Exception;
import hal9000.command.*;
import hal9000.task.TaskType;

/**
 * Handles parsing of user input
 * Identifies type of command issued by user
 */
public class UserInputParser {

    private String userInput;
    String[] inputSplit;

    /**
     * Constructs a UserInputParser object and sets the user input
     * Splits user input by spaces
     * @param userInput The complete input provided by the user
     */
    public UserInputParser(String userInput) {
        this.userInput = userInput;
        inputSplit = userInput.split(" ");
    }

    /**
     * Identifies the type of command input by the user
     * @return command corresponding to type of input
     * @throws Hal9000Exception If type of task is not valid
     */
    public Command parse() throws Hal9000Exception {
        return switch (inputSplit[0]) {
            case "todo", "event", "deadline" -> new AddCommand(userInput, findTaskType());
            case "mark", "unmark" -> new MarkCommand(userInput, findTaskType());
            case "bye" -> new ExitCommand();
            case "list" -> new ListCommand();
            case "delete" -> new DeleteCommand(userInput);
            case "find" -> new FindCommand(userInput);
            default -> throw new Hal9000Exception("I'm sorry User. I'm afraid I can't do that");
        };
    }

    /**
     * Identifies the type of command input by the user
     * @return TaskType corresponding to type of input
     * @throws Hal9000Exception If type of task is not valid
     */
    public TaskType findTaskType() throws Hal9000Exception {
        return switch (inputSplit[0]) {
            case "todo" -> TaskType.TODO;
            case "deadline" -> TaskType.DEADLINE;
            case "event" -> TaskType.EVENT;
            case "mark" -> TaskType.MARK;
            case "unmark" -> TaskType.UNMARK;
            case "bye" -> TaskType.BYE;
            case "list" -> TaskType.LIST;
            case "delete" -> TaskType.DELETE;
            case "find" -> TaskType.FIND;
            default -> throw new Hal9000Exception("I'm sorry User. I'm afraid I can't do that");
        };
    }

    /**
     * Finds the name of todo task
     * @return name of todo task in string
     * @throws Hal9000Exception if the name of the task is empty
     */
    public String findTodoTaskName() throws Hal9000Exception {
        String filteredTaskName = userInput.substring(4).trim();
        if (filteredTaskName.isEmpty()) {
            throw new Hal9000Exception("User, the task name cannot be empty");
        }
        return userInput.substring(4).trim();
    }

    /**
     * Finds the name of deadline task
     * @return name of deadline task in string
     * @throws Hal9000Exception if the name of the task is empty
     */
    public String findDeadlineTaskName() throws Hal9000Exception {
        String filteredTaskName = userInput.split("/by")[0].substring(8).trim();
        if (filteredTaskName.isEmpty()) {
            throw new Hal9000Exception("User, the task name cannot be empty");
        }
        return filteredTaskName;
    }

    /**
     * Finds the name of event task
     * @return name of event task in string
     * @throws Hal9000Exception if the name of the task is empty
     */
    public String findEventTaskName() throws Hal9000Exception {
        String filteredTaskName = userInput.split("/from")[0].substring(5).trim();
        if (filteredTaskName.isEmpty()) {
            throw new Hal9000Exception("User, the task name cannot be empty");
        }
        return filteredTaskName;
    }

    /**
     * Finds the by date of deadline task
     * @return by date of deadline task in string
     * @throws Hal9000Exception if the by date is empty
     */
    public String findDeadlineBy() throws Hal9000Exception {
        String[] splitUserInput = userInput.split("/by");
        if (splitUserInput.length < 2) {
            throw new Hal9000Exception("Sorry User, you forgot to include a /by time");
        }
        return splitUserInput[1].trim();
    }

    /**
     * Finds the from date of event task
     * @return from date of event task
     * @throws Hal9000Exception if the from date is empty
     */
    public String findEventFrom() throws Hal9000Exception {
        String filteredTaskName = userInput.split("/to")[0].trim();
        String[] splitUserInput = filteredTaskName.split("/from");
        if (splitUserInput.length < 2) {
            throw new Hal9000Exception("Sorry User, you forgot to include a /from time");
        }
        return splitUserInput[1].trim();
    }

    /**
     * Finds the to date of event task
     * @return to date of event task
     * @throws Hal9000Exception if the to date is empty
     */
    public String findEventTo() throws Hal9000Exception {
        String[] splitUserInput = userInput.split("/to");
        if (splitUserInput.length < 2) {
            throw new Hal9000Exception("Sorry User, you forgot to include a /to time");
        }
        return splitUserInput[1].trim();
    }

    public String findSearchName() throws Hal9000Exception {
        return userInput.substring(4).trim();
    }

    /**
     * Finds the index of the task to be marked
     * @return index of the task to be marked
     */
    public int findMarkIndex() {
        return Integer.parseInt(userInput.substring(4).trim());
    }

    /**
     * Finds the index of the task to be unmarked
     * @return index of the task to be unmarked
     */
    public int findUnmarkIndex() {
        return Integer.parseInt(userInput.substring(6).trim());
    }

    /**
     * Finds the index of the task to be deleted
     * @return index of the task to be deleted
     */
    public int findDeleteIndex() {
        return Integer.parseInt(userInput.substring(6).trim());
    }



}




