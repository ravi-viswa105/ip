package hal9000;

import hal9000.parser.UserInputParser;
import hal9000.task.TaskList;
import hal9000.command.Command;

import java.io.File;
import java.io.IOException;

public class Hal9000 {

    private Storage storage;
    private TaskList taskList;
    private Ui ui;
    private File saveFile;

    public Hal9000(String filepath) {
        ui = new Ui();
        taskList = new TaskList();
        saveFile = new File(filepath);
        storage = new Storage(saveFile, taskList);
        try {
            storage.loadTaskList(saveFile);
        } catch (IOException e) {
            ui.showError(e.getMessage());
        }
    }

    public void run() {
        Ui.showWelcomeMessage();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userInput = ui.readCommand();
                UserInputParser toBeParsed = new UserInputParser(userInput);
                Command c = toBeParsed.parse();
                c.execute(taskList, ui, storage);
                isExit = c.isExit();
            } catch (Hal9000Exception e) {
                e.printException();
            }
            try {
                storage.saveTaskList(saveFile);
            } catch (IOException e) {
                ui.showError(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Hal9000("data/tasks.txt").run();
    }
}
