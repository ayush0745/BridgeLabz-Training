abstract class Vehicle{
	private String vehicleNumber;
	private String type;
	private double rentalRate;
	
	Vehicle( String vehicleNumber, String type, double rentalRate){
		this.rentalRate = rentalRate;
		this.type = type;
		this.vehicleNumber = vehicleNumber;
		
	}
	
	String getVehicleNumber() {
		return vehicleNumber;
	}
	double getRentalRate() {
		return rentalRate;
	}
	String getType() {
		return type;
	}
	abstract double calculateRentalCost(int days);
	
	
}
interface Insurable{
	abstract int calculateInsurance();
	
	abstract void getInsuranceDetails();
	
}
class Car extends Vehicle implements Insurable{
	Car( String vehicleNumber, String type, double rentalRate){
		super( vehicleNumber, type, rentalRate);
		
	}
	public double calculateRentalCost( int days ) {
		return getRentalRate() * days;
	}
	public int calculateInsurance() {
		return 1000;
	}
	public void getInsuranceDetails() {
		System.out.println("vehicleNumber :" + getVehicleNumber());
		System.out.println("vehicleType :" + getType());
		System.out.println("details :" + calculateInsurance());
	}
	
}
class Bike extends Vehicle implements Insurable{
	Bike( String vehicleNumber, String type, double rentalRate){
		super( vehicleNumber, type, rentalRate);
		
	}
	public double calculateRentalCost( int days ) {
		return getRentalRate() * days;
	}
	public int calculateInsurance() {
		return 500;
	}
	public void getInsuranceDetails() {
		System.out.println("vehicleNumber :" + getVehicleNumber());
		System.out.println("vehicleType :" + getType());
		System.out.println("details :" + calculateInsurance());
	}
	
}
class Truck extends Vehicle implements Insurable{
	Truck( String vehicleNumber, String type, double rentalRate){
		super( vehicleNumber, type, rentalRate);
		
	}
	public double calculateRentalCost( int days ) {
		return getRentalRate() * days;
	}
	public int calculateInsurance() {
		return 1330;
	}
	public void getInsuranceDetails() {
		System.out.println("vehicleNumber :" + getVehicleNumber());
		System.out.println("vehicleType :" + getType());
		System.out.println("details :" + calculateInsurance());
	}
	
}
class VehicleRentalSystem{
	public static void main(String[] args) {
		Car car = new Car("hh4t", "a", 5 );
		Bike bike = new Bike("up76", "aa", 7);
		Truck truck = new Truck("up76","aaa", 8);
		
		car.getInsuranceDetails();
		bike.getInsuranceDetails();
		truck.getInsuranceDetails();
	}
}