// This program demonstrates invoking a private method using Java reflection.
import java.lang.reflect.Method;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class CalculatorReflection {
    public static void main(String[] args) throws Exception {
        Calculator calculator = new Calculator();

        Class<?> calcClass = calculator.getClass();
        Method multiplyMethod = calcClass.getDeclaredMethod("multiply", int.class, int.class);
        multiplyMethod.setAccessible(true);

        Object result = multiplyMethod.invoke(calculator, 6, 7);
        System.out.println("Result of private multiply(6, 7): " + result);
    }
}


