import java.util.Scanner;

// Account Class
class Account {
    int accountNumber;
    String accountHolderName;
    double balance;
    String email;
    String phoneNumber;

    // Constructor
    Account(int accountNumber, String accountHolderName, double balance, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Deposit Method
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully! New Balance: " + balance);
        } else {
            System.out.println("Invalid amount. Deposit must be positive.");
        }
    }

    // Withdraw Method
    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Amount withdrawn successfully! New Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid amount. Withdrawal must be positive.");
        }
    }

    // Display Account Details
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
    }

    // Update Contact Details
    void updateContactDetails(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        System.out.println("Contact details updated successfully!");
    }
}

// User Interface Class
public class BankingApplication {
    static Scanner sc = new Scanner(System.in);
    static Account[] accounts = new Account[100]; // fixed-size array
    static int accountCount = 0;
    static int nextAccountNumber = 1001;

    // Create a new Account
    static void createAccount() {
        System.out.print("Enter account holder name: ");
        sc.nextLine(); //  newline
        String name = sc.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = sc.nextDouble();
        System.out.print("Enter email address: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        Account acc = new Account(nextAccountNumber, name, initialDeposit, email, phone);
        accounts[accountCount++] = acc;

        System.out.println("Account created successfully with Account Number: " + nextAccountNumber);
        nextAccountNumber++;
    }

    // Deposit
    static void performDeposit() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            acc.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Withdraw
    static void performWithdrawal() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = sc.nextDouble();
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Show Account Details
    static void showAccountDetails() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) {
            acc.displayAccountDetails();
        } else {
            System.out.println("Account not found!");
        }
    }

    // Update Contact Details
    static void updateContact() {
        System.out.print("Enter account number: ");
        int accNo = sc.nextInt();
        Account acc = findAccount(accNo);
        if (acc != null) {
            System.out.print("Enter new email: ");
            sc.nextLine();
            String email = sc.nextLine();
            System.out.print("Enter new phone number: ");
            String phone = sc.nextLine();
            acc.updateContactDetails(email, phone);
        } else {
            System.out.println("Account not found!");
        }
    }

    // Find Account by Number
    static Account findAccount(int accNo) {
        for (int i = 0; i < accountCount; i++) {
            if (accounts[i].accountNumber == accNo) {
                return accounts[i];
            }
        }
        return null;
    }

    // Main Menu
    static void mainMenu() {
        int choice;
        do {
            System.out.println("\n Banking Application ");
            System.out.println("1. Create a new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. View account details");
            System.out.println("5. Update contact details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: createAccount(); break;
                case 2: performDeposit(); break;
                case 3: performWithdrawal(); break;
                case 4: showAccountDetails(); break;
                case 5: updateContact(); break;
                case 6: System.out.println("Exiting application. Goodbye!"); break;
                default: System.out.println("Invalid choice, try again!");
            }
        } while (choice != 6);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}

