package ferb.command;

import ferb.tasklist.TaskList;

/**
 * Represents an abstract command that can be executed.
 */
public abstract class Command {
    TaskList tasks;

    public Command() {}
    public Command(TaskList tasks) {
        this.tasks = tasks;
    }

    /**
     * Executes the command.
     */
    public abstract void execute();

    /**
     * Returns true if the command is an exit command.
     *
     * @return true if the command is an exit command
     */
    public boolean isExit() {
        return false;
    }
}
