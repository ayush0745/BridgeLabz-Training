public class EmployeeWageMain {

    public static void main(String[] args) {

        System.out.println("Welcome to Employee Wage Computation Program");

        EmployeeWageService wageService = new EmployeeWageManager();

        wageService.addCompany("TCS", 20, 20, 100);
        wageService.addCompany("Infosys", 25, 22, 120);
        wageService.addCompany("Wipro", 18, 20, 90);

        wageService.computeWages();

        System.out.println("Queried Total Wage of TCS: " +
                wageService.getTotalWage("TCS"));
    }
}
