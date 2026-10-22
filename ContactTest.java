import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ContactTest {
    @Test
    void contactIsCreatedWithValidFields() {
        Contact contact = new Contact("C123", "Tina", "Nguyen", "5551234567", "123 Main Street");

        assertEquals("C123", contact.getContactId());
        assertEquals("Tina", contact.getFirstName());
        assertEquals("Nguyen", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main Street", contact.getAddress());
    }

    @Test
    void contactRejectsInvalidId() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact(null, "Tina", "Nguyen", "5551234567", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("12345678901", "Tina", "Nguyen", "5551234567", "123 Main Street"));
    }

    @Test
    void contactRejectsInvalidNames() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", null, "Nguyen", "5551234567", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Tina", "LastNameTooLong", "5551234567", "123 Main Street"));
    }

    @Test
    void contactRejectsInvalidPhoneAndAddress() {
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Tina", "Nguyen", "555123456", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Tina", "Nguyen", "555123456A", "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Tina", "Nguyen", null, "123 Main Street"));
        assertThrows(IllegalArgumentException.class,
                () -> new Contact("C1", "Tina", "Nguyen", "5551234567", null));
    }

    @Test
    void contactUpdatesValidMutableFields() {
        Contact contact = new Contact("C1", "Tina", "Nguyen", "5551234567", "123 Main Street");
        contact.setFirstName("Linh");
        contact.setLastName("Tran");
        contact.setPhone("4445556666");
        contact.setAddress("45 Oak Avenue");

        assertEquals("C1", contact.getContactId());
        assertEquals("Linh", contact.getFirstName());
        assertEquals("Tran", contact.getLastName());
        assertEquals("4445556666", contact.getPhone());
        assertEquals("45 Oak Avenue", contact.getAddress());
    }
}
