package hal9000.task;

import hal9000.Hal9000Exception;

import java.util.ArrayList;


public class TaskList {

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

    public void deleteTask(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot delete this task as it is out of bounds");
        }
        taskList.remove(index - 1);
        taskCount--;
    }

    public void listTasks() {
        if (taskList.isEmpty()) {
            System.out.println(lineSeparator + "\nUser, you have no tasks\n" + lineSeparator);
            return;
        }
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

        taskList.get(index - 1).markAsDone();
    }

    public void markAsNotDone(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot unmark this task as it is out of bounds");
        }
        taskList.get(index - 1).markAsNotDone();
    }

    public String getTaskName(int index) {
        return taskList.get(index - 1).getTaskName();
    }

    public int getTaskCount() {
        return taskCount;
    }

    public char getTaskType(int index) {
        return taskList.get(index - 1).getTaskTypeChar();
    }

    public boolean getIsTaskDone(int index) {
        return taskList.get(index - 1).isTaskDone();
    }

    public String printTask(int index) {
        return taskList.get(index - 1).toString();
    }

    public Task getTask(int index) {
        return taskList.get(index);
    }
}
