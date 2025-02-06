public class DeleteCommand extends Command{
    private int index;

    public DeleteCommand(TaskList tasks, int index) {
        super(tasks);
        this.index = index;
    }

    @Override
    public void execute() {
        Task task = tasks.get(index - 1);
        tasks.remove(index - 1);
        System.out.println("Noted. I've removed this task: ");
        System.out.println(task.toString());
        System.out.println("Now you have " + tasks.size() + " tasks in list");
    }
}
