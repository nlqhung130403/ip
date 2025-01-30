public class Task {
    private boolean isDone = false;
    private String description;

    public Task(String description) {
        this.description = description;
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


}
