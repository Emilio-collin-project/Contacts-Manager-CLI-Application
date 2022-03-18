import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

import java.util.Scanner;

public class ContactFunctions {

    public static void addContact(Path filePath) {
        //Grab contacts name, phone number
        Scanner eb = new Scanner(System.in);
        System.out.println(ConsoleColors.PURPLE_BRIGHT + "Please enter new Contact Name." + ConsoleColors.RESET);
        String contactName = eb.nextLine();
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "Please Enter Phone number for new contact." + ConsoleColors.RESET);
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