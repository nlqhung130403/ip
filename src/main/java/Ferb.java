import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Ferb {
    private static final String INDENT = "    ";
    private static List<String> list = new ArrayList<String>();

    private static void add(String command) {
        list.add(command);
        System.out.println(Ferb.INDENT + "added: " + command);
    }

    private static void list() {
        for (int i = 1; i <= list.size(); i++) {
            System.out.println(INDENT + i + ". " + list.get(i-1));
        }
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
            }
            Ferb.add(command);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Ferb\nWhat can I do for you?\n");
        Ferb.run();
    }
}
