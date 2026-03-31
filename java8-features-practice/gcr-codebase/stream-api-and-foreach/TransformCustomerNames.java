import java.util.*;

public class TransformCustomerNames {

    public static void main(String[] args) {

        List<String> customerNames = Arrays.asList(
            "Rahul",
            "Sneha",
            "amit",
            "Priya",
            "karan"
        );

        customerNames.stream()
                     // convert names to uppercase
                     .map(String::toUpperCase)

                     // sort alphabetically
                     .sorted()

                     // display result
                     .forEach(System.out::println);
    }
}
