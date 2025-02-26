package ferb.tasklist;

import ferb.exception.FerbException;
import ferb.task.*;
import java.util.ArrayList;
import java.time.LocalDate;


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

    public void sortDescription() {
        this.sort((t1, t2) -> t1.taskDescription().compareTo(t2.taskDescription()));
    }

    public TaskList sort(){
        return this.sortDate(0, this.size() - 1);
    }

    public TaskList sortDate(int start, int end){
        if (start >= end) {
            TaskList tl = new TaskList();
            tl.add(this.get(start));
            return tl;
        }

        int mid = (start + end)/2;
        TaskList firstHalf = this.sortDate(start, mid);
        TaskList secondHalf = this.sortDate(mid + 1, end);

        int pointer1 = 0;
        int pointer2 = 0;

        TaskList tl = new TaskList();

        while (pointer1 < firstHalf.size() && pointer2 < secondHalf.size()) {
            Task t1 = firstHalf.get(pointer1);
            Task t2 = secondHalf.get(pointer2);
            int compared = compareDates(t1, t2);
            if (compared <= 0) {
                tl.add(t1);
                pointer1++;
            } else if (compared > 0) {
                tl.add(t2);
                pointer2++;
            }
        }

        while (pointer1 < firstHalf.size()) {
            tl.add(firstHalf.get(pointer1));
            pointer1++;
        }

        while(pointer2 < secondHalf.size()) {
            tl.add(secondHalf.get(pointer2));
            pointer2++;
        }

        return tl;
    }

    private int compareDates(Task t1, Task t2) {
        if (t1.isTodo()) {
            return -1;
        } else if (t2.isTodo()) {
            return 1;
        }
        LocalDate d1, d2;
        if (t1 instanceof Deadline && t2 instanceof Deadline) {
            d1 = ((Deadline) t1).getDeadline();
            d2 = ((Deadline) t2).getDeadline();
        } else if (t1 instanceof Event && t2 instanceof Event) {
            d1 = ((Event) t1).getStartDate();
            d2 = ((Event) t2).getStartDate();
        } else if (t1 instanceof Deadline) {
            d1 = ((Deadline) t1).getDeadline();
            d2 = ((Event) t2).getStartDate();
        } else{
            d1 = ((Event) t1).getStartDate();
            d2 = ((Deadline) t2).getDeadline();
        }
        return d1.compareTo(d2);
    }

    public static void main(String[] args) throws FerbException {
        TaskList taskList = new TaskList();
        taskList.add(new Deadline("Submit assignment", "2023-12-01"));
        taskList.add(new Event("Conference", "2023-11-20", "2023-11-22"));
        taskList.add(new Deadline("Pay bills", "2023-11-15"));
        taskList.add(new Event("Vacation", "2023-12-05", "2023-12-10"));
        taskList.add(new ToDo("Buy groceries"));
        taskList.add(new ToDo("Read a book"));
        taskList.add(new ToDo("Exercise"));
        taskList.add(new ToDo("Call a friend"));
        taskList.add(new ToDo("Clean the house"));
        taskList.add(new Deadline("Project presentation", "2023-12-10"));
        taskList.add(new Event("Team meeting", "2023-11-25", "2023-11-25"));
        taskList.add(new Deadline("Doctor appointment", "2023-11-30"));
        taskList.add(new Event("Workshop", "2023-12-02", "2023-12-03"));

        System.out.println("Before sorting:");
        System.out.println(taskList);

        TaskList sorted = taskList.sort();

        System.out.println("After sorting:");
        System.out.println(sorted);
    }


}
