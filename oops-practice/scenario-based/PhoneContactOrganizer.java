import java.util.ArrayList;
import java.util.List;

// Custom Exception
class InvalidPhoneNumberException extends Exception {
    private int errorCode;

    public InvalidPhoneNumberException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

// Contact Class
class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }
}

// Contact Organizer Class
class ContactOrganizer {
    private List<Contact> contacts = new ArrayList<>();

    // Validate phone number
    private void validatePhone(String phone) throws InvalidPhoneNumberException {
        if (!phone.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                101,
                "Phone number must be exactly 10 digits"
            );
        }
    }

    // Add Contact
    public void addContact(String name, String phone) throws InvalidPhoneNumberException {
        validatePhone(phone);

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                System.out.println("Duplicate contact not allowed.");
                return;
            }
        }
        contacts.add(new Contact(name, phone));
        System.out.println("Contact added successfully.");
    }

    // Delete Contact
    public void deleteContact(String phone) {
        boolean removed = contacts.removeIf(
            c -> c.getPhoneNumber().equals(phone)
        );

        System.out.println(
            removed ? "Contact deleted successfully." : "Contact not found."
        );
    }

    // Search Contact
    public Contact searchContact(String phone) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phone)) {
                return c;
            }
        }
        return null;
    }

    // Display All Contacts
    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}

// Main Class
public class PhoneContactOrganizer {
    public static void main(String[] args) {
        ContactOrganizer organizer = new ContactOrganizer();

        try {
            organizer.addContact("Ayush", "9876543210");
            organizer.addContact("Ravi", "1234567890");
            organizer.addContact("Duplicate", "9876543210"); // Duplicate
            organizer.addContact("Invalid", "12345"); // Exception
        } catch (InvalidPhoneNumberException e) {
            System.out.println(
                "Error Code: " + e.getErrorCode() +
                " | Message: " + e.getMessage()
            );
        }

        System.out.println("\nSearching:");
        Contact found = organizer.searchContact("9876543210");
        System.out.println(found != null ? found : "Contact not found");

        organizer.deleteContact("1234567890");

        System.out.println("\nAll Contacts:");
        organizer.displayContacts();
    }
}
