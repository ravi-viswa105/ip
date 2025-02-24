package hal9000;

import java.util.Scanner;

public class Ui {

    private static Scanner scanner = new Scanner(System.in);

    final String exit = "User, this conversation can serve no purpose anymore. Goodbye.";

    public static void showWelcomeMessage() {
        final String lineSeparator = "________________________________________________________________";
        final String greet = "Hello I am HAL9000\nWhat can I do for you?";
        System.out.println(lineSeparator + "\n" + greet + "\n" + lineSeparator);
    }

    public static void showExitMessage() {
        final String lineSeparator = "________________________________________________________________";
        final String exit = "User, this conversation can serve no purpose anymore. Goodbye.";
        System.out.println(lineSeparator + "\n" + exit + "\n" + lineSeparator);
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showError(String message) {
        System.out.println(message);;
    }


}
