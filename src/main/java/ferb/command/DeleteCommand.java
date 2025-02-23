package ferb.command;

import ferb.task.Task;
import ferb.tasklist.TaskList;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command{
    private int index;

    public DeleteCommand(TaskList tasks, int index) {
        super(tasks);
        this.index = index;
    }

    /**
     * Executes the delete command, removing the task from the task list and printing a confirmation message.
     */
    @Override
    public void execute() {
        Task task = tasks.get(index - 1);
        tasks.remove(index - 1);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in list");
    }
}
