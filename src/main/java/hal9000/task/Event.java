package hal9000.task;

public class Event extends Task {

    protected String from;
    protected String to;

    /**
     * Constructs an event task
     * @param taskName Name of event task
     * @param from From date of event task
     * @param to To date of event task
     */
    public Event(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
        setTaskTypeChar('E');
    }

    /**
     * Converts event task to string
     * @return event task in string
     */
    @Override
    public String toString() {
        return super.toString() + " (from: " + from + " to: " + to + ")";
    }
}
