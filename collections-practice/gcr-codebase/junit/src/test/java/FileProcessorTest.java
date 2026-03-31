import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class FileProcessorTest {

    private final FileProcessor fileProcessor = new FileProcessor();
    private final String fileName = "testfile.txt";

    // Cleanup after each test
    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Path.of(fileName));
    }

    //  Test writing and reading content
    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit";

        fileProcessor.writeToFile(fileName, content);
        String result = fileProcessor.readFromFile(fileName);

        assertEquals(content, result);
    }

    //  Test file exists after writing
    @Test
    void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(fileName, "JUnit Test");

        assertTrue(Files.exists(Path.of(fileName)));
    }

    //  Test IOException when file does not exist
    @Test
    void testReadFileThatDoesNotExist() {
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nofile.txt");
        });
    }
}
