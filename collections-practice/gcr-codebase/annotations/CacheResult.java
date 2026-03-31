import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

// Define the custom caching annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

// Service class with an expensive computation
class MathService {

    @CacheResult
    public int expensiveCalculation(int number) {
        System.out.println("Performing expensive calculation...");
        try {
            Thread.sleep(2000); // Simulate heavy computation
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return number * number;
    }
}

// Cache handler using reflection
class CacheExecutor {

    private static final Map<String, Object> cache = new HashMap<>();

    public static Object execute(Object obj, String methodName, Object... args) throws Exception {
        Class<?> clazz = obj.getClass();

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {

                String cacheKey = methodName + "_" + args[0];

                if (method.isAnnotationPresent(CacheResult.class)) {

                    if (cache.containsKey(cacheKey)) {
                        System.out.println("Returning cached result...");
                        return cache.get(cacheKey);
                    }

                    Object result = method.invoke(obj, args);
                    cache.put(cacheKey, result);
                    return result;
                }

                return method.invoke(obj, args);
            }
        }
        throw new NoSuchMethodException("Method not found");
    }
}

// Test class
public class CacheResult {
    public static void main(String[] args) throws Exception {

        MathService service = new MathService();

        System.out.println("First call:");
        System.out.println(CacheExecutor.execute(service, "expensiveCalculation", 5));

        System.out.println("\nSecond call with same input:");
        System.out.println(CacheExecutor.execute(service, "expensiveCalculation", 5));

        System.out.println("\nThird call with different input:");
        System.out.println(CacheExecutor.execute(service, "expensiveCalculation", 7));
    }
}
