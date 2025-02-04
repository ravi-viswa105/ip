public class UserInputParser {

    private String userInput;
    String[] inputSplit;

    public UserInputParser(String userInput) {
        this.userInput = userInput;
        inputSplit = userInput.split(" ");
    }

    public TaskType findTaskType() {
        if (inputSplit[0].equals("todo")) {
            return TaskType.TODO;
        } else if (inputSplit[0].equals("deadline")) {
            return TaskType.DEADLINE;
        } else if (inputSplit[0].equals("event")) {
            return TaskType.EVENT;
        } else if (inputSplit[0].equals("mark")) {
            return TaskType.MARK;
        } else if (inputSplit[0].equals("unmark")) {
            return TaskType.UNMARK;
        } else if (inputSplit[0].equals("bye")) {
            return TaskType.BYE;
        } else if (inputSplit[0].equals("list")) {
            return TaskType.LIST;
        }
        return TaskType.NONE;
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




