import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ferb {
    private static final String INDENT = "    ";
    private static List<Task> list = new ArrayList<>();

    private static void add(Task task) {
        list.add(task);
        System.out.println(Ferb.INDENT + "Got it. I've added this task:\n " + INDENT + task.toString());
        System.out.println(Ferb.INDENT + "Now you have " + list.size() + " tasks in the list.");
    }

    private static void list() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 1; i <= list.size(); i++) {
            Task task = list.get(i-1);
            System.out.println(INDENT + i + "." + task.toString());
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

    private static void commandProcessing (String command) {
        Task task;

    }

    private static void run(){
        Scanner scanner = new Scanner(System.in);

        //Create a loop for inputs and terminate when bye
        while (true) {
            String command = scanner.nextLine();
            try {
                Task task;
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
                } else if (command.contains("todo")) {
                    task = new ToDo(command.substring(5, command.length()));
                } else if (command.contains("deadline")) {
                    int i = command.indexOf("/by");
                    String deadline = command.substring(i + 4, command.length());
                    String description = command.substring(9, i - 1);
                    task = new Deadline(description, deadline);
                } else if (command.contains("event")) {
                    int fi = command.indexOf("/from");
                    int ti = command.indexOf("/to");
                    String description = command.substring(6, fi - 1);
                    String startDate = command.substring(fi + 6, ti - 1);
                    String endDate = command.substring(ti + 4, command.length());
                    task = new Event(description, startDate, endDate);
                } else {
                    throw new FerbException();
                }
                Ferb.add(task);
            } catch (RuntimeException e) {
                System.out.println(INDENT + "Wrong command format! Please try again.");
            } catch (FerbException e) {
                System.out.println(INDENT + "Sorry! Command not supported!");
            }

        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Ferb\nWhat can I do for you?\n");
        Ferb.run();
    }
}
