package ferb.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task{

    private LocalDate deadline;
    private static final DateTimeFormatter DATEFORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy");

    public Deadline(String description, String deadline) {
        this(false, description, deadline);
    }

    public Deadline(boolean isDone, String description, String deadline){
        super(isDone, description);
        this.deadline = LocalDate.parse(deadline);
    }

    public String getBy() {
        return this.deadline.format(DATEFORMAT);
    }

    @Override
    public String toString() {
        return "[D]" + this.displayDone() + this.taskDescription()
                + " (by: " + this.getBy() + ")";
    }

    @Override
    public String toSave() {
        return "D|" + super.toSave() + "|" + this.deadline;
    }

}
