package hal9000;

import java.util.Scanner;

/**
 * Handles interaction with user
 * Reads input from user
 * Prints output to user
 */
public class Ui {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * Outputs welcome message to user when user starts application
     */
    public static void showWelcomeMessage() {
        final String lineSeparator = "________________________________________________________________";
        final String greet = "Hello I am HAL9000\nWhat can I do for you?";
        System.out.println(lineSeparator + "\n" + greet + "\n" + lineSeparator);
    }

    /**
     * Outputs exit message to user when user quits application
     */
    public static void showExitMessage() {
        final String lineSeparator = "________________________________________________________________";
        final String exit = "User, this conversation can serve no purpose anymore. Goodbye.";
        System.out.println(lineSeparator + "\n" + exit + "\n" + lineSeparator);
    }

    /**
     * Reads user's input
     * @return user input
     */
    public String readCommand() {
        return scanner.nextLine();
    }

    /**
     * Outputs error message to user
     * @param message Content of error message
     */
    public void showError(String message) {
        System.out.println(message);;
    }


}
