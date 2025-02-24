package hal9000.task;

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


}


