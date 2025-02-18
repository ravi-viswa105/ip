package hal9000;

import hal9000.task.TaskType;

public class SaveFileParser {

    private String saveData;

    public SaveFileParser(String saveData) {
        this.saveData = saveData;
    }

    public TaskType findTaskType() {
        return switch (saveData.charAt(1)) {
            case 'T' -> TaskType.TODO;
            case 'D' -> TaskType.DEADLINE;
            case 'E' -> TaskType.EVENT;
            default -> TaskType.NONE;
        };
    }

    public boolean isTaskComplete() {
        if (saveData.charAt(4) == 'X') {
            return true;
        }
        return false;
    }

    public String findTodoTaskName() {
        return saveData.substring(7);
    }

    public String findDeadlineTaskName() {
        return saveData.split("\\(by:")[0].substring(7).trim();
    }

    public String findDeadlineBy() {
        String removedClosingBracket = saveData.substring(0, saveData.length() - 1);
        return removedClosingBracket.split("\\(by:")[1].trim();
    }

    public String findEventTaskName() {
        return saveData.split("\\(from:")[0].substring(7).trim();
    }

    public String findEventFrom() {
        String removedTo = saveData.split("to:")[0].trim();
        return removedTo.split("\\(from:")[1].trim();
    }

    public String findEventTo() {
        String removedClosingBracket = saveData.substring(0, saveData.length() - 1);
        return removedClosingBracket.split("to:")[1].trim();
    }

}
