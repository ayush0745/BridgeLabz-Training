public class PowerFunction {

    static int naiveCalls = 0;
    static int fastCalls = 0;

    
    public static long power(long x, int n) {
        naiveCalls++;

        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

        public static long fastPower(long x, int n) {
        fastCalls++;

        if (n == 0) {
            return 1;
        }

        long half = fastPower(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {


        naiveCalls = 0;
        fastCalls = 0;

        long result1 = power(2, 10);
        long fastResult1 = fastPower(2, 10);

        System.out.println("2^10:");
        System.out.println("Naive Result: " + result1);
        System.out.println("Naive Calls: " + naiveCalls);

        System.out.println("Fast Result: " + fastResult1);
        System.out.println("Fast Calls: " + fastCalls);

        System.out.println();

        
        naiveCalls = 0;
        fastCalls = 0;

        long result2 = power(3, 13);
        long fastResult2 = fastPower(3, 13);

        System.out.println("3^13:");
        System.out.println("Naive Result: " + result2);
        System.out.println("Naive Calls: " + naiveCalls);

        System.out.println("Fast Result: " + fastResult2);
        System.out.println("Fast Calls: " + fastCalls);
    }
}