import java.util.Scanner;

public class Ui {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void  showWelcome() {
        System.out.println("Hey there, I'm Ferb!\nHow can I help?");
    }

    public static String readCommand() {
        return SCANNER.nextLine();
    }

    public static void exit() {
        System.out.println("Bye! Hope to see you again soon!");
        SCANNER.close();
    }

}
