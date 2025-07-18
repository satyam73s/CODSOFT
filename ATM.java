import java.util.Scanner;
import java.util.Random;
class BankAccount {
    private double balance;
    private String accountNumber;
    private String userName;
    private String userPhoneNumber;
    public BankAccount(double initialDeposit, String userName, String userPhoneNumber) {
        if (initialDeposit >= 0) {
            this.balance = initialDeposit;
        } else {
            this.balance = 0;
            System.out.println("Initial deposit cannot be less than zero. Automatically setting balance to 0.");
        }
        this.accountNumber = generateAccountNumber();
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
    }
    private String generateAccountNumber() {
        Random random = new Random();

        int num = 10000000 + random.nextInt(90000000);
        return String.valueOf(num);
    }
    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public String getUserName() {
        return userName;
    }
    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited %.2f. Current balance: %.2f%n", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Successfully withdrew %.2f. Current balance: %.2f%n", amount, balance);
            return true;
        } else {
            System.out.printf("Insufficient balance. Current balance: %.2f%n", balance);
            return false;
        }
    }
}
public class ATM {
    private BankAccount userAccount;
    private Scanner scanner;
    public ATM() {
        this.scanner = new Scanner(System.in);
    }
    public void displayMenu() {
        System.out.println("\n--- BANK OPTIONS ---");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Exit");
        System.out.print("Choose any option: ");
    }
    public void run() {
        System.out.println("Welcome to the SA's Bank!");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.print("Enter your mobile number: ");
        String userPhoneNumber = scanner.nextLine();

        System.out.print("Enter initial deposit money for your new account: ");
        double initialDeposit = getValidatedDoubleInput();
        this.userAccount = new BankAccount(initialDeposit, userName, userPhoneNumber);
        System.out.println("Account creation successfull!");
        System.out.println("Account Holder Name: " + userAccount.getUserName());
        System.out.println("Mobile Number: " + userAccount.getUserPhoneNumber());
        System.out.println("The account number is: " + userAccount.getAccountNumber());
        System.out.printf("Initial balance: %.2f%n", userAccount.getBalance());

        int choice;
        do {
            displayMenu();
            choice = getValidatedIntegerInput();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositFunds();
                    break;
                case 3:
                    withdrawFunds();
                    break;
                case 4:
                    System.out.println("Thank you for using our Bank. Have a good day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (choice != 4);
        scanner.close();
    }
    private void checkBalance() {
        System.out.printf("Your current balance is: %.2f%n", userAccount.getBalance());
    }
    private void depositFunds() {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidatedDoubleInput();
        userAccount.deposit(amount);
    }
    private void withdrawFunds() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidatedDoubleInput();
        userAccount.withdraw(amount);
    }
    private int getValidatedIntegerInput() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
            System.out.print("Choose an option: ");
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }
    private double getValidatedDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
            System.out.print("Enter amount: ");
        }
        double input = scanner.nextDouble();
        scanner.nextLine();
        if (input < 0) {
            System.out.println("Amount cannot be negative. Please enter a positive amount.");
            return getValidatedDoubleInput();
        }
        return input;
    }
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.run();
    }
}
