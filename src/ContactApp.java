import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ContactApp {
    public static Input input = new Input();

    public static void main(String[] args)  {

        String directory = "src";
        String filename = "contacts.txt";

        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename); // path object is like this src/contacts.txt

        if (Files.notExists(dataDirectory)) {
            try {
                Files.createDirectories(dataDirectory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (! Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path contactPath = Paths.get(directory, filename);
//        List<String> contactStringList = null;
//        try {
//            contactStringList = Files.readAllLines(contactPath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {

            do {
                printMenu();

                int choice = getUserChoice();
                doUserChoice(choice, contactPath);
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

    public static void doUserChoice(int choice,Path contactPath ) {
        switch (choice) {
            // make a function for view contacts
            case 1:
                printContacts(contactPath);
                break;
            // make a function for add new contacts
            case 2:
              ContactFunctions.addContact(contactPath);
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
        System.out.println("1. View contacts.\n" + "2. Add a new contact. \n" + "3. Search a contact by name. \n" + "4. Delete an existing contact. \n" + "5. Exit. \n" + "Enter an option (1, 2, 3, 4 or 5): \n");

    }
    public static void printContacts(Path contactPath){
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Name  |  Phone Number");
        System.out.println("----------");
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println(contactsList.get(i));
        }

    }

    public static void contactSearch(Path contactPath){
        // read all the lines in the file save them in the list
        // prompt user who to search for
        // get userinput
        // looped through the list of lines
        // inside the loop check if it matches userinput
        // if it matches print it out

        List<String> lines = null;
        try {
            lines = Files.readAllLines(contactPath);
            for (String line : lines) {
                if (line.equals(input)) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}






















