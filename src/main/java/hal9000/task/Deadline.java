package hal9000.task;

public class Deadline extends Task {

    protected String by;

    /**
     * Constructs a deadline task
     * @param taskName Name of deadline task
     * @param by By date of deadline task
     */
    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
        setTaskTypeChar('D');
    }

    /**
     * Converts deadline task to string
     * @return Deadline task in string
     */
    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}
