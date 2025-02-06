public class UnmarkDoneCommand extends Command {
    private int index;

    public UnmarkDoneCommand(TaskList tasks, int index) {
        super(tasks);
        this.index = index;
    }

    @Override
    public void execute() {
        Task task = tasks.get(this.index);
        task.unmarkDone();
        System.out.println("OK, I've marked this task as not done yet:");
        System.out.println(" " + task.displayDone() + task.taskDescription());
    }
}
