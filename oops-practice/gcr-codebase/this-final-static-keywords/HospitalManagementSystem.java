class Patient {

    // Static variable shared among all patients
    private static String hospitalName = "City Hospital";
    private static int totalPatients = 0;

    // Final variable for unique patient ID
    private final String patientID;

    private String name;
    private int age;
    private String ailment;

    // Constructor using 'this' keyword
    public Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // Static method to display total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details using instanceof
    public void displayPatientDetails() {
        if (this instanceof Patient) {
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + patientID);
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Ailment: " + ailment);
        } else {
            System.out.println("Invalid patient instance.");
        }
    }

    // Main method
    public static void main(String[] args) {

        Patient p1 = new Patient("P001", "Lathika", 30, "Flu");
        Patient p2 = new Patient("P002", "Lidiya", 45, "Fracture");

        Patient.getTotalPatients();

        p1.displayPatientDetails();
        p2.displayPatientDetails();
    }
}
