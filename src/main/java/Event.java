public class Event extends Task {

    protected String from;
    protected String to;

    public Event(String taskName, String from, String to) {
        super(taskName);
        this.from = from;
        this.to = to;
        setTaskTypeChar('E');
    }

    @Override
    public String toString() {
        return super.toString() + "(from: " + from + " to: " + to + ")";
    }
}
