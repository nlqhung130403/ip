public class Deadline extends Task{

    private String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "[D]" + this.displayDone() + this.taskDescription()
                + " (by: " + this.deadline + ")";
    }

}
