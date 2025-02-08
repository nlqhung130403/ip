package ferb.command;

import ferb.filehandler.FerbFileHandler;
import ferb.tasklist.TaskList;
import ferb.ui.Ui;

public class ExitCommand extends Command{
    private FerbFileHandler fileHandler;

    public ExitCommand(TaskList tasks, FerbFileHandler fileHandler) {
        super(tasks);
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute() {
        Ui.exit();
        fileHandler.writeContent(tasks);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
