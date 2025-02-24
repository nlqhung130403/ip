package ferb.ui;

import ferb.task.Task;
import ferb.tasklist.TaskList;

public class Ui {
    private String message;

    public String getMessage() {
        return message;
    }

    public void  showWelcome() {
        this.message = "Hello! I'm Ferb\nWhat can I do for you today?";
    }

    public void showGoodbye() {
        this.message = "Bye. Hope to see you again soon!";
    }

    public void showLoadingError() {
        this.message = "Error loading file. Creating new task list.";
    }

    public void showTaskAdded(Task task) {
        this.message = "Got it. I've added this task:\n  " + task.toString();
    }

    public void showTaskMarkedDone(Task task) {
        this.message = "Nice! I've marked this task as done:\n  " + task.toString();
    }

    public void showTaskUnmarkedDone(Task task) {
        this.message = "Nice! I've marked this task as undone:\n  " + task.toString();
    }

    public void showTaskDeleted(Task task) {
        this.message = "Noted. I've removed this task:\n  " + task.toString();
    }

    public void showTaskList(TaskList taskList) {
        this.message = "Here are the tasks in your list:\n" + taskList;
    }

    public void showMatchingTasks(TaskList taskList) {
        if (taskList.isEmpty()) {
            this.message = "You have no tasks in your list.";
        } else {
            this.message = "Here are the tasks in your list:\n" + taskList;
        }
    }

}
