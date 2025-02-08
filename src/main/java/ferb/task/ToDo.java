package ferb.task;

public class ToDo extends Task{
    public ToDo(String description) {
        super(description);
    }

    public ToDo(boolean isDone, String description) {
        super(isDone, description);
    }

    @Override
    public String toString() {
        return "[T]" + this.displayDone() + this.taskDescription();
    }

    @Override
    public String toSave() {
        return "T|" + super.toSave();
    }

}
