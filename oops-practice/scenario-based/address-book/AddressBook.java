import java.util.*;
import java.util.stream.Collectors;

public class AddressBook {
    private List<Contact> contactList = new ArrayList<>();

    public void addContact(Contact contact) {
        if (contactList.contains(contact)) {
            System.out.println("Duplicate entry found.");
        } else {
            contactList.add(contact);
        }
    }

    public List<Contact> getContacts() { return contactList; }
}