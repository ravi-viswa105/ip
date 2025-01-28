public class TaskList {

    private final Task[] taskList = new Task[100];
    private int taskCount = 0;

    String horizontalLineSeparator = "________________________________________________________________";

    public void addTask(String taskName) {
        taskList[taskCount] = new Task(taskName);
        taskCount++;
    }

    public void listTask() {
        System.out.println(horizontalLineSeparator + "\nThis is what you need to do");
        for (int i = 0; i < taskCount; i++) {
            System.out.println(i + 1 + ". [" + taskList[i].getStatusIcon() + "] " + taskList[i].getTaskName());
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


}
