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
        tasks.sort();
        //ui.showTaskSorted();
    }

    private void sortDescription(TaskList tasks) {
        tasks.sortDescription();
    }

    private void sortDate(TaskList tasks) {
        //tasks.sortDate();
    }
}
