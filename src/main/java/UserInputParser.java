public class UserInputParser {

    private String userInput;
    String[] inputSplit;

    public UserInputParser(String userInput) {
        this.userInput = userInput;
        inputSplit = userInput.split(" ");
    }

    public TaskType findTaskType() {
        return switch (inputSplit[0]) {
            case "todo" -> TaskType.TODO;
            case "deadline" -> TaskType.DEADLINE;
            case "event" -> TaskType.EVENT;
            case "mark" -> TaskType.MARK;
            case "unmark" -> TaskType.UNMARK;
            case "bye" -> TaskType.BYE;
            case "list" -> TaskType.LIST;
            default -> TaskType.NONE;
        };
    }

    public String findTodoTaskName() {
        return userInput.substring(4).trim();
    }

    public String findDeadlineTaskName() {
        String filteredTaskName = userInput.split("/by")[0];
        return filteredTaskName.substring(8).trim();
    }

    public String findEventTaskName() {
        String filteredTaskName = userInput.split("/from")[0];
        return filteredTaskName.substring(5).trim();
    }

    public String findDeadlineBy() {
        return userInput.split("/by")[1].trim();
    }

    public String findEventFrom() {
        String filteredTaskName = userInput.split("/to")[0].trim();
        return filteredTaskName.split("/from")[1].trim();
    }

    public String findEventTo() {
        return userInput.split("/to")[1].trim();
    }

    public int findMarkIndex() {
        return Integer.parseInt(userInput.substring(4).trim());
    }

    public int findUnmarkIndex() {
        return Integer.parseInt(userInput.substring(6).trim());
    }


}




