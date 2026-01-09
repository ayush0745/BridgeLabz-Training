import java.util.*;

/* ================= INTERFACE ================= */
interface IPayable {
    double calculateBill();
}

/* ================= PATIENT (ABSTRACT CLASS) ================= */
abstract class Patient {
    private int patientId;
    private String name;
    private int age;
    private Doctor doctor;

    public Patient(int patientId, String name, int age, Doctor doctor) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.doctor = doctor;
    }

    // Encapsulation (Getters)
    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    // Polymorphism
    public abstract void displayInfo();
}

/* ================= INPATIENT ================= */
class InPatient extends Patient implements IPayable {
    private int daysAdmitted;
    private double dailyCharge;

    public InPatient(int patientId, String name, int age, Doctor doctor,
                     int daysAdmitted, double dailyCharge) {
        super(patientId, name, age, doctor);
        this.daysAdmitted = daysAdmitted;
        this.dailyCharge = dailyCharge;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyCharge;
    }

    @Override
    public void displayInfo() {
        System.out.println("In-Patient ID: " + getPatientId());
        System.out.println("Name: " + getName());
        System.out.println("Doctor: " + getDoctor().getName());
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("----------------------------");
    }
}

/* ================= OUTPATIENT ================= */
class OutPatient extends Patient implements IPayable {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, Doctor doctor,
                      double consultationFee) {
        super(patientId, name, age, doctor);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void displayInfo() {
        System.out.println("Out-Patient ID: " + getPatientId());
        System.out.println("Name: " + getName());
        System.out.println("Doctor: " + getDoctor().getName());
        System.out.println("Total Bill: ₹" + calculateBill());
        System.out.println("----------------------------");
    }
}

/* ================= DOCTOR ================= */
class Doctor {
    private int doctorId;
    private String name;
    private String specialization;

    public Doctor(int doctorId, String name, String specialization) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }
}

/* ================= BILL ================= */
class Bill {
    public static void generateBill(IPayable payable) {
        System.out.println("Bill Amount: ₹" + payable.calculateBill());
    }
}

/* ================= MAIN SYSTEM ================= */
public class HospitalPatientManagementSystem {

    private static List<Patient> patients = new ArrayList<>();

    public static void main(String[] args) {

        Doctor doc1 = new Doctor(1, "Dr. Sharma", "Cardiology");
        Doctor doc2 = new Doctor(2, "Dr. Mehta", "Orthopedics");

        // CREATE
        patients.add(new InPatient(101, "Ayush", 22, doc1, 5, 2000));
        patients.add(new OutPatient(102, "Rohit", 30, doc2, 800));

        // READ
        displayAllPatients();

        // UPDATE (Example)
        patients.set(1, new OutPatient(102, "Rohit Verma", 30, doc2, 1000));

        // DELETE
        deletePatient(101);

        // FINAL LIST
        displayAllPatients();
    }

    public static void displayAllPatients() {
        for (Patient p : patients) {
            p.displayInfo(); // Polymorphism
        }
    }

    public static void deletePatient(int id) {
        patients.removeIf(p -> p.getPatientId() == id);
    }
}
