abstract class Patient {
    protected int patientId;
    protected String name;
    protected int age;

    // Encapsulated sensitive data
    private String diagnosis;
    private String medicalHistory;

    public Patient(int patientId, String name, int age, String diagnosis, String medicalHistory) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
        this.medicalHistory = medicalHistory;
    }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Encapsulation using getters/setters
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    protected String getMedicalHistory() {
        return medicalHistory;
    }
}
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyCharge;
    private String record;

    public InPatient(int patientId, String name, int age,
                     String diagnosis, String medicalHistory,
                     int daysAdmitted, double dailyCharge) {

        super(patientId, name, age, diagnosis, medicalHistory);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("InPatient Record: " + record);
    }
}
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private String record;

    public OutPatient(int patientId, String name, int age,
                      String diagnosis, String medicalHistory,
                      double consultationFee) {

        super(patientId, name, age, diagnosis, medicalHistory);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        this.record = record;
    }

    @Override
    public void viewRecords() {
        System.out.println("OutPatient Record: " + record);
    }
}
public class HospitalPatientManagement {
    public static void main(String[] args) {

        Patient p1 = new InPatient(101, "Rahul", 45,
                "Surgery", "Diabetes", 5, 3000);

        Patient p2 = new OutPatient(102, "Anita", 30,
                "Fever", "None", 800);

        displayBill(p1);
        displayBill(p2);
    }

    public static void displayBill(Patient patient) {
        patient.getPatientDetails();
        System.out.println("Total Bill: ₹" + patient.calculateBill());
        System.out.println("--------------------");
    }
}
