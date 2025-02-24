package hal9000;

import hal9000.parser.SaveFileParser;
import hal9000.task.TaskList;
import hal9000.task.TaskType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Storage {

    File saveFile;
    TaskList taskList;

    public Storage(File saveFileDirectory, TaskList taskList) {
        this.saveFile = saveFileDirectory;
        this.taskList = taskList;
    }

    public void saveTaskList(File saveFile) throws IOException {
        FileWriter fw = new FileWriter(saveFile);
        for (int i = 0; i < taskList.getTaskCount(); i++) {
            fw.write(taskList.getTask(i).toString() + System.lineSeparator());
        }
        fw.close();
    }

    public void loadTaskList(File saveFile) throws IOException {

        if (!Files.exists(saveFile.toPath())) {
            Files.createDirectories(Path.of(saveFile.getParent()));
            Files.createFile(saveFile.toPath());
        }

        Scanner s = new Scanner(saveFile);
        int saveTaskCount = 0;
        while (s.hasNext()) {
            String currentTask = s.nextLine();
            SaveFileParser parsedInput = new SaveFileParser(currentTask);
            TaskType currentTaskType = parsedInput.findTaskType();
            boolean isTaskComplete = parsedInput.isTaskComplete();

            if (currentTaskType == TaskType.TODO) {
                taskList.addTask(parsedInput.findTodoTaskName(), currentTaskType);
            } else if (currentTaskType == TaskType.DEADLINE) {
                taskList.addTask(parsedInput.findDeadlineTaskName(), currentTaskType, parsedInput.findDeadlineBy());
            } else if (currentTaskType == TaskType.EVENT) {
                taskList.addTask(parsedInput.findEventTaskName(), currentTaskType,
                        parsedInput.findEventFrom(), parsedInput.findEventTo());
            }
            saveTaskCount++;
            if (isTaskComplete && currentTaskType != TaskType.NONE) {
                taskList.getTask(saveTaskCount - 1).markAsDone();
            }
        }
    }

}
