class Developer extends Employee{
	public Developer(String name, double salary) {
		super(name, salary);
	}
	@Override
	public double calculateBonus() {
		 return getSalary() > 50000 ? getSalary() * 0.05 : 0.0;
	}
}