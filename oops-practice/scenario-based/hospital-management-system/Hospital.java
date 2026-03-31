import java.util.*;

public class Hospital implements HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    @Override
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added: " + patient.name);
    }

    @Override
    public void removePatient(int patientId) {
        patients.removeIf(p -> p.id == patientId);
    }

    @Override
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor added: Dr. " + doctor.name);
    }

    @Override
    public void bookAppointment(Appointment appointment)
            throws AppointmentNotAvailableException {

        for (Appointment a : appointments) {
            if (a.getDoctor().id == appointment.getDoctor().id) {
                throw new AppointmentNotAvailableException(
                        "Doctor not available on this date"
                );
            }
        }
        appointments.add(appointment);
        System.out.println("Appointment booked");
    }

    @Override
    public void cancelAppointment(Appointment appointment) {
        appointments.remove(appointment);
        System.out.println("Appointment cancelled");
    }
}
