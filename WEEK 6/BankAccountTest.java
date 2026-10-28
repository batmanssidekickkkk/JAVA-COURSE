public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("ACC12345", "Alice Smith", 5000.00);
        
        myAccount.displayAccountInfo();

        System.out.println("Depositing KSh 2000...");
        myAccount.deposit(2000.00);

        System.out.println("\nWithdrawing KSh 1500...");
        myAccount.withdraw(1500.00);

        System.out.println("\nAttempting to withdraw KSh 10000 (Insufficient funds)...");
        myAccount.withdraw(10000.00);

        System.out.println("\nAttempting to deposit a negative amount (-500)...");
        myAccount.deposit(-500.00);

        System.out.println("\nFinal Account Status:");
        myAccount.displayAccountInfo();
    }
}

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0.0;
            System.out.println("Error: Initial balance cannot be negative. Set to 0.0");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: KSh " + amount);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: KSh " + amount);
        } else if (amount > balance) {
            System.out.println("Error: Insufficient funds.");
        } else {
            System.out.println("Error: Withdrawal amount must be positive.");
        }
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance: KSh %.2f%n", balance);
        System.out.println("--------------------");
    }
}
