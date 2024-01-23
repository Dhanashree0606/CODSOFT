import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance = amount + balance;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance = amount-balance;
            return true;
        } else {
            System.out.println("YOu don't have sufficient deposite.");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    public void displayOptions() {
        System.out.println("ATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public void run() {
        int choice;
        do {
            displayOptions();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    private void withdraw() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (userAccount.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: Rs." + userAccount.getBalance());
            System.out.println("\n");

        } else {
            System.out.println("Withdrawal failed due to Insufficient funds.\n\n");
        }
    }

    private void deposit() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        userAccount.deposit(amount);
        System.out.println("Deposit successful. Updated balance: Rs." + userAccount.getBalance());
        System.out.println("\n");
    }

    private void checkBalance() {
        System.out.println("Current balance: Rs." + userAccount.getBalance());
        System.out.println("\n");
    }

    public Object getAccounts() {
        return null;
    } 
    
      public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(0);
        ATM atm = new ATM(userAccount);
        atm.run();
    }

}