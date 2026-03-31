abstract class Employee{
	private final String name;
	private final double salary;
	
	Employee(String name, double salary){
		this.name = name;
		this.salary = salary;
	}
	public double getSalary() {
		return salary;
	}
	public String getName() {
		return name;
	}
	public abstract double calculateBonus();
}