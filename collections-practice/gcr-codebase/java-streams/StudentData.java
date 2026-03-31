import java.io.*;

public class StudentData {
    public static void main(String[] args) {

        String fileName = "student.dat";

        // 🔹 Writing data to file
        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            dos.writeInt(101);                 // Roll Number
            dos.writeUTF("Ayush");             // Name
            dos.writeDouble(8.75);              // GPA

            System.out.println("Student data written successfully.");

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        // 🔹 Reading data from file
        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Details Retrieved:");
            System.out.println("Roll Number: " + rollNo);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);

        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}
