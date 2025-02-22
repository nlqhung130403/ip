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

    /**
     * Runs the Ferb application.
     */
    private void run(){
        Ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            String command = Ui.readCommand();
            try {
                Command c = this.parser.parse(command);
                c.execute();
                isExit = c.isExit();
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Wrong command format! Please double check.");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid Index! Please try again.");
            } catch (RuntimeException e) {
                System.out.println("Wrong command format! Please try again.");
            } catch (FerbException e) {
                System.out.println("Sorry! Command not supported!");
            }
        }
    }

    public static void main(String[] args) {
        new Ferb("data/Ferb.txt").run();
    }
}
