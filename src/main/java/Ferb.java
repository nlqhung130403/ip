import java.util.Scanner;
public class Ferb {
    private static String INDENT = "    ";

    private static void run(){
        Scanner scanner = new Scanner(System.in);

        //Create a loop for inputs and terminate when bye
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("bye")) {
                System.out.println(Ferb.INDENT + "Bye. Hope to see you again soon!");
                scanner.close();
                break;
            }
            System.out.println(Ferb.INDENT + command);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello! I'm Ferb\nWhat can I do for you?\n");
        Ferb.run();
    }
}
