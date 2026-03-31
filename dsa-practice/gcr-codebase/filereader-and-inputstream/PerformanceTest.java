import java.io.*;

public class PerformanceTest {
    public static void main(String[] args) {
        String text = "hello";
        int iterations = 1_000_000;

        // StringBuilder
        long startBuilder = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endBuilder = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (endBuilder - startBuilder) + " ms");

        // StringBuffer
        long startBuffer = System.currentTimeMillis();
        StringBuffer sbuf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuf.append(text);
        }
        long endBuffer = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (endBuffer - startBuffer) + " ms");

        String fileName = "largefile.txt";

        try {
            // FileReader timing
            long startFR = System.currentTimeMillis();
            FileReader fr = new FileReader(fileName);
            BufferedReader brFr = new BufferedReader(fr);
            long wordCountFR = 0;
            String line;
            while ((line = brFr.readLine()) != null) {
                wordCountFR += line.split("\\s+").length;
            }
            brFr.close();
            fr.close();
            long endFR = System.currentTimeMillis();
            System.out.println("FileReader word count: " + wordCountFR + ", Time: " + (endFR - startFR) + " ms");

            // InputStreamReader timing
            long startISR = System.currentTimeMillis();
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader brIsr = new BufferedReader(isr);
            long wordCountISR = 0;
            while ((line = brIsr.readLine()) != null) {
                wordCountISR += line.split("\\s+").length;
            }
            brIsr.close();
            isr.close();
            fis.close();
            long endISR = System.currentTimeMillis();
            System.out.println("InputStreamReader word count: " + wordCountISR + ", Time: " + (endISR - startISR) + " ms");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
