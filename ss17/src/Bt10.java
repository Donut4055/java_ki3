import java.util.*;

class Contact {
    private static int nextId = 1; // Biến tĩnh để tự động tăng id
    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = nextId++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public int getId() { return id; }
    public String getPhoneNumber() { return phoneNumber; }
    public String getName() { return name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return phoneNumber.equals(contact.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + "', phoneNumber='" + phoneNumber ;
    }
}

public class Bt10 {
    private Set<Contact> contacts;

    public Bt10() {
        contacts = new HashSet<>();
    }

    public boolean addContact(Contact contact) {
        if (contacts.contains(contact)) {
            System.out.println("Số điện thoại '" + contact.getPhoneNumber() + "' đã tồn tại!");
            return false;
        }
        return contacts.add(contact);
    }

    public boolean removeContact(String phoneNumber) {
        Contact tempContact = new Contact("", phoneNumber);
        if (contacts.remove(tempContact)) {
            System.out.println("Đã xóa liên lạc với số '" + phoneNumber + "'");
            return true;
        } else {
            System.out.println("Không tìm thấy liên lạc với số '" + phoneNumber + "'");
            return false;
        }
    }

    public Contact findContact(String phoneNumber) {
        Contact tempContact = new Contact("", phoneNumber);
        for (Contact contact : contacts) {
            if (contact.equals(tempContact)) {
                return contact;
            }
        }
        return null;
    }

    public void printContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Danh bạ trống!");
        } else {
            System.out.println("\nDanh sách liên lạc (" + contacts.size() + " liên lạc):");
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        Bt10 phoneBook = new Bt10();

        phoneBook.addContact(new Contact("John Doe", "123456789"));
        phoneBook.addContact(new Contact("Jane Smith", "987654321"));
        phoneBook.addContact(new Contact("Bob Johnson", "555555555"));

        phoneBook.addContact(new Contact("Test User", "123456789"));

        phoneBook.printContacts();

        String searchNumber = "987654321";
        Contact found = phoneBook.findContact(searchNumber);
        System.out.println("\nTìm kiếm số '" + searchNumber + "': " +
                (found != null ? found : "Không tìm thấy"));

        phoneBook.removeContact("555555555");

        phoneBook.printContacts();
    }
}