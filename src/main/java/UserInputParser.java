public class UserInputParser {

    private String userInput;
    String[] inputSplit;

    public UserInputParser(String userInput) {
        this.userInput = userInput;
        inputSplit = userInput.split(" ");
    }

    public TaskType findTaskType() throws Hal9000Exception {
        return switch (inputSplit[0]) {
            case "todo" -> TaskType.TODO;
            case "deadline" -> TaskType.DEADLINE;
            case "event" -> TaskType.EVENT;
            case "mark" -> TaskType.MARK;
            case "unmark" -> TaskType.UNMARK;
            case "bye" -> TaskType.BYE;
            case "list" -> TaskType.LIST;
            default -> throw new Hal9000Exception("I'm sorry User. I'm afraid I can't do that");
        };
    }

    public String findTodoTaskName() throws Hal9000Exception {
        String filteredTaskName = userInput.substring(4).trim();
        if (filteredTaskName.isEmpty()) {
            throw new Hal9000Exception("User, the task name cannot be empty");
        }
        return userInput.substring(4).trim();
    }

    public String findDeadlineTaskName() throws Hal9000Exception {
        String filteredTaskName = userInput.split("/by")[0].substring(8).trim();
        if (filteredTaskName.isEmpty()) {
            throw new Hal9000Exception("User, the task name cannot be empty");
        }
        return filteredTaskName;
    }

    public String findEventTaskName() throws Hal9000Exception {
        String filteredTaskName = userInput.split("/from")[0].substring(5).trim();
        if (filteredTaskName.isEmpty()) {
            throw new Hal9000Exception("User, the task name cannot be empty");
        }
        return filteredTaskName;
    }

    public String findDeadlineBy() throws Hal9000Exception {
        String[] splitUserInput = userInput.split("/by");
        if (splitUserInput.length < 2) {
            throw new Hal9000Exception("Sorry User, you forgot to include a /by time");
        }
        return splitUserInput[1].trim();
    }

    public String findEventFrom() throws Hal9000Exception {
        String filteredTaskName = userInput.split("/to")[0].trim();
        String[] splitUserInput = filteredTaskName.split("/from");
        if (splitUserInput.length < 2) {
            throw new Hal9000Exception("Sorry User, you forgot to include a /from time");
        }
        return splitUserInput[1].trim();
    }

    public String findEventTo() throws Hal9000Exception {
        String[] splitUserInput = userInput.split("/to");
        if (splitUserInput.length < 2) {
            throw new Hal9000Exception("Sorry User, you forgot to include a /to time");
        }
        return splitUserInput[1].trim();
    }

    public int findMarkIndex() {
        return Integer.parseInt(userInput.substring(4).trim());
    }

    public int findUnmarkIndex() {
        return Integer.parseInt(userInput.substring(6).trim());
    }


}




