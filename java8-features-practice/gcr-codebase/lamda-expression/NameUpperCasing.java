import java.util.List;

public class NameUppercasing {

    public static void main(String[] args) {

        List<String> employeeNames = List.of(
                "Ayush",
                "Riya",
                "Karan",
                "Neha"
        );

        employeeNames.stream()
                     .map(String::toUpperCase)
                     .forEach(System.out::println);
    }
}
