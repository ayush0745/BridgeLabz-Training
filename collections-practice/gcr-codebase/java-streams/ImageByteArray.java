import java.io.*;

public class ImageByteArray {

    public static void main(String[] args) {

        String inputImage = "original.jpg";
        String outputImage = "copy.jpg";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // 🔹 Read image into ByteArrayOutputStream
            fis = new FileInputStream(inputImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data);
            }

            byte[] imageBytes = baos.toByteArray();

            // 🔹 Write byte array back to image file
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            fos = new FileOutputStream(outputImage);

            while ((data = bais.read()) != -1) {
                fos.write(data);
            }

            System.out.println("Image copied successfully using ByteArray streams.");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing streams.");
            }
        }
    }
}
