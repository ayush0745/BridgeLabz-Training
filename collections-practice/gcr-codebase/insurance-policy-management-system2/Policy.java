import java.time.LocalDate;

class Policy implements Comparable<Policy> {
	private final int policyNumber;
	private String holderName;
	private String expiryDate;
	private String type;
	private double premiumAmount;

	Policy(int policyNumber, String holderName, String exprityDate, String type, double premimumAmount) {
		this.policyNumber = policyNumber;
		this.holderName = holderName;
		this.expiryDate = exprityDate;
		this.type = type;
		this.premiumAmount = premimumAmount;
	}

	public int getPolicyNumber() {
		return policyNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public String getType() {
		return type;
	}

	public double getPremiumAmount() {
		return premiumAmount;
	}

	@Override
	public int compareTo(Policy other) {
		LocalDate d1 = LocalDate.parse(this.expiryDate);
		LocalDate d2 = LocalDate.parse(other.expiryDate);

		int result = d1.compareTo(d2);

		return result != 0 ? result : Integer.compare(this.policyNumber, other.policyNumber);
	}

	@Override
	public String toString() {
		return "Policy: " + policyNumber + ", Name: " + holderName + ", expiry date: " + expiryDate + ", Policy Type: "
				+ type + ", Premium Amount: " + premiumAmount;
	}

}