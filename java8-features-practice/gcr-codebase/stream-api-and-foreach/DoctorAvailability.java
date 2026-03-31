import java.util.*;

public class DoctorAvailability {

    // Doctor class
    static class Doctor {
        String name;
        String specialty;
        boolean availableOnWeekend;

        Doctor(String name, String specialty, boolean availableOnWeekend) {
            this.name = name;
            this.specialty = specialty;
            this.availableOnWeekend = availableOnWeekend;
        }

        @Override
        public String toString() {
            return name + " - " + specialty +
                   " (Weekend Available: " + availableOnWeekend + ")";
        }
    }

    // Main method
    public static void main(String[] args) {

        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Sharma", "Cardiology", true),
            new Doctor("Dr. Mehta", "Orthopedics", false),
            new Doctor("Dr. Khan", "Neurology", true),
            new Doctor("Dr. Patel", "Dermatology", true),
            new Doctor("Dr. Roy", "Pediatrics", false)
        );

        // Stream processing
        doctors.stream()
               // filter doctors available on weekends
               .filter(d -> d.availableOnWeekend)

               // sort by specialty (alphabetical order)
               .sorted(Comparator.comparing(d -> d.specialty))

               // display result
               .forEach(System.out::println);
    }
}
