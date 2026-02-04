import java.util.List;

public class PatientIDPrinting {

    public static void main(String[] args) {

        List<Integer> patientIds = List.of(101, 102, 103, 104, 105);

        // Print all patient IDs using method reference
        patientIds.forEach(System.out::println);
    }
}
