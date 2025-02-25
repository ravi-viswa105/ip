package hal9000.task;

public class Todo extends Task {

    /**
     * Constructs a todo task
     * @param taskName Name of todo task
     */
    public Todo(String taskName) {
        super(taskName);
        setTaskTypeChar('T');
    }

    /**
     * Converts todo task to string
     * @return todo task in string
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
