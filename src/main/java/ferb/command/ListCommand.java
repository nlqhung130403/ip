package ferb.command;

import ferb.task.Task;
import ferb.tasklist.TaskList;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command {

    public ListCommand(TaskList tasks) {
        super(tasks);
    }

    /**
     * Executes the list command, printing all tasks in the task list.
     */
    @Override
    public void execute() {
        System.out.println("Here are the tasks in your list:");
        System.out.println(tasks.toString());
    }
}
