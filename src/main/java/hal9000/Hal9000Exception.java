package hal9000;

public class Hal9000Exception extends Exception {
    public Hal9000Exception(String message) {
        super(message);
    }

    public void printException() {
        String lineSeparator = "________________________________________________________________";
        System.out.println(lineSeparator + "\n" + getMessage() + "\n" + lineSeparator);
    }

}
