class Request {
	private final String accountNumber;
	private double balance;

	Request(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public double getBalance() {
		return balance;
	}
}