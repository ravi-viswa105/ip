package hal9000.task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    private String taskName;
    private boolean isDone;
    private char taskTypeChar;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void markAsDone() {
        isDone = true;
    }

    public void markAsNotDone() {
        isDone = false;
    }

    public char getTaskTypeChar() {
        return taskTypeChar;
    }

    public void setTaskTypeChar(char taskTypeChar) {
        this.taskTypeChar = taskTypeChar;
    }

    public boolean isTaskDone() {
        return isDone;
    }

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


