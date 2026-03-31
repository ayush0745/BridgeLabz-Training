import java.io.*;
import java.util.*;

public class DataService {
    private static final String FILE_NAME = "AddressBook.txt";

    // UC 13: Write to File
    public void writeToFile(List<Contact> contacts) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contacts) {
                writer.println(contact.toString());
            }
            System.out.println("Successfully saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }
    }

    // UC 13: Read from File
    public List<Contact> readFromFile() {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 8) {
                    contacts.add(new Contact(data[0], data[1], data[2], data[3], 
                                 data[4], Long.parseLong(data[5]), 
                                 Long.parseLong(data[6]), data[7]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No existing backup file found.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return contacts;
    }
}