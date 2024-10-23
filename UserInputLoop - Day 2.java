import java.util.Scanner;

public class day1UserInputLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        while (!input.equalsIgnoreCase("exit")) {
            System.out.println("Enter something (type 'exit' to quit): ");
            input = scanner.nextLine();
            if (!input.equalsIgnoreCase("exit")) {
                System.out.println("You entered: " + input);
            }
        }

        System.out.println("Exited the loop");
        scanner.close();
    }
}
