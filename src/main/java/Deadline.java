public class Deadline extends Task {

    protected String by;

    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
        setTaskTypeChar('D');
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + by + ")";
    }
}
