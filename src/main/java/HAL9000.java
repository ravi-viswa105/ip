import java.util.Scanner;

public class HAL9000 {
    public static void main(String[] args) {

        String userInput;
        String horizontalLineSeparator = "________________________________________________________________";

        String greet = "Hello I am HAL9000 \nWhat can I do for you?";

        String exit = "User, this conversation can serve no purpose anymore. Goodbye.";


        System.out.println(horizontalLineSeparator + "\n" + greet + "\n" + horizontalLineSeparator);

        while(true) {
            Scanner userIn = new Scanner(System.in);
            userInput = userIn.nextLine();
            if(userInput.equals("bye")) {
                break;
            }
            System.out.println(horizontalLineSeparator + "\n" + userInput + "\n" + horizontalLineSeparator);
        }
        System.out.println(horizontalLineSeparator + "\n" + exit + "\n" + horizontalLineSeparator);
    }
}
