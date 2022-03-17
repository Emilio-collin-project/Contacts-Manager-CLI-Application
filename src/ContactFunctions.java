import java.util.ArrayList;
import java.util.Scanner;

public class ContactFunctions {



    public static void printContacts(ArrayList<Contact> contacts) {
        System.out.println("Here are the contacts. ");

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            // For each iteration we want it to grab the contact at index i
            System.out.println(contact);
        }
    }

    public static ArrayList<Contact> addContact(ArrayList<Contact> contactsList, Input input) {
        //Grab contacts name, phone number
        Scanner eb = new Scanner(System.in);
        System.out.println("Please enter new Contact Name.");
        String contactName = eb.nextLine();
        System.out.println("Please Enter Phone number for new contact.");
        String contactPhoneNumber = eb.nextLine();
        Contact newContact = new Contact(contactName, contactPhoneNumber);
        contactsList.add(newContact);
        return contactsList;

        // make a contact object
        //add contact object to contactslist
    }
}

