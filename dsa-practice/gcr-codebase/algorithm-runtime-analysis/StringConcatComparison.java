public class StringConcatComparison {

    public static void main(String[] args) {

        int N = 100000; // change to 1000, 10000, or 1_000_000

        // Using String
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < N; i++) {
            s = s + "a";
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) / 1_000_000.0 + " ms");

        // Using StringBuilder
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1_000_000.0 + " ms");

        // Using StringBuffer
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sbf.append("a");
        }
        end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000.0 + " ms");
    }
}
