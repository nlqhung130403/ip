package ferb.tasklist;

import ferb.exception.FerbException;
import ferb.task.*;
import java.util.ArrayList;


/**
 * Represents a list of tasks.
 */
public class TaskList extends ArrayList<Task> {


    public TaskList() {
        super();
    }

    /**
     * Constructs a task list from the specified content.
     *
     * @param content the content of the task list
     */
    public TaskList(String content) throws FerbException {
        String[] lines = content.split("\\R");

        for (String line : lines) {
            String[] fields = line.split("\\|");

            if (fields.length == 3) {
                this.processTodo(fields);
            } else if (fields.length == 4) {
                this.processDeadline(fields);
            } else if (fields.length == 5) {
                this.processEvent(fields);
            } else {
                throw new FerbException("Invalid task format in file.");
            }
        }
    }

    private void processTodo(String[] fields) throws FerbException {
        if (!fields[0].equals("T")) {
            throw new FerbException("Invalid task format in file.");
        }
        this.add(new ToDo(fields[1].equals("1") ? true : false, fields[2]));
    }

    private void processDeadline(String[] fields) throws FerbException {
        if (!fields[0].equals("D")) {
            throw new FerbException("Invalid task format in file.");
        }
        this.add(new Deadline(fields[1].equals("1") ? true : false, fields[2], fields[3]));
    }

    private void processEvent(String[] fields) throws FerbException {
        if (!fields[0].equals("E")) {
            throw new FerbException("Invalid task format in file.");
        }
        this.add(new Event(fields[1].equals("1") ? true : false, fields[2], fields[3], fields[4]));
    }


    /**
     * Finds tasks that contain the specified keyword.
     *
     * @param keyword the keyword to search for
     * @return a task list containing tasks that contains the keyword
     */
    public TaskList find(String keyword) {
        TaskList result = new TaskList();
        for (Task task : this) {
            if (task.contains(keyword)) {
                result.add(task);
            }
        }
        return result;
    }

    /**
     * Returns a string representation of the task list.
     *
     * @return a string representation of the task list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            result.append(i + 1).append(". ").append(this.get(i)).append("\n");
        }
        return result.toString();
    }
}
