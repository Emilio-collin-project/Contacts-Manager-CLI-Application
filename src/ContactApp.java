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
                System.out.println("Add a new contact.");
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
    }
}






















