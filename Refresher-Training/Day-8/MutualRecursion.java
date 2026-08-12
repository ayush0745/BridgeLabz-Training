public class MutualRecursion {

    public static boolean isEven(int n) {
        if (n == 0) {
            return true;
        }

        return isOdd(n - 1);
    }

    public static boolean isOdd(int n) {
        if (n == 0) {
            return false;
        }

        return isEven(n - 1);
    }

    public static void main(String[] args) {

        for (int n = 0; n <= 10; n++) {
            System.out.println(
                n + " -> Even: " + isEven(n) +
                ", Odd: " + isOdd(n)
            );
        }

        System.out.println("\nisOdd(7) = " + isOdd(7));
    }
}