import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String fileName = "output.txt";

        try {
            // Reading from console
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            // Writing to file
            FileWriter fw = new FileWriter(fileName, true); // true for append mode
            BufferedWriter bw = new BufferedWriter(fw);

            String inputLine;
            System.out.println("Enter text (type 'exit' to quit):");

            while (true) {
                inputLine = br.readLine();

                if ("exit".equalsIgnoreCase(inputLine)) {
                    break;
                }

                bw.write(inputLine);
                bw.newLine(); // ensure each input is on a new line
            }

            // Close streams
            bw.close();
            fw.close();
            br.close();
            isr.close();

            System.out.println("Input saved to " + fileName);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
