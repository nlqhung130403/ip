package ferb.parser;

import ferb.command.*;
import ferb.exception.FerbException;
import ferb.filehandler.FerbFileHandler;
import ferb.tasklist.TaskList;
import ferb.task.*;

/**
 * Represents a parser that parses user input into commands.
 */
public class Parser {
    private TaskList tasks;
    private FerbFileHandler fileHandler;

    public Parser(TaskList tasks, FerbFileHandler fileHandler) {
        this.tasks = tasks;
        this.fileHandler = fileHandler;
    }

    /**
     * Parses the user input into a command.
     *
     * @param command the user input
     * @return the command to be executed
     * @throws FerbException if the command is not supported
     */
    public Command parse(String command) throws FerbException{
        if (command.equals("bye")) {
            return new ExitCommand();
        } else if (command.equals("list")) {
            return new ListCommand();
        } else if (command.contains("unmark")) {
            int index = Integer.parseInt(command.substring(7, command.length())) - 1;
            return new UnmarkDoneCommand(index);
        } else if (command.contains("mark")) {
            int index = Integer.parseInt(command.substring(5, command.length())) - 1;
            return new MarkDoneCommand(index);
        } else if (command.contains("todo")) {
            return new AddCommand(new ToDo(command.substring(5, command.length())));
        } else if (command.contains("deadline")) {
            int i = command.indexOf("/by");
            String deadline = command.substring(i + 4, command.length());
            String description = command.substring(9, i - 1);
            return new AddCommand(new Deadline(description, deadline));
        } else if (command.contains("event")) {
            int fi = command.indexOf("/from");
            int ti = command.indexOf("/to");
            String description = command.substring(6, fi - 1);
            String startDate = command.substring(fi + 6, ti - 1);
            String endDate = command.substring(ti + 4, command.length());
            return new AddCommand(new Event(description, startDate, endDate));
        } else if (command.contains("delete")) {
            int index = Integer.parseInt(command.substring(7, command.length()));
            return new DeleteCommand(this.tasks, index);
        } else if (command.contains("find")) {
            String keyword = command.substring(5, command.length());
            return new FindCommand(keyword);
        } else {
            throw new FerbException();
        }
    }
}