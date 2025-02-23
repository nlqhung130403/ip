package ferb.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task{

    private LocalDate startDate;
    private LocalDate endDate;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Event(String description, String startDate, String endDate) {
        this(false, description, startDate, endDate);
    }

    public Event(boolean isDone, String description, String startDate, String endDate) {
        super(isDone, description);
        this.startDate = LocalDate.parse(startDate);
        this.endDate = LocalDate.parse(endDate);
    }

    public static String displayDate(LocalDate date) {
        return date.format(DATE_TIME_FORMATTER);
    }

    @Override
    public String toString() {
        return "[E]" + this.displayDone() + this.taskDescription()
                + " (from: " + Event.displayDate(this.startDate) + " to: "
                + Event.displayDate(this.endDate) + ")";
    }

    @Override
    public String toSave() {
        String isDone = this.isDone() ? "1" : "0";
        return "E|" + super.toSave() + "|" + this.startDate + "|" + this.endDate;
    }

    public String getTo() {
        return this.endDate.format(DATE_TIME_FORMATTER);
    }

    public String getFrom() {
        return this.startDate.format(DATE_TIME_FORMATTER);
    }
}
