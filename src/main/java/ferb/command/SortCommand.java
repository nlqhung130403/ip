package ferb.command;

import ferb.filehandler.FerbFileHandler;
import ferb.tasklist.TaskList;
import ferb.ui.Ui;

public class SortCommand extends Command{
    String type;

    public SortCommand(String type) {
        this.type = type;
    }

    /**
     * Executes the sort command, sorting the task list and printing a confirmation message.
     */
    @Override
    public void execute(Ui ui, FerbFileHandler fileHandler, TaskList tasks) {
        if (type.equals("description")) {
            tasks.sortDescription();
            ui.showSortedByDescription(tasks);
        } else if (type.equals("date")) {
            tasks.sortDate();
            ui.showSortedByDate(tasks);
        }
    }
}
