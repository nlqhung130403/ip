package ferb.command;

import ferb.filehandler.FerbFileHandler;
import ferb.tasklist.TaskList;
import ferb.ui.Ui;

/**
 * Represents a command to exit the program.
 */
public class ExitCommand extends Command{
    private FerbFileHandler fileHandler;

    public ExitCommand(TaskList tasks, FerbFileHandler fileHandler) {
        super(tasks);
        this.fileHandler = fileHandler;
    }

    /**
     * Executes the exit command, saving the task list to a file and exiting the application.
     */
    @Override
    public void execute() {
        Ui.exit();
        fileHandler.writeContent(tasks);
    }

    /**
     * Returns true as this command is an exit command.
     *
     * @return true as this command is an exit command
     */
    @Override
    public boolean isExit() {
        return true;
    }
}
