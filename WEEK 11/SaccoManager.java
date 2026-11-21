import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

// ==========================================
// 1. CUSTOM EXCEPTION
// ==========================================
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// ==========================================
// 2. INTERFACE
// ==========================================
interface Auditable {
    void logTransaction(String message);
}

// ==========================================
// 3. ABSTRACT BASE CLASS
// ==========================================
abstract class Account implements Auditable {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accountNumber, double initialBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("Account number cannot be blank.");
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.balance = balance;
    }

    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be greater than zero.");
            return;
        }
        this.balance += amount;
        String record = "Deposited: KSh " + String.format("%.2f", amount)
                + " | New Balance: KSh " + String.format("%.2f", balance);
        transactionHistory.add(record);
        logTransaction(record);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
            return;
        }
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Insufficient funds. Available balance is KSh " + String.format("%.2f", balance));
        }
        this.balance -= amount;
        String record = "Withdrew: KSh " + String.format("%.2f", amount)
                + " | New Balance: KSh " + String.format("%.2f", balance);
        transactionHistory.add(record);
        logTransaction(record);
    }

    public abstract double calculateInterest();

    @Override
    public void logTransaction(String message) {
        try (FileWriter fw = new FileWriter("transactions.txt", true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(accountNumber + " | " + message);
        } catch (IOException e) {
            System.out.println("Error writing to transaction log: " + e.getMessage());
        }
    }
}

