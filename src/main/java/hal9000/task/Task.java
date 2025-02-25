package hal9000.task;

/**
 * Abstract class for different types of tasks
 * Tracks task name, task completion status and task type
 */
public abstract class Task {
    private String taskName;
    private boolean isDone;
    private char taskTypeChar;

    /**
     * Constructs a task object
     * @param taskName Name of the task
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    /**
     * Get the name of the task
     * @return name of task
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Get task completion status icon
     * @return icon for status of task completion
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    /**
     * Mark task as done
     */
    public void markAsDone() {
        isDone = true;
    }

    /**
     * Mark task as not done
     */
    public void markAsNotDone() {
        isDone = false;
    }

    /**
     * Get the type of the task
     * @return task type
     */
    public char getTaskTypeChar() {
        return taskTypeChar;
    }

    /**
     * Set the type of the task
     * @param taskTypeChar Type of the task (Todo, Event, Deadline)
     */
    public void setTaskTypeChar(char taskTypeChar) {
        this.taskTypeChar = taskTypeChar;
    }

    /**
     * Find task completion status
     * @return status of task completion
     */
    public boolean isTaskDone() {
        return isDone;
    }

    /**
     * Converts task to string
     * @return task in string
     */
    @Override
    public String toString() {
        return "[" + getTaskTypeChar() +  "][" + getStatusIcon() + "] " + getTaskName();
    }


}


