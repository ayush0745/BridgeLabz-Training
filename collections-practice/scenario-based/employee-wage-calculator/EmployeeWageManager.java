import java.util.ArrayList;

public class EmployeeWageManager implements EmployeeWageService {

    private static final int ABSENT = 0;
    private static final int PART_TIME = 1;
    private static final int FULL_TIME = 2;

    private ArrayList<Company> companyList;

    public EmployeeWageManager() {
        companyList = new ArrayList<>();
    }

    @Override
    public void addCompany(String name, int wagePerHour, int workingDays, int maxHours) {
        Company company = new Company(name, wagePerHour, workingDays, maxHours);
        companyList.add(company);
    }

    private void computeWageForCompany(Company company) {

        int totalHours = 0;
        int totalDays = 0;

        while (totalHours <= company.maxHoursPerMonth &&
                totalDays < company.workingDaysPerMonth) {

            totalDays++;

            int empType = (int) (Math.random() * 3);
            int empHours;

            switch (empType) {
                case PART_TIME:
                    empHours = 4;
                    break;
                case FULL_TIME:
                    empHours = 8;
                    break;
                default:
                    empHours = 0;
            }

            totalHours += empHours;
            int dailyWage = empHours * company.wagePerHour;
            company.dailyWages.add(dailyWage);

            System.out.println(company.name + " Day " + totalDays +
                    " Hours: " + empHours + " Wage: " + dailyWage);
        }

        int totalWage = totalHours * company.wagePerHour;
        company.setTotalWage(totalWage);

        System.out.println("Total Wage for " + company.name + " = " + totalWage);
        System.out.println("------------------------------------");
    }

    @Override
    public void computeWages() {
        for (Company company : companyList) {
            computeWageForCompany(company);
        }
    }

    @Override
    public int getTotalWage(String companyName) {
        for (Company company : companyList) {
            if (company.name.equals(companyName)) {
                return company.totalWage;
            }
        }
        return -1;
    }
}