// ==========================================
// 4. CONCRETE SUBCLASSES
// ==========================================
class SavingsAccount extends Account {
    private static final double INTEREST_RATE = 0.05; // 5%

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class LoanAccount extends Account {
    private static final double INTEREST_RATE = 0.12; // 12%

    public LoanAccount(String accountNumber, double initialBalance) {
        super(accountNumber, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

// ==========================================
// 5. MEMBER DOMAIN CLASS
// ==========================================
class Member {
    private String memberId;
    private String name;
    private String nationalId;
    private Map<String, Account> accounts;

    public Member(String memberId, String name, String nationalId) {
        setMemberId(memberId);
        setName(name);
        setNationalId(nationalId);
        this.accounts = new HashMap<>();
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        if (memberId == null || memberId.isBlank()) {
            throw new IllegalArgumentException("Member ID cannot be empty.");
        }
        this.memberId = memberId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name.trim();
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        if (nationalId == null || nationalId.isBlank()) {
            throw new IllegalArgumentException("National ID cannot be empty.");
        }
        this.nationalId = nationalId.trim();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String accountType, Account account) {
        accounts.put(accountType, account);
    }
}

// ==========================================
// 6. MAIN APPLICATION CLASS
// ==========================================
public class SaccoManager {
    private static final Map<String, Member> membersDb = new HashMap<>();
    private static final Set<String> registeredNationalIds = new HashSet<>();
    private static final String MEMBERS_FILE = "members.csv";
    private static final String TRANSACTIONS_FILE = "transactions.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        loadData();

        int choice = 0;
        do {
            System.out.println("\n=== M-KOPO SACCO MANAGEMENT SYSTEM ===");
            System.out.println("1. Register New Member");
            System.out.println("2. Open an Account");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. View Member Details");
            System.out.println("6. Exit & Save");
            System.out.print("Enter choice: ");

            choice = readInt(scanner);

            switch (choice) {
                case 1 -> registerMember(scanner);
                case 2 -> openAccount(scanner);
                case 3 -> depositMoney(scanner);
                case 4 -> withdrawMoney(scanner);
                case 5 -> viewMemberDetails(scanner);
                case 6 -> {
                    saveData();
                    System.out.println("Exiting system. Data saved to " + MEMBERS_FILE + ". Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private static int readInt(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a whole number: ");
                scanner.nextLine(); // clear invalid token/line
            }
        }
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            try {
                double value = scanner.nextDouble();
                scanner.nextLine(); // consume newline
                return value;
            } catch (InputMismatchException e) {
                System.out.print("Invalid amount. Please enter a numeric value: ");
                scanner.nextLine(); // clear invalid token/line
            }
        }
    }

    private static void registerMember(Scanner scanner) {
        System.out.print("Enter Member ID (e.g., M-001): ");
        String id = scanner.nextLine().trim();

        if (id.isEmpty()) {
            System.out.println("Error: Member ID cannot be empty.");
            return;
        }
        if (membersDb.containsKey(id)) {
            System.out.println("Error: Member ID '" + id + "' already exists.");
            return;
        }

        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Error: Full name cannot be empty.");
            return;
        }

        System.out.print("Enter National ID: ");
        String nationalId = scanner.nextLine().trim();
        if (nationalId.isEmpty()) {
            System.out.println("Error: National ID cannot be empty.");
            return;
        }
        if (registeredNationalIds.contains(nationalId)) {
            System.out.println("Error: A member with National ID '" + nationalId + "' is already registered.");
            return;
        }

        Member newMember = new Member(id, name, nationalId);
        membersDb.put(id, newMember);
        registeredNationalIds.add(nationalId);
        logSystemEvent("Registered member " + id + " (" + name + ", Nat ID: " + nationalId + ")");
        System.out.println("Success: Member registered successfully!");
    }

    private static void openAccount(Scanner scanner) {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();

        Member member = membersDb.get(id);
        if (member == null) {
            System.out.println("Error: Member not found.");
            return;
        }

        System.out.println("1. Savings Account (5% interest)");
        System.out.println("2. Loan Account (12% interest)");
        System.out.print("Choose account type: ");
        int typeChoice = readInt(scanner);

        String accountType;
        Account newAccount;
        String accountNumber = id + "-" + (System.currentTimeMillis() % 10000);

        if (typeChoice == 1) {
            accountType = "Savings";
            if (member.getAccounts().containsKey(accountType)) {
                System.out.println("Error: Member already has a Savings account.");
                return;
            }
            newAccount = new SavingsAccount(accountNumber, 0.0);
        } else if (typeChoice == 2) {
            accountType = "Loan";
            if (member.getAccounts().containsKey(accountType)) {
                System.out.println("Error: Member already has a Loan account.");
                return;
            }
            newAccount = new LoanAccount(accountNumber, 0.0);
        } else {
            System.out.println("Invalid account type selection.");
            return;
        }

        member.addAccount(accountType, newAccount);
        logSystemEvent("Opened " + accountType + " account (" + accountNumber + ") for Member " + id);
        System.out.println("Success: " + accountType + " Account (" + accountNumber + ") opened.");
    }

    private static void depositMoney(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account == null) {
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = readDouble(scanner);
        account.deposit(amount);
        System.out.println("Current Balance: KSh " + String.format("%.2f", account.getBalance()));
    }

    private static void withdrawMoney(Scanner scanner) {
        Account account = findAccount(scanner);
        if (account == null) {
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = readDouble(scanner);

        try {
            account.withdraw(amount);
            System.out.println("Current Balance: KSh " + String.format("%.2f", account.getBalance()));
        } catch (InsufficientFundsException e) {
            System.out.println("TRANSACTION FAILED: " + e.getMessage());
        }
    }

    private static void viewMemberDetails(Scanner scanner) {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();

        Member member = membersDb.get(id);
        if (member == null) {
            System.out.println("Error: Member not found.");
            return;
        }

        System.out.println("\n--- MEMBER DETAILS ---");
        System.out.println("Member ID  : " + member.getMemberId());
        System.out.println("Name       : " + member.getName());
        System.out.println("National ID: " + member.getNationalId());

        Map<String, Account> accounts = member.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("Accounts   : None opened yet.");
        } else {
            for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                Account acc = entry.getValue();
                System.out.printf("Account Type: %s | Acc No: %s | Balance: KSh %.2f | Projected Interest: KSh %.2f%n",
                        entry.getKey(), acc.getAccountNumber(), acc.getBalance(), acc.calculateInterest());
            }
        }
    }

    private static Account findAccount(Scanner scanner) {
        System.out.print("Enter Member ID: ");
        String id = scanner.nextLine().trim();

        Member member = membersDb.get(id);
        if (member == null) {
            System.out.println("Error: Member not found.");
            return null;
        }

        System.out.print("Enter account type (Savings/Loan): ");
        String inputType = scanner.nextLine().trim();

        String normalizedType = null;
        for (String key : member.getAccounts().keySet()) {
            if (key.equalsIgnoreCase(inputType)) {
                normalizedType = key;
                break;
            }
        }

        if (normalizedType == null) {
            System.out.println("Error: Account type '" + inputType + "' not found for this member.");
            return null;
        }

        return member.getAccounts().get(normalizedType);
    }

    private static void logSystemEvent(String message) {
        try (FileWriter fw = new FileWriter(TRANSACTIONS_FILE, true);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println("SYSTEM | " + message);
        } catch (IOException e) {
            System.out.println("Error writing to " + TRANSACTIONS_FILE + ": " + e.getMessage());
        }
    }

    private static void loadData() {
        File file = new File(MEMBERS_FILE);
        if (!file.exists()) {
            System.out.println("No previous " + MEMBERS_FILE + " found. Starting fresh.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) {
                    continue;
                }
                String[] parts = line.split(",", -1);
                if (parts.length < 3) {
                    continue;
                }

                String memberId = parts[0].trim();
                String name = parts[1].trim();
                String nationalId = parts[2].trim();

                Member member = membersDb.computeIfAbsent(
                        memberId, k -> new Member(memberId, name, nationalId));
                registeredNationalIds.add(nationalId);

                // If account columns are present (MemberId,Name,NationalId,AccountType,AccountNumber,Balance)
                if (parts.length >= 6 && !parts[3].trim().isEmpty() && !parts[4].trim().isEmpty()) {
                    String accType = parts[3].trim();
                    String accNumber = parts[4].trim();
                    try {
                        double balance = Double.parseDouble(parts[5].trim());
                        Account account = accType.equalsIgnoreCase("Savings")
                                ? new SavingsAccount(accNumber, balance)
                                : new LoanAccount(accNumber, balance);
                        member.addAccount(accType, account);
                    } catch (NumberFormatException e) {
                        System.out.println("Skipping malformed balance for member " + memberId + ": " + parts[5]);
                    }
                }
            }
            System.out.println("Data loaded successfully from " + MEMBERS_FILE + ".");
        } catch (IOException e) {
            System.out.println("Error loading data from " + MEMBERS_FILE + ": " + e.getMessage());
        }
    }

    private static void saveData() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(MEMBERS_FILE))) {
            for (Member member : membersDb.values()) {
                Map<String, Account> accounts = member.getAccounts();
                if (accounts.isEmpty()) {
                    // Preserve members even if they haven't opened an account yet
                    pw.println(member.getMemberId() + ","
                            + member.getName() + ","
                            + member.getNationalId() + ",,,0.0");
                } else {
                    for (Map.Entry<String, Account> entry : accounts.entrySet()) {
                        Account acc = entry.getValue();
                        pw.println(member.getMemberId() + ","
                                + member.getName() + ","
                                + member.getNationalId() + ","
                                + entry.getKey() + ","
                                + acc.getAccountNumber() + ","
                                + acc.getBalance());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data to " + MEMBERS_FILE + ": " + e.getMessage());
        }
    }
}1
