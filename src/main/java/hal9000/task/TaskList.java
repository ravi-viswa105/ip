package hal9000.task;

import hal9000.Hal9000Exception;
import java.util.ArrayList;
import hal9000.SaveFileParser;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


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

    public void saveTaskList(File saveFile) throws IOException {
        FileWriter fw = new FileWriter(saveFile);
        for (int i = 0; i < taskCount; i++) {
            fw.write(taskList.get(i).toString() + System.lineSeparator());
        }
        fw.close();
    }

    public void loadTaskList(File saveFile) throws IOException {
        Scanner s = new Scanner(saveFile);
        int saveTaskCount = 0;
        while (s.hasNext()) {
            String currentTask = s.nextLine();
            SaveFileParser parsedInput = new SaveFileParser(currentTask);
            TaskType currentTaskType = parsedInput.findTaskType();
            boolean isTaskComplete = parsedInput.isTaskComplete();

            if (currentTaskType == TaskType.TODO) {
                addTask(parsedInput.findTodoTaskName(), currentTaskType);
            } else if (currentTaskType == TaskType.DEADLINE) {
                addTask(parsedInput.findDeadlineTaskName(), currentTaskType, parsedInput.findDeadlineBy());
            } else if (currentTaskType == TaskType.EVENT) {
                addTask(parsedInput.findEventTaskName(), currentTaskType,
                        parsedInput.findEventFrom(), parsedInput.findEventTo());
            }
            saveTaskCount++;
            if (isTaskComplete && currentTaskType != TaskType.NONE) {
                taskList.get(saveTaskCount - 1).markAsDone();
            }
        }
    }



}
