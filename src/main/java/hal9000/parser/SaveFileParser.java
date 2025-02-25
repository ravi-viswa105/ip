package hal9000.parser;

import hal9000.task.TaskType;

/**
 * Handles parsing from save file to load into program upon starting
 */
public class SaveFileParser {

    private String saveData;

    /**
     * Constructs a SaveFileParser object and sets save file directory
     * @param saveData Save file directory
     */
    public SaveFileParser(String saveData) {
        this.saveData = saveData;
    }

    /**
     * Reads save file to find task type
     * @return TaskType of line
     */
    public TaskType findTaskType() {
        return switch (saveData.charAt(1)) {
            case 'T' -> TaskType.TODO;
            case 'D' -> TaskType.DEADLINE;
            case 'E' -> TaskType.EVENT;
            default -> TaskType.NONE;
        };
    }

    /**
     * Checks save file line to find task completion status
     * @return completion status of task
     */
    public boolean isTaskComplete() {
        if (saveData.charAt(4) == 'X') {
            return true;
        }
        return false;
    }

    /**
     * Finds the name of todo task
     * @return name of todo task in string
     */
    public String findTodoTaskName() {
        return saveData.substring(7);
    }

    /**
     * Finds the name of deadline task
     * @return name of deadline task in string
     */
    public String findDeadlineTaskName() {
        return saveData.split("\\(by:")[0].substring(7).trim();
    }

    /**
     * Finds the by date of deadline task
     * @return by date of deadline task in string
     */
    public String findDeadlineBy() {
        String removedClosingBracket = saveData.substring(0, saveData.length() - 1);
        return removedClosingBracket.split("\\(by:")[1].trim();
    }

    /**
     * Finds the name of event task
     * @return name of event task in string
     */
    public String findEventTaskName() {
        return saveData.split("\\(from:")[0].substring(7).trim();
    }

    /**
     * Finds the from date of event task
     * @return from date of event task
     */
    public String findEventFrom() {
        String removedTo = saveData.split("to:")[0].trim();
        return removedTo.split("\\(from:")[1].trim();
    }

    /**
     * Finds the to date of event task
     * @return to date of event task
     */
    public String findEventTo() {
        String removedClosingBracket = saveData.substring(0, saveData.length() - 1);
        return removedClosingBracket.split("to:")[1].trim();
    }

}
