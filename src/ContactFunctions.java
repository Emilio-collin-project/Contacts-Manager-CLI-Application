import java.util.ArrayList;

public class ContactFunctions {



    public static void printContacts(ArrayList<Contact> contacts) {
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            // For each iteration we want it to grab the contact at index i
            System.out.println(contact);
        }
        System.out.println("Here are the contacts. ");

    }
}

