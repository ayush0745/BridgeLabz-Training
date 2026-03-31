import java.util.ArrayList;

public class SuppressWarning {

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public static void main(String[] args) {
        // Creating a raw ArrayList (without generics)
        ArrayList list = new ArrayList();

        // Adding elements of different types
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        // Retrieving elements requires casting
        String str = (String) list.get(0);
        int num = (Integer) list.get(1);
        double pi = (Double) list.get(2);

        System.out.println(str); // Hello
        System.out.println(num); // 42
        System.out.println(pi);  // 3.14
    }
}
