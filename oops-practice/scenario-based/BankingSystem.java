import java.util.*;

// ======================= CUSTOM EXCEPTION =======================
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// ======================= BANK SERVICE (ABSTRACTION) =======================
interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
    double getBalance();
}

// ======================= ACCOUNT (BASE CLASS) =======================
abstract class Account implements BankService {
    protected int accountNumber;
    protected String holderName;
    protected double balance;
    protected List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // synchronized for thread safety
    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
    }

    public synchronized void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn: ₹" + amount);
    }

    public synchronized double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}

// ======================= SAVINGS ACCOUNT =======================
class SavingsAccount extends Account {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Polymorphism
    public double calculateInterest() {
        return balance * 0.04;
    }
}

// ======================= CURRENT ACCOUNT =======================
class CurrentAccount extends Account {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    // Polymorphism
    public double calculateInterest() {
        return balance * 0.01;
    }
}

// ======================= FUND TRANSFER TASK (MULTITHREADING) =======================
class TransferTask implements Runnable {
    private Account from;
    private Account to;
    private double amount;

    public TransferTask(Account from, Account to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void run() {
        synchronized (from) {
            synchronized (to) {
                try {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println(Thread.currentThread().getName() +
                            " transferred ₹" + amount);
                } catch (InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

// ======================= MAIN APPLICATION =======================
public class BankingSystem {
    public static void main(String[] args) {

        Account savings = new SavingsAccount(101, "Ayush", 10000);
        Account current = new CurrentAccount(201, "Company", 5000);

        System.out.println("Initial Savings Balance: ₹" + savings.getBalance());
        System.out.println("Initial Current Balance: ₹" + current.getBalance());

        // Multithreading: concurrent transfers
        Thread t1 = new Thread(new TransferTask(savings, current, 2000), "Thread-1");
        Thread t2 = new Thread(new TransferTask(savings, current, 3000), "Thread-2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nFinal Savings Balance: ₹" + savings.getBalance());
        System.out.println("Final Current Balance: ₹" + current.getBalance());

        System.out.println("\nSavings Interest: ₹" + savings.calculateInterest());
        System.out.println("Current Interest: ₹" + current.calculateInterest());

        System.out.println("\nSavings Transaction History:");
        for (String tx : savings.getTransactionHistory()) {
            System.out.println(tx);
        }
    }
}
