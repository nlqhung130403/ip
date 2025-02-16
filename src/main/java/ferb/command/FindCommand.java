package ferb.command;

import ferb.tasklist.TaskList;

public class FindCommand extends Command {
    private String keyword;

    public FindCommand(TaskList tasks, String keyword) {
        super(tasks);
        this.keyword = keyword;
    }

    @Override
    public void execute() {
        TaskList foundTasks = tasks.find(keyword);
        System.out.println("Here are the matching tasks in your list:");
        System.out.println(foundTasks.toString());
    }
}
