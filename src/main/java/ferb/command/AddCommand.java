package ferb.command;

import ferb.task.Task;
import ferb.tasklist.TaskList;

/**
 * Represents a command to add a task to the task list.
 */
public class AddCommand extends Command{
    private Task task;

    /**
     * Constructs an AddCommand with the specified task list and task.
     *
     * @param tasks the task list to which the task will be added
     * @param task the task to be added
     */
    public AddCommand(TaskList tasks, Task task) {
        super(tasks);
        this.task = task;
    }

    /**
     * Executes the add command, adding the task to the task list and printing a confirmation message.
     */
    @Override
    public void execute() {
        this.tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
    }
}
