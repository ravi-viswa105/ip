package hal9000.task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    protected LocalDateTime parseDateTime(String dateTime) {
        for (DateTimeFormatter formatter: FORMATS ) {
            try {
                return LocalDateTime.parse(dateTime, formatter);
            } catch (Exception e) {
                //Ignore exception
            }
        }
        return null;
    }

    protected LocalDate parseDate(String date) {
        for (DateTimeFormatter formatter: FORMATS ) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (Exception e) {
                //Ignore exception
            }
        }
        return null;
    }

    private static final DateTimeFormatter[] FORMATS = {
            DateTimeFormatter.ofPattern("d/M/yyyy"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("d/M/yyyy Hmm"),
            DateTimeFormatter.ofPattern("d/M/yyyy HH:mm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm"),
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"),
    };


}


