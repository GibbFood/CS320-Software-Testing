/** Represents one contact with validated, mutable contact details. */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        validateContactId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void setFirstName(String firstName) {
        validateRequiredString(firstName, 10, "First name");
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        validateRequiredString(lastName, 10, "Last name");
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must contain exactly 10 digits.");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        validateRequiredString(address, 30, "Address");
        this.address = address;
    }

    private static void validateContactId(String contactId) {
        validateRequiredString(contactId, 10, "Contact ID");
    }

    private static void validateRequiredString(String value, int maxLength, String fieldName) {
        if (value == null || value.length() > maxLength) {
            throw new IllegalArgumentException(fieldName + " is required and must be no longer than " + maxLength + " characters.");
        }
    }
}
