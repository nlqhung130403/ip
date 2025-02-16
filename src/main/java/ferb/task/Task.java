package ferb.task;

public class Task {
    private boolean isDone;
    private String description;

    public Task(String description) {
        this(false, description);
    }

    public Task(boolean isDone, String description){
        this.description = description;
        this.isDone = isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    public void unmarkDone() {
        this.isDone = false;
    }

    public String taskDescription() {
        return this.description;
    }

    public String displayDone(){
        return this.isDone ? "[X] " : "[ ] ";
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return this.displayDone() + this.taskDescription();
    }

    public String toSave() {
        String id = this.isDone() ? "1" : "0";
        return id + "|" + this.taskDescription();
    }

    public boolean contains(String keyword) {
        return this.taskDescription().contains(keyword);
    }


}
