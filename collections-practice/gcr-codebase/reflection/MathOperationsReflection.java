// This program lets the user invoke different MathOperations methods dynamically using reflection.
import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class MathOperationsReflection {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        MathOperations ops = new MathOperations();

        System.out.print("Enter method name (add, subtract, multiply): ");
        String methodName = scanner.nextLine();

        System.out.print("Enter first integer: ");
        int a = scanner.nextInt();
        System.out.print("Enter second integer: ");
        int b = scanner.nextInt();

        Class<?> cls = ops.getClass();
        Method method = cls.getMethod(methodName, int.class, int.class);
        Object result = method.invoke(ops, a, b);

        System.out.println("Result: " + result);
        scanner.close();
    }
}


