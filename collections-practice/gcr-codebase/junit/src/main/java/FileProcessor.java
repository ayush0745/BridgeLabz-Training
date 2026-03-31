import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessor {

    // Write content to file
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Path.of(filename), content.getBytes());
    }

    // Read content from file
    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
