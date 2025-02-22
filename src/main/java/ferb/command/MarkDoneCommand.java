package ferb.command;

import ferb.task.Task;
import ferb.tasklist.TaskList;

/**
 * Represents a command to mark a task as done based on its index.
 */
public class MarkDoneCommand extends Command {
    private int index;

    public MarkDoneCommand(TaskList tasks, int index) {
        super(tasks);
        this.index = index;
    }

    /**
     * Executes the mark done command, marking the task as done and printing a confirmation message.
     */
    @Override
    public void execute() {
        Task task = tasks.get(index);
        task.markDone();
        System.out.println("Nice! I have marked this task as done:");
        System.out.println(task.displayDone() + task.taskDescription());
    }
}
