import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter class name: ");
            String className = sc.nextLine();

            Class<?> cls = Class.forName(className);

            System.out.println("\nMethods:");
            for (Method m : cls.getDeclaredMethods()) {
                System.out.println(m);
            }

            System.out.println("\nFields:");
            for (Field f : cls.getDeclaredFields()) {
                System.out.println(f);
            }

            System.out.println("\nConstructors:");
            for (Constructor<?> c : cls.getDeclaredConstructors()) {
                System.out.println(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
