package ferb.task;

import ferb.exception.FerbException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Represents an event task.
 */
public class Event extends Task{

    private LocalDate startDate;
    private LocalDate endDate;
    private static final DateTimeFormatter DATEFORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Event(String description, String startDate, String endDate) throws FerbException {
        this(false, description, startDate, endDate);
    }

    public Event(boolean isDone, String description, String startDate, String endDate) throws FerbException {
        super(isDone, description);
        this.startDate = parseDate(startDate);
        this.endDate = parseDate(endDate);
    }

    private LocalDate parseDate(String date) throws FerbException {
        try {
            return LocalDate.parse(date);
        } catch (DateTimeParseException e) {
            throw new FerbException("Invalid date format. Please use yyyy-mm-dd.");
        }
    }
    /**
     * Returns a string representation of the event task.
     *
     * @return a string representation of the event task
     */
    @Override
    public String toString() {
        return "[E]" + this.displayDone() + this.taskDescription()
                + " (from: " + this.getFrom() + " to: "
                + this.getTo() + ")";
    }

    /**
     * Returns a formatted string of the event task for saving to a file.
     *
     * @return a formatted string of the event task for saving to a file
     */
    @Override
    public String toSave() {
        String isDone = this.isDone() ? "1" : "0";
        return "E|" + super.toSave() + "|" + this.startDate + "|" + this.endDate;
    }

    /**
     * Returns the end date of the event formatted as MMM dd yyyy.
     *
     * @return the formatted end date of the event
     */
    public String getTo() {
        return this.endDate.format(DATEFORMAT);
    }

    /**
     * Returns the start date of the event formatted as MMM dd yyyy.
     *
     * @return the formatted start date of the event
     */
    public String getFrom() {
        return this.startDate.format(DATEFORMAT);
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }
}
