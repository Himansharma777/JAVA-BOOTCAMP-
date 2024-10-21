import java.util.Scanner;

public class AtmSystem {
    static int pin = 7777;
    static double accountBalance = 10000;
    static double machineRemainingBalance = 5000;
    static final double MAX_DEPOSIT = 50000;
    
    private static boolean authenticate(Scanner sc) {
    for (int attempts = 0; attempts < 3; attempts++) {
        System.out.print("Please Enter Your ATM Pin:\n");
        if (sc.hasNextInt()) {
            int userPin = sc.nextInt();
            if (userPin == pin) {
                return true;
            } else {
                System.out.println("Incorrect PIN. Try again.");
            }
        } else {
            System.out.println("Please enter a valid PIN.");
            sc.next();
        }
    }
    return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     
        if (!authenticate(sc)) {
            System.out.println("Too many incorrect attempts. Exiting...");
            return;
        }

        while (true) {
            switch (menu(sc)) {
                case 1 -> withdraw(sc);
                case 2 -> deposit(sc);
                case 3 -> checkBalance();
                case 4 -> {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static int menu(Scanner sc) {
        System.out.println("\nSelect an option:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        return sc.nextInt();
    }

    private static void withdraw(Scanner sc) {
        System.out.println("Please Enter Amount to Withdraw:");
        if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount <= accountBalance && amount <= machineRemainingBalance) {
                accountBalance -= amount;
                machineRemainingBalance -= amount;
                System.out.println("Please collect your money.");
            } else {
                System.out.println(amount > accountBalance ? "Insufficient account balance." : "The ATM does not have enough money.");
            }
        } else {
            System.out.println("Please enter a valid amount to withdraw.");
            sc.next(); 
        }
    }

    private static void deposit(Scanner sc) {
        System.out.println("Please Enter Amount to Deposit:");
        if (sc.hasNextInt()) {
            int amount = sc.nextInt();
            if (amount > 0 && amount <= MAX_DEPOSIT) {
                accountBalance += amount;
                machineRemainingBalance += amount;
                System.out.println("Deposit successful.");
            } else {
                System.out.println(amount > MAX_DEPOSIT ? "Deposit amount exceeds maximum limit of " + MAX_DEPOSIT : "Please enter a valid amount to deposit.");
            }
        } else {
            System.out.println("Please enter a valid amount to deposit.");
            sc.next();
        }
    }

    private static void checkBalance() {
        System.out.println("Account Balance: " + accountBalance);
        System.out.println("ATM Machine Balance: " + machineRemainingBalance);
    }
}