package hal9000.task;

import hal9000.Hal9000Exception;
import java.util.ArrayList;

public class TaskList {

    static final int MAX_NUMBER_OF_TASKS = 100;

    //private final Task[] taskList = new Task[MAX_NUMBER_OF_TASKS];
    ArrayList<Task> taskList = new ArrayList<>();
    private int taskCount = 0;

    final String lineSeparator = "________________________________________________________________";

    public void addTask(String taskName, TaskType taskType) {
        taskList.add(new Todo(taskName));
        taskCount++;
    }

    public void addTask(String taskName, TaskType taskType, String deadlineBy) {
        taskList.add(new Deadline(taskName, deadlineBy));
        taskCount++;
    }

    public void addTask(String taskName, TaskType taskType, String eventFrom, String eventTo) {
        taskList.add(new Event(taskName, eventFrom, eventTo));
        taskCount++;
    }

    public void listTasks() {
        System.out.println(lineSeparator + "\nThis is what you need to do");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + taskList.get(i).toString());
        }
        System.out.println(lineSeparator);
    }

    public void markAsDone(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot mark this task as it is out of bounds");
        }
        taskList.get(index-1).markAsDone();
    }

    public void markAsNotDone(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot unmark this task as it is out of bounds");
        }
        taskList.get(index-1).markAsNotDone();
    }

    public String getTaskName(int index) {
        return taskList.get(index-1).getTaskName();
    }

    public int getTaskCount() {
        return taskCount;
    }


}
