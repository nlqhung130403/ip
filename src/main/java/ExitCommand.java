public class ExitCommand extends Command{
    private FerbFileHandler fileHandler;

    public ExitCommand(TaskList tasks, FerbFileHandler fileHandler) {
        super(tasks);
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute() {
        Ui.exit();
        fileHandler.writeContent(tasks);
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
