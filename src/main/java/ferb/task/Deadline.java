package ferb.task;

import ferb.exception.FerbException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents a deadline task.
 */
public class Deadline extends Task{

    private LocalDate deadline;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String deadline) throws FerbException {
        this(false, description, deadline);
    }

    public Deadline(boolean isDone, String description, String deadline) throws FerbException {
        super(isDone, description);
        this.deadline = parseDate(deadline);
    }

    private LocalDate parseDate(String date) throws FerbException {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new FerbException("Invalid date format. Please use yyyy-mm-dd.");
        }
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

    public LocalDate getDeadline() {
        return deadline;
    }


}
