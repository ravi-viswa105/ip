import java.util.Scanner;

public class Hal9000 {
    public static void main(String[] args) {

        String userInput;
        String horizontalLineSeparator = "________________________________________________________________";

        String greet = "Hello I am HAL9000 \nWhat can I do for you?";
        String exit = "User, this conversation can serve no purpose anymore. Goodbye.";

        TaskList taskList = new TaskList();

        System.out.println(horizontalLineSeparator + "\n" + greet + "\n" + horizontalLineSeparator);

        while(true) {
            Scanner userIn = new Scanner(System.in);
            userInput = userIn.nextLine();
            String[] markedTask = userInput.split(" ");

            UserInputParser parsedText = new UserInputParser(userInput);
            TaskType taskType = parsedText.findTaskType();

            if (taskType == TaskType.TODO) {

                taskList.addTask(parsedText.findTodoTaskName(), TaskType.TODO);

                System.out.println(horizontalLineSeparator + "\n" +
                        "I have successfully added this task:" + "\n" + "[T][ ] " + parsedText.findTodoTaskName());
                System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + horizontalLineSeparator);

            } else if (taskType == TaskType.DEADLINE) {

                taskList.addTask(parsedText.findDeadlineTaskName(), TaskType.DEADLINE, parsedText.findDeadlineBy());

                System.out.println(horizontalLineSeparator + "\n" +
                        "I have successfully added this task:" + "\n" + "[D][ ] " + parsedText.findDeadlineTaskName()
                        + " (by: " + parsedText.findDeadlineBy() + ")");
                System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + horizontalLineSeparator);

            } else if (taskType == TaskType.EVENT) {

                taskList.addTask(parsedText.findEventTaskName(), TaskType.EVENT, parsedText.findEventFrom(),
                        parsedText.findEventTo());

                System.out.println(horizontalLineSeparator + "\n" +
                        "I have successfully added this task:" + "\n" + "[E][ ] " + parsedText.findEventTaskName()
                        + " (from: " + parsedText.findEventFrom() + " to: "  + parsedText.findEventTo() + ")");
                System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + horizontalLineSeparator);

            } else if (taskType == TaskType.MARK) {

                taskList.markAsDone(parsedText.findMarkIndex());

                System.out.println(horizontalLineSeparator + "\n" +
                        "Of course, I have successfully marked the task as completed." + "\n" +
                        "[X] " + taskList.getTaskName(parsedText.findMarkIndex()) + "\n" + horizontalLineSeparator);

            } else if (taskType == TaskType.UNMARK) {

                taskList.markAsNotDone(parsedText.findUnmarkIndex());

                System.out.println(horizontalLineSeparator + "\n" +
                        "Of course, I have successfully marked the task as incomplete." + "\n" +
                        "[ ] " + taskList.getTaskName(parsedText.findUnmarkIndex()) + "\n" + horizontalLineSeparator);

            } else if (userInput.equals("bye")) {
                break;
            } else if (userInput.equals("list")) {
                taskList.listTasks();
            }
        }
        System.out.println(horizontalLineSeparator + "\n" + exit + "\n" + horizontalLineSeparator);
    }
}
