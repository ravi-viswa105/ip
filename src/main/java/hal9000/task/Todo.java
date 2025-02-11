package hal9000.task;

public class Todo extends Task {

    public Todo(String taskName) {
        super(taskName);
        setTaskTypeChar('T');
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
