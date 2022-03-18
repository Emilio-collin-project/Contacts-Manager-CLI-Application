import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactFunctions {



//    public static void printContacts(ArrayList<Contact> contacts) {
//        System.out.println("Here are the contacts. ");
//
//        for (int i = 0; i < contacts.size(); i++) {
//            Contact contact = contacts.get(i);
//            // For each iteration we want it to grab the contact at index i
//            System.out.println(contact);
//        }
//    }

    public static void addContact(Path filePath) {
        //Grab contacts name, phone number
        Scanner eb = new Scanner(System.in);
        System.out.println("Please enter new Contact Name.");
        String contactName = eb.nextLine();
        System.out.println("Please Enter Phone number for new contact.");
        String contactPhoneNumber = eb.nextLine();
        Contact newContact = new Contact(contactName, contactPhoneNumber);
        String contactToAdd = newContact.toString();
        try {
            Files.write(
                    filePath,
                    Arrays.asList(contactToAdd), // list with one item
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
        // make a contact object
        //add contact object to contactslist
    }
}

