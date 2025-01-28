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

            if (markedTask[0].equals("mark")) {
                int markIndex = Integer.parseInt(markedTask[1]);
                taskList.markAsDone(markIndex);
                System.out.println(horizontalLineSeparator + "\n" +
                        "Of course, I have successfully marked the task as completed." + "\n" +
                        "[X] " + taskList.getTaskName(markIndex) + "\n" + horizontalLineSeparator);

            } else if (markedTask[0].equals("unmark")) {
                int markIndex = Integer.parseInt(markedTask[1]);
                taskList.markAsNotDone(markIndex);
                System.out.println(horizontalLineSeparator + "\n" +
                        "Of course, I have successfully marked the task as incomplete." + "\n" +
                        "[ ] " + taskList.getTaskName(markIndex) + "\n" + horizontalLineSeparator);

            } else if(userInput.equals("bye")) {
                break;

            } else if (userInput.equals("list")) {
                taskList.listTasks();

            } else {
                System.out.println(horizontalLineSeparator + "\n" + "added: "
                        + userInput + "\n" + horizontalLineSeparator);
                taskList.addTask(userInput);
            }
        }
        System.out.println(horizontalLineSeparator + "\n" + exit + "\n" + horizontalLineSeparator);
    }
}
