package ferb.command;
import ferb.task.Task;
import ferb.tasklist.TaskList;

/**
 * Represents a command to unmark a task as done in the task list.
 */
public class UnmarkDoneCommand extends Command {
    private int index;

    public UnmarkDoneCommand(TaskList tasks, int index) {
        super(tasks);
        this.index = index;
    }

    /**
     * Executes the unmark done command, unmarking the task as done in the task list and printing a confirmation message.
     */
    @Override
    public void execute() {
        Task task = tasks.get(this.index);
        task.unmarkDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(" " + task.displayDone() + task.taskDescription());
    }
}
