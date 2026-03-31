import java.time.LocalDate;
import java.time.LocalDateTime;

class BankAccount {
	double initialBalance = 10000;

	public boolean withdraw(double amount) {
		if (amount > initialBalance) {
			return false;
		}
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		initialBalance -= amount;
		return true;

	}
}

class Transaction implements Runnable {

	String name;
	BankAccount account;
	int amount;

	public Transaction(BankAccount account, String name, int amount) {
		// TODO Auto-generated constructor stub
		this.account = account;
		this.name = name;
		this.amount = amount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " Attempting to withdraw " + amount + " at " + LocalDateTime.now());
		boolean success = account.withdraw(amount);
		if (success) {
			System.out.println(
					"Transaction successful: " + name + ", Amount: " + amount + ", Balance: " + account.initialBalance);
		} else {
			System.out.println("Transaction failed: " + name + ", Amount: " + amount + ", Insufficient balance");
		}
	}
}

public class BankingSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount account = new BankAccount();

		Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "Customer-1");
		Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "Customer-2");
		Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "Customer-3");
		Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "Customer-4");
		Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "Customer-5");

		System.out.println("Thread states before execution:");
		System.out.println(t1.getName() + " : " + t1.getState());
		System.out.println(t2.getName() + " : " + t2.getState());
		System.out.println(t3.getName() + " : " + t3.getState());
		System.out.println(t4.getName() + " : " + t4.getState());
		System.out.println(t5.getName() + " : " + t5.getState());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}