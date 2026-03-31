public class Doctor extends Person {

    private String specialization;

    public Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    // Polymorphic behavior
    public double calculateConsultationFee() {
        if (specialization.equalsIgnoreCase("Cardiology")) {
            return 1000.0;
        } else if (specialization.equalsIgnoreCase("Neurology")) {
            return 1200.0;
        } else {
            return 500.0; // General physician
        }
    }

    public String getSpecialization() {
        return specialization;
    }
}
