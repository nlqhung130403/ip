package ferb;

import ferb.command.*;
import ferb.exception.FerbException;
import ferb.parser.Parser;
import ferb.tasklist.TaskList;
import ferb.ui.Ui;
import ferb.filehandler.FerbFileHandler;


/**
 * Represents the main class of the Ferb application.
 */
public class Ferb {
    private TaskList tasks;
    private FerbFileHandler fileHandler;
    private Parser parser;
    private Ui ui = new Ui();

    /**
     * Constructs a Ferb object with the specified file path.
     *
     * @param filePath the file path where the task list is stored
     */
    public Ferb(String filePath) {
        fileHandler = new FerbFileHandler(filePath);
        String content = fileHandler.readContent();
        if (!content.isEmpty()) {
            tasks = new TaskList(content);
        } else {
            tasks = new TaskList();
        }
        parser = new Parser(tasks, fileHandler);
    }

    public String getResponse(String input) {
        try {
            Command c = this.parser.parse(input);
            c.execute(ui, fileHandler, tasks);
        } catch (StringIndexOutOfBoundsException e) {
            return "Wrong command format! Please double check.";
        } catch (IndexOutOfBoundsException e) {
            return "Invalid Index! Please try again.";
        } catch (RuntimeException e) {
            return "Wrong command format! Please try again.";
        } catch (FerbException e) {
            return "Sorry! Command not supported!";
        }
        return ui.getMessage();
    }

    public void saveTasks() {
        fileHandler.writeContent(tasks);
    }

    //public static void main(String[] args) {
        //new Ferb("data/Ferb.txt").run();
    //}
}
