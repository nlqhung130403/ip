package ferb.parser;

import ferb.command.*;
import ferb.exception.FerbException;
import ferb.filehandler.FerbFileHandler;
import ferb.tasklist.TaskList;
import ferb.task.*;

public class Parser {
    private TaskList tasks;
    private FerbFileHandler fileHandler;

    public Parser(TaskList tasks, FerbFileHandler fileHandler) {
        this.tasks = tasks;
        this.fileHandler = fileHandler;
    }

    public Command parse(String command) throws FerbException{
        if (command.equals("bye")) {
            return new ExitCommand(this.tasks, fileHandler);
        } else if (command.equals("list")) {
            return new ListCommand(this.tasks);
        } else if (command.contains("unmark")) {
            int index = Integer.parseInt(command.substring(7, command.length())) - 1;
            return new UnmarkDoneCommand(this.tasks, index);
        } else if (command.contains("mark")) {
            int index = Integer.parseInt(command.substring(5, command.length())) - 1;
            return new MarkDoneCommand(this.tasks, index);
        } else if (command.contains("todo")) {
            return new AddCommand(this.tasks, new ToDo(command.substring(5, command.length())));
        } else if (command.contains("deadline")) {
            int i = command.indexOf("/by");
            String deadline = command.substring(i + 4, command.length());
            String description = command.substring(9, i - 1);
            return new AddCommand(this.tasks, new Deadline(description, deadline));
        } else if (command.contains("event")) {
            int fi = command.indexOf("/from");
            int ti = command.indexOf("/to");
            String description = command.substring(6, fi - 1);
            String startDate = command.substring(fi + 6, ti - 1);
            String endDate = command.substring(ti + 4, command.length());
            return new AddCommand(this.tasks, new Event(description, startDate, endDate));
        } else if (command.contains("delete")) {
            int index = Integer.parseInt(command.substring(7, command.length()));
            return new DeleteCommand(this.tasks, index);
        } else if (command.contains("find")) {
            String keyword = command.substring(5, command.length());
            return new FindCommand(this.tasks, keyword);
        } else {
            throw new FerbException();
        }
    }
}