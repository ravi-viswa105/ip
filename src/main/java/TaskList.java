import java.sql.SQLOutput;

public class TaskList {

    private final Task[] taskList = new Task[100];
    private int taskCount = 0;

    String horizontalLineSeparator = "________________________________________________________________";

    public void addTask(String taskName, TaskType taskType) {
        if (taskType == TaskType.TODO) {
            taskList[taskCount] = new Todo(taskName);
        }
        taskCount++;
    }

    public void addTask(String taskName, TaskType taskType, String deadlineBy) {
        if (taskType == TaskType.TODO) {
            taskList[taskCount] = new Todo(taskName);
        }
        else if (taskType == TaskType.DEADLINE) {
            taskList[taskCount] = new Deadline(taskName, deadlineBy);
        }
        taskCount++;
    }

    public void addTask(String taskName, TaskType taskType, String eventFrom, String eventTo) {
        if (taskType == TaskType.EVENT) {
            taskList[taskCount] = new Event(taskName, eventFrom, eventTo);
        }
        taskCount++;
    }

    public void listTasks() {
        System.out.println(horizontalLineSeparator + "\nThis is what you need to do");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + taskList[i].toString());
        }
        System.out.println(horizontalLineSeparator);
    }

    public void markAsDone(int index) {
        taskList[index-1].markAsDone();
    }

    public void markAsNotDone(int index) {
        taskList[index-1].markAsNotDone();
    }

    public String getTaskName(int index) {
        return taskList[index-1].getTaskName();
    }

    public int getTaskCount() {
        return taskCount;
    }


}
