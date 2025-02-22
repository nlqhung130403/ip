package ferb.command;

import ferb.tasklist.TaskList;

/**
 * Represents a command that finds tasks based on a keyword in the task list.
 */
public class FindCommand extends Command {
    private String keyword;

    public FindCommand(TaskList tasks, String keyword) {
        super(tasks);
        this.keyword = keyword;
    }

    /**
     * Executes the find command, finding tasks based on the keyword and printing them.
     */
    @Override
    public void execute() {
        TaskList foundTasks = tasks.find(keyword);
        System.out.println("Here are the matching tasks in your list:");
        System.out.println(foundTasks.toString());
    }
}
