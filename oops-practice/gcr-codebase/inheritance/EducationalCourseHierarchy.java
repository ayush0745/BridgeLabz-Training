class Course {
	private String courseName;
	private int duration;

	Course(String courseName, int duration) {
		this.courseName = courseName;
		this.duration = duration;
	}

	void displayInfo() {
		System.out.println("Course Name: " + courseName);
		System.out.println("Duration: " + duration + " hrs");
	}
}

class OnlineCourse extends Course {
	private String platform;
	private boolean isRecorded;

	OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
		super(courseName, duration);
		this.platform = platform;
		this.isRecorded = isRecorded;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Platform: " + platform);
		System.out.println("Recorder? " + (isRecorded ? "Yes" : "No"));
	}
}

class PaidOnlineCourse extends OnlineCourse {
	private double fee;
	private double discount;

	PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee,
			double discount) {
		super(courseName, duration, platform, isRecorded);
		this.fee = fee;
		this.discount = discount;
	}

	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("Fees: " + fee);
		System.out.println("Discount: " + discount + "%");
		System.out.println("Total fees: " + calculateFees());
	}

	private double calculateFees() {
		return (fee - (discount * fee) / 100);
	}
}

public class EducationalCourseHeirarchy {

	public static void main(String[] args) {
		
		Course c1 = new Course("science", 100);
		Course c2 = new OnlineCourse("java", 80, "You Tube", true);
		Course c3 = new PaidOnlineCourse("css", 100, "GFG", true, 1000, 50);
		c1.displayInfo();
		System.out.println();
		c2.displayInfo();
		System.out.println();
		c3.displayInfo();
		System.out.println();
	}

}