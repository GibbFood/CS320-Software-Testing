import java.util.HashMap;
import java.util.Map;

/** Stores contacts in memory and provides the required contact operations. */
public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null.");
        }
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique.");
        }
        contacts.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }
        contacts.remove(contactId);
    }

    public void updateContact(String contactId, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID was not found.");
        }
        contact.setFirstName(firstName);
        contact.setLastName(lastName);
        contact.setPhone(phone);
        contact.setAddress(address);
    }

    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
