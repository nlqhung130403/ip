public class Event extends Task{

    private String startDate;
    private String endDate;

    public Event(String description, String startDate, String endDate) {
        this(false, description, startDate, endDate);
    }

    public Event(boolean isDone, String description, String startDate, String endDate) {
        super(isDone, description);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "[E]" + this.displayDone() + this.taskDescription()
                + " (from: " + this.startDate + " to: " + this.endDate + ")";
    }

    @Override
    public String toSave() {
        String isDone = this.isDone() ? "1" : "0";
        return "E|" + super.toSave() + "|" + this.startDate + "|" + this.endDate;
    }
}
