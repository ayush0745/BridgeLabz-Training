public class HospitalApp {
    public static void main(String[] args) {

        HospitalService service = new Hospital();

        Patient p1 = new Patient(1, "Ayush", 22);
        p1.addMedicalRecord("High BP");

        Doctor d1 = new Doctor(101, "Sharma", "General");
        Doctor d2 = new Doctor(102, "Mehta", "Cardiology");

        service.addPatient(p1);
        service.addDoctor(d1);
        service.addDoctor(d2);

        Appointment ap1 = new Appointment(p1, d2, "15-Feb-2026");

        try {
            service.bookAppointment(ap1);
            System.out.println("Consultation Fee: ₹"
                    + d2.calculateConsultationFee());
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        p1.viewMedicalHistory();
    }
}
