public class MarkDoneCommand extends Command {
    private int index;

    public MarkDoneCommand(TaskList tasks, int index) {
        super(tasks);
        this.index = index;
    }

    @Override
    public void execute() {
        Task task = tasks.get(index);
        task.markDone();
        System.out.println("Nice! I have marked this task as done:");
        System.out.println(task.displayDone() + task.taskDescription());
    }
}
