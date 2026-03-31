import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadLargeCSV {

    private static final int CHUNK_SIZE = 100;

    public static void main(String[] args) {

        String filePath = "large.csv";
        String line;
        int totalRecordsProcessed = 0;

        List<String> chunk = new ArrayList<>(CHUNK_SIZE);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            // Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {
                chunk.add(line);

                if (chunk.size() == CHUNK_SIZE) {
                    processChunk(chunk);
                    totalRecordsProcessed += chunk.size();
                    System.out.println("Records processed so far: " + totalRecordsProcessed);
                    chunk.clear();
                }
            }

            // Process remaining records
            if (!chunk.isEmpty()) {
                processChunk(chunk);
                totalRecordsProcessed += chunk.size();
                System.out.println("Records processed so far: " + totalRecordsProcessed);
            }

            System.out.println("Total records processed: " + totalRecordsProcessed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 🔽 PRINTING happens here
    private static void processChunk(List<String> chunk) {
        System.out.println("---- Processing New Chunk ----");
        for (String record : chunk) {
            System.out.println(record);
        }
    }
}
