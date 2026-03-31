import java.util.*;

public class AddressBookMain {
    private static Scanner sc = new Scanner(System.in);
    private static Map<String, AddressBook> systemMap = new HashMap<>();
    private static DataService dataService = new DataService();

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book Program (File Version)");
        
        AddressBook defaultBook = new AddressBook();
        // Optional: Load existing data on startup
        defaultBook.getContacts().addAll(dataService.readFromFile());
        systemMap.put("Default", defaultBook);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n1. Add Contact | 2. Show All | 3. Save | 4. Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1: addPerson(systemMap.get("Default")); break;
                case 2: systemMap.get("Default").getContacts().forEach(System.out::println); break;
                case 3: saveData(systemMap.get("Default").getContacts()); break;
                case 4: exit = true; break;
            }
        }
    }

    private static void addPerson(AddressBook book) {
        System.out.print("First Name: "); String fn = sc.nextLine();
        System.out.print("Last Name: "); String ln = sc.nextLine();
        System.out.print("Address: "); String addr = sc.nextLine();
        System.out.print("City: "); String city = sc.nextLine();
        System.out.print("State: "); String state = sc.nextLine();
        System.out.print("Zip: "); long zip = Long.parseLong(sc.nextLine());
        System.out.print("Phone: "); long ph = Long.parseLong(sc.nextLine());
        System.out.print("Email: "); String em = sc.nextLine();

        book.addContact(new Contact(fn, ln, addr, city, state, zip, ph, em));
    }

    private static void saveData(List<Contact> contacts) {
        // UC 17: Use Thread for File IO
        new Thread(() -> {
            dataService.writeToFile(contacts);
        }).start();
    }
}