import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder s = new StringBuilder(scanner.next());
        System.out.println(s.reverse());

        scanner.close();
    }
}
