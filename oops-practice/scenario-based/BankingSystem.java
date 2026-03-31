import java.util.*;

// -------------------- Custom Exception --------------------
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// -------------------- Abstract Account --------------------
abstract class Account {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactions = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        transactions.add("Account created with balance: " + balance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactions.add("Withdrawn: " + amount);
    }

    public void printTransactions() {
        System.out.println("Transaction History:");
        for (String t : transactions) {
            System.out.println("- " + t);
        }
    }

    public abstract double calculateInterest();
}

// -------------------- Savings Account --------------------
class SavingsAccount extends Account {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}

// -------------------- Current Account --------------------
class CurrentAccount extends Account {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.01; // 1% interest
    }
}

// -------------------- Bank Service Interface --------------------
interface BankService {
    void createAccount();
    void checkBalance();
    void deposit();
    void withdraw();
    void transfer();
    void showTransactions();
}

// -------------------- Bank Implementation --------------------
class BankServiceImpl implements BankService {

    private Map<Integer, Account> accounts = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    @Override
    public void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Account Type (1-Savings / 2-Current): ");
        int type = sc.nextInt();

        Account acc;
        if (type == 1) {
            acc = new SavingsAccount(accNo, name, balance);
        } else {
            acc = new CurrentAccount(accNo, name, balance);
        }

        accounts.put(accNo, acc);
        System.out.println("Account Created Successfully!");
    }

    @Override
    public void checkBalance() {
        Account acc = getAccount();
        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
            System.out.println("Interest: " + acc.calculateInterest());
        }
    }

    @Override
    public void deposit() {
        Account acc = getAccount();
        if (acc != null) {
            System.out.print("Enter amount to deposit: ");
            acc.deposit(sc.nextDouble());
            System.out.println("Deposit Successful!");
        }
    }

    @Override
    public void withdraw() {
        Account acc = getAccount();
        if (acc != null) {
            System.out.print("Enter amount to withdraw: ");
            try {
                acc.withdraw(sc.nextDouble());
                System.out.println("Withdrawal Successful!");
            } catch (InsufficientBalanceException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void transfer() {
        System.out.print("From Account Number: ");
        int fromAcc = sc.nextInt();

        System.out.print("To Account Number: ");
        int toAcc = sc.nextInt();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();

        Account sender = accounts.get(fromAcc);
        Account receiver = accounts.get(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number!");
            return;
        }

        try {
            sender.withdraw(amount);
            receiver.deposit(amount);
            sender.transactions.add("Transferred " + amount + " to " + toAcc);
            receiver.transactions.add("Received " + amount + " from " + fromAcc);
            System.out.println("Transfer Successful!");
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void showTransactions() {
        Account acc = getAccount();
        if (acc != null) {
            acc.printTransactions();
        }
    }

    private Account getAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();
        Account acc = accounts.get(accNo);
        if (acc == null) {
            System.out.println("Account not found!");
        }
        return acc;
    }
}

// -------------------- Main Class --------------------
public class BankingSystem {
    public static void main(String[] args) {

        BankService bank = new BankServiceImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Online Banking System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Fund Transfer");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bank.createAccount();
                case 2 -> bank.checkBalance();
                case 3 -> bank.deposit();
                case 4 -> bank.withdraw();
                case 5 -> bank.transfer();
                case 6 -> bank.showTransactions();
                case 7 -> {
                    System.out.println("Thank you!");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
