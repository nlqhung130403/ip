import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ferb {
    private static final String INDENT = "    ";
    private static List<Task> list = new ArrayList<>();

    private static void add(Task task) {
        list.add(task);
        System.out.println(Ferb.INDENT + "added: " + task.taskDescription());
    }

    private static void list() {
        for (int i = 1; i <= list.size(); i++) {
            Task task = list.get(i-1);
            System.out.println(INDENT + i + "." + task.displayDone() + task.taskDescription());
        }
    }

    private static void markDone(int index) {
        Task task = list.get(index);
        task.markDone();
        System.out.println(INDENT + "Nice! I have marked this task as done:");
        System.out.println(INDENT + " " + task.displayDone() + task.taskDescription());
    }

    private static void unmarkDone(int index) {
        Task task = list.get(index);
        task.unmarkDone();
        System.out.println(INDENT + "OK, I've marked this task as not done yet:");
        System.out.println(INDENT + " " + task.displayDone() + task.taskDescription());
    }

    private static void run(){
        Scanner scanner = new Scanner(System.in);

        //Create a loop for inputs and terminate when bye
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) {
                System.out.println(Ferb.INDENT + "Bye. Hope to see you again soon!");
                scanner.close();
                break;
            } else if (command.equals("list")) {
                list();
                continue;
            } else if (command.contains("unmark")) {
                int index = Integer.parseInt(command.substring(7, command.length())) - 1;
                unmarkDone(index);
                continue;
            } else if (command.contains("mark")) {
                int index = Integer.parseInt(command.substring(5, command.length())) - 1;
                markDone(index);
                continue;
            }
            Task task = new Task(command);
            Ferb.add(task);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Ferb\nWhat can I do for you?\n");
        Ferb.run();
    }
}
