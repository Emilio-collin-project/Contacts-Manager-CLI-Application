import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContactApp {
    public static Input input = new Input();
    public static ArrayList<Contact> contactsList;

    public static void main(String[] args) {

        String directory = "src";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename); // path object is like this src/contacts.txt

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (! Files.exists(dataFile)) {
            Files.createFile(dataFile);
        }







        try {
            contactsList = new ArrayList<>();

            do {
                printMenu();

                int choice = getUserChoice();
                doUserChoice(choice);
                if (choice == 5) {
                    break;
                }

            } while (true);

            System.out.println("See you later!");


        } catch (Exception e) {
//            System.out.println("Hey an exception happened: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void doUserChoice(int choice) {
        switch (choice) {
            // make a function for view contacts
            case 1:
                ContactFunctions.printContacts(contactsList);
                break;
            // make a function for add new contacts
            case 2:
                System.out.println(ContactFunctions.addContact(contactsList, input).get(0).getName());
                break;
            //make a function search by name
            case 3:
                System.out.println("Search a contact by name.");
                break;
            //make a function for deleting contact
            case 4:
                System.out.println("Delete an existing contact.");
            case 5:
                System.out.println("Exit.");

        }
    }

    private static int getUserChoice() {
        return input.getInt();
    }

    private static void printMenu() {
        System.out.println("Menu \n");
        System.out.println("1. View contact.\n" + "2. Add a new contact. \n" + "3. Search a contact by name. \n" + "4. Delete an existing contact. \n" + "5. Exit. \n" + "Enter an option (1, 2, 3, 4 or 5): \n");

    }
}






















