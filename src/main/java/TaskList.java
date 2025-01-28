public class TaskList {

    private final String[] taskList = new String[100];
    private int taskCount = 0;

    String horizontalLineSeparator = "________________________________________________________________";

    public void addTask(String taskName) {
        taskList[taskCount] = taskName;
        taskCount++;
    }

    public void listTask() {
        System.out.println(horizontalLineSeparator);
        for (int i = 0; i < taskCount; i++) {
            System.out.println(i + 1 + ". " + taskList[i]);
        }
        System.out.println(horizontalLineSeparator);
    }

}
