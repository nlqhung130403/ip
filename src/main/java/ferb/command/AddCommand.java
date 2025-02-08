package ferb.command;

import ferb.task.Task;
import ferb.tasklist.TaskList;

public class AddCommand extends Command{
    private Task task;

    public AddCommand(TaskList tasks, Task task) {
        super(tasks);
        this.task = task;
    }

    @Override
    public void execute() {
        this.tasks.add(task);
        System.out.println("Got it. I've added this task:");
        System.out.println("  " + task.toString());
    }
}
