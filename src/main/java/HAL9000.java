import java.util.Scanner;

public class HAL9000 {
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
            if(userInput.equals("bye")) {
                break;
            } else if (userInput.equals("list")) {
                taskList.listTask();
            }
            else {
                System.out.println(horizontalLineSeparator + "\n" + "added: " + userInput + "\n" + horizontalLineSeparator);
                taskList.addTask(userInput);
            }
        }
        System.out.println(horizontalLineSeparator + "\n" + exit + "\n" + horizontalLineSeparator);
    }
}
