package ferb.tasklist;

import ferb.task.*;
import java.util.ArrayList;


public class TaskList extends ArrayList<Task> {

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
                this.add(new Deadline(isDone, description, deadline));
            } else {
                String from = fields[3];
                String to = fields[4];
                this.add(new Event(isDone, description, from, to));
            }
        }
    }

    public TaskList() {
        super();
    }

    public TaskList find(String keyword) {
        TaskList result = new TaskList();
        for (Task task : this) {
            if (task.contains(keyword)) {
                result.add(task);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size(); i++) {
            result.append(i + 1).append(". ").append(this.get(i)).append("\n");
        }
        return result.toString();
    }
}
