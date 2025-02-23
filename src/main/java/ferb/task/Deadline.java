package ferb.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a deadline task.
 */
public class Deadline extends Task{

    private LocalDate deadline;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String deadline) {
        this(false, description, deadline);
    }

    public Deadline(boolean isDone, String description, String deadline){
        super(isDone, description);
        this.deadline = LocalDate.parse(deadline);
    }

    /**
     * Returns the deadline date formatted as MMM dd yyyy.
     *
     * @return the formatted deadline date
     */
    public String getBy() {
        return this.deadline.format(DATE_TIME_FORMATTER);
    }

    /**
     * Returns a string representation of the deadline task.
     *
     * @return a string representation of the deadline task
     */
    @Override
    public String toString() {
        return "[D]" + this.displayDone() + this.taskDescription()
                + " (by: " + this.getBy() + ")";
    }

    /**
     * Returns a string representation of the deadline task for saving to a file.
     *
     * @return a string representation of the deadline task for saving to a file
     */
    @Override
    public String toSave() {
        return "D|" + super.toSave() + "|" + this.deadline;
    }

}
