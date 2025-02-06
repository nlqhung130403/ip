public abstract class Command {
    TaskList tasks;

    public Command() {}
    public Command(TaskList tasks) {
        this.tasks = tasks;
    }

    public abstract void execute();

    public boolean isExit() {
        return false;
    }
}
