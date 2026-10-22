import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContactServiceTest {
    @Test
    void serviceAddsAContactWithUniqueId() {
        ContactService service = new ContactService();
        Contact contact = new Contact("C1", "Tina", "Nguyen", "5551234567", "123 Main Street");

        service.addContact(contact);

        assertEquals(contact, service.getContact("C1"));
    }

    @Test
    void serviceRejectsNullContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void serviceRejectsDuplicateContactId() {
        ContactService service = new ContactService();
        service.addContact(new Contact("C1", "Tina", "Nguyen", "5551234567", "123 Main Street"));

        assertThrows(IllegalArgumentException.class,
                () -> service.addContact(new Contact("C1", "Linh", "Tran", "4445556666", "45 Oak Avenue")));
    }

    @Test
    void serviceDeletesContactById() {
        ContactService service = new ContactService();
        service.addContact(new Contact("C1", "Tina", "Nguyen", "5551234567", "123 Main Street"));

        service.deleteContact("C1");

        assertNull(service.getContact("C1"));
    }

    @Test
    void serviceUpdatesContactFieldsById() {
        ContactService service = new ContactService();
        service.addContact(new Contact("C1", "Tina", "Nguyen", "5551234567", "123 Main Street"));

        service.updateContact("C1", "Linh", "Tran", "4445556666", "45 Oak Avenue");
        Contact updated = service.getContact("C1");

        assertEquals("Linh", updated.getFirstName());
        assertEquals("Tran", updated.getLastName());
        assertEquals("4445556666", updated.getPhone());
        assertEquals("45 Oak Avenue", updated.getAddress());
    }

    @Test
    void serviceRejectsOperationsForUnknownContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("missing"));
        assertThrows(IllegalArgumentException.class,
                () -> service.updateContact("missing", "Linh", "Tran", "4445556666", "45 Oak Avenue"));
    }
}
