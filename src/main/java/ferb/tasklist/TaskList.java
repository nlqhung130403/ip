package ferb.tasklist;

import ferb.exception.FerbException;
import ferb.task.*;
import java.util.ArrayList;


/**
 * Represents a list of tasks.
 */
public class TaskList extends ArrayList<Task> {

    /**
     * Constructs a task list from the specified content.
     *
     * @param content the content of the task list
     */
    public TaskList(String content) {
        String[] tasks = content.split("\\R");

        for (String task : tasks) {
            String[] fields = task.split("\\|"); //escape special character
            String type = fields[0];
            boolean isDone = fields[1].equals("1") ? true : false;
            String description = fields[2];
            if (type.equals("T")) {
                this.add(new ToDo(isDone, description));
            } else if (type.equals("D")) {
                String deadline = fields[3];
                try {
                    this.add(new Deadline(isDone, description, deadline));
                } catch (FerbException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                String from = fields[3];
                String to = fields[4];
                try {
                    this.add(new Event(isDone, description, from, to));
                } catch (FerbException e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
    }

    public TaskList() {
        super();
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
