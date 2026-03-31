import java.io.*;

public class ReadUsingInputStreamReader {
    public static void main(String[] args) {
        String fileName = "input.txt";

        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

            br.close(); 

        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding not supported");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
