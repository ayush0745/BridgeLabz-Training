import java.io.*;

public class ComparisonStream {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {

        String sourceFile = "destination.txt"; // e.g., 100MB file
        String unbufferedDest = "destination.txt";
        String bufferedDest = "destination.txt";

        copyUsingUnbufferedStreams(sourceFile, unbufferedDest);
        copyUsingBufferedStreams(sourceFile, bufferedDest);
    }

    // 🔹 Unbuffered File Copy
    public static void copyUsingUnbufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(src);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error (Unbuffered): " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " +
                (endTime - startTime) / 1_000_000 + " ms");
    }

    // 🔹 Buffered File Copy
    public static void copyUsingBufferedStreams(String src, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.out.println("Error (Buffered): " + e.getMessage());
            return;
        }

        long endTime = System.nanoTime();
        System.out.println("Buffered Stream Time: " +
                (endTime - startTime) / 1_000_000 + " ms");
    }
}
