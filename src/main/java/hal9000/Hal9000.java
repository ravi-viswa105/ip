package hal9000;

import hal9000.task.TaskList;
import hal9000.task.TaskType;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hal9000 {
    public static void main(String[] args) {

        File saveFile = new File("src/main/java/hal9000/data/tasks.txt");

        final String lineSeparator = "________________________________________________________________";
        final String greet = "Hello I am HAL9000\nWhat can I do for you?";
        final String exit = "User, this conversation can serve no purpose anymore. Goodbye.";

        TaskList taskList = new TaskList();
        try {
            taskList.loadTaskList(saveFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }

        System.out.println(lineSeparator + "\n" + greet + "\n" + lineSeparator);

        Scanner userIn = new Scanner(System.in);

        while(true) {

            try {

            String userInput = userIn.nextLine();
            String[] markedTask = userInput.split(" ");

            UserInputParser parsedText = new UserInputParser(userInput);
            TaskType taskType = parsedText.findTaskType();

            if (taskType == TaskType.TODO) {

                taskList.addTask(parsedText.findTodoTaskName(), TaskType.TODO);

                System.out.println(lineSeparator + "\n" +
                        "I have successfully added this task:" + "\n" + "[T][ ] " + parsedText.findTodoTaskName());
                System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

            } else if (taskType == TaskType.DEADLINE) {

                taskList.addTask(parsedText.findDeadlineTaskName(), TaskType.DEADLINE, parsedText.findDeadlineBy());

                System.out.println(lineSeparator + "\n" +
                        "I have successfully added this task:" + "\n" + "[D][ ] " + parsedText.findDeadlineTaskName()
                        + " (by: " + parsedText.findDeadlineBy() + ")");
                System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

            } else if (taskType == TaskType.EVENT) {

                taskList.addTask(parsedText.findEventTaskName(), TaskType.EVENT, parsedText.findEventFrom(),
                        parsedText.findEventTo());

                System.out.println(lineSeparator + "\n" +
                        "I have successfully added this task:" + "\n" + "[E][ ] " + parsedText.findEventTaskName()
                        + " (from: " + parsedText.findEventFrom() + " to: " + parsedText.findEventTo() + ")");
                System.out.println("You have " + taskList.getTaskCount() + " tasks." + "\n" + lineSeparator);

            } else if (taskType == TaskType.MARK) {

                taskList.markAsDone(parsedText.findMarkIndex());

                System.out.println(lineSeparator + "\n" +
                        "Of course, I have successfully marked the task as completed." + "\n" +
                        "[X] " + taskList.getTaskName(parsedText.findMarkIndex()) + "\n" + lineSeparator);

            } else if (taskType == TaskType.UNMARK) {

                taskList.markAsNotDone(parsedText.findUnmarkIndex());

                System.out.println(lineSeparator + "\n" +
                        "Of course, I have successfully marked the task as incomplete." + "\n" +
                        "[ ] " + taskList.getTaskName(parsedText.findUnmarkIndex()) + "\n" + lineSeparator);

            } else if (userInput.equals("bye")) {
                taskList.saveTaskList(saveFile);
                break;
            } else if (userInput.equals("list")) {
                taskList.listTasks();
            }
        } catch (Hal9000Exception e) {
                e.printException();
            }
            catch (IOException e) {
                System.out.println("Something went wrong");
            }
        }
        System.out.println(lineSeparator + "\n" + exit + "\n" + lineSeparator);
    }
}
