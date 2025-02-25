package hal9000.task;

import hal9000.Hal9000Exception;

import java.util.ArrayList;

/**
 * An object using ArrayList Collection to store list of tasks
 */
public class TaskList {

    ArrayList<Task> taskList = new ArrayList<>();
    private int taskCount = 0;

    final String lineSeparator = "________________________________________________________________";

    /**
     * Adds todo task to task list
     * @param taskName Name of task
     * @param taskType Type of task
     */
    public void addTask(String taskName, TaskType taskType) {
        taskList.add(new Todo(taskName));
        taskCount++;
    }

    /**
     * Adds deadline task to task list
     * @param taskName Name of task
     * @param taskType Type of task
     * @param deadlineBy By date of task
     */
    public void addTask(String taskName, TaskType taskType, String deadlineBy) {
        taskList.add(new Deadline(taskName, deadlineBy));
        taskCount++;
    }

    /**
     * Adds event task to task list
     * @param taskName Name of task
     * @param taskType Type of task
     * @param eventFrom From date of task
     * @param eventTo To date of task
     */
    public void addTask(String taskName, TaskType taskType, String eventFrom, String eventTo) {
        taskList.add(new Event(taskName, eventFrom, eventTo));
        taskCount++;
    }

    /**
     * Delete task with index
     * @param index Task index within task list
     * @throws Hal9000Exception if index is out of bounds
     */
    public void deleteTask(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot delete this task as it is out of bounds");
        }
        taskList.remove(index - 1);
        taskCount--;
    }

    /**
     * Prints all the tasks in the list
     */
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

    /**
     * Mark task as done with index
     * @param index Index of task to be marked
     * @throws Hal9000Exception if index is out of bounds
     */
    public void markAsDone(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot mark this task as it is out of bounds");
        }

        taskList.get(index - 1).markAsDone();
    }

    /**
     * Mark task as not done with index
     * @param index Index of task to be unmarked
     * @throws Hal9000Exception if index is out of bounds
     */
    public void markAsNotDone(int index) throws Hal9000Exception {
        if (index < 1 || index > taskCount) {
            throw new Hal9000Exception("You cannot unmark this task as it is out of bounds");
        }
        taskList.get(index - 1).markAsNotDone();
    }

    /**
     * Get name of task
     * @param index Index of task in task list
     * @return name of task
     */
    public String getTaskName(int index) {
        return taskList.get(index - 1).getTaskName();
    }

    /**
     * Get the number of tasks in task list
     * @return number of tasks in task list
     */
    public int getTaskCount() {
        return taskCount;
    }

    /**
     * Get type of task at index
     * @param index Index of task in task list
     * @return type of task
     */
    public char getTaskType(int index) {
        return taskList.get(index - 1).getTaskTypeChar();
    }

    /**
     * Get task completion status
     * @param index Index of task in task list
     * @return task completion status
     */
    public boolean getIsTaskDone(int index) {
        return taskList.get(index - 1).isTaskDone();
    }
    
    /**
     * Convert task at index to string
     * @param index Index of task in task list
     * @return task as string
     */
    public String taskToString(int index) {
        return taskList.get(index - 1).toString();
    }

    /**
     * Get Task object at index in task list
     * @param index Index of task in task list
     * @return Task object at index
     */
    public Task getTask(int index) {
        return taskList.get(index);
    }
}
