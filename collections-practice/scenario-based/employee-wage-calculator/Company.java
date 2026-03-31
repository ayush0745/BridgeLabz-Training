import java.util.ArrayList;

public class Company {

    public final String name;
    public final int wagePerHour;
    public final int workingDaysPerMonth;
    public final int maxHoursPerMonth;

    public int totalWage;
    public ArrayList<Integer> dailyWages;

    public Company(String name, int wagePerHour, int workingDaysPerMonth, int maxHoursPerMonth) {
        this.name = name;
        this.wagePerHour = wagePerHour;
        this.workingDaysPerMonth = workingDaysPerMonth;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.dailyWages = new ArrayList<>();
    }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public String toString() {
        return "Company: " + name + " Total Wage: " + totalWage;
    }
}
