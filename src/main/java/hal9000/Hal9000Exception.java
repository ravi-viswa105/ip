package hal9000;

/**
 * Exception class to handle errors with Hal9000 chatbot
 */
public class Hal9000Exception extends Exception {
    public Hal9000Exception(String message) {
        super(message);
    }

    /***
     * Prints Hal9000 Exception to user with line separator
     */
    public void printException() {
        String lineSeparator = "________________________________________________________________";
        System.out.println(lineSeparator + "\n" + getMessage() + "\n" + lineSeparator);
    }

}
