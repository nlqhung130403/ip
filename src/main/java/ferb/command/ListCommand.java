package ferb.command;

import ferb.task.Task;
import ferb.tasklist.TaskList;

public class ListCommand extends Command {

    public ListCommand(TaskList tasks) {
        super(tasks);
    }

    @Override
    public void execute() {
        System.out.println("Here are the tasks in your list:");
        System.out.println(tasks.toString());
    }
}
