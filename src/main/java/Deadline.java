public class Deadline extends Task{

    private String deadline;

    public Deadline(String description, String deadline) {
        this(false, description, deadline);
    }

    public Deadline(boolean isDone, String description, String deadline){
        super(isDone, description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + this.displayDone() + this.taskDescription()
                + " (by: " + this.deadline + ")";
    }

    @Override
    public String toSave() {
        return "D|" + super.toSave() + "|" + this.deadline;
    }

}
