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

    public static void main(String[] args) {
        try {


            String directory = "src";
            String filename = "contacts.txt";

            Path dataDirectory = Paths.get(directory);
            Path dataFile = Paths.get(directory, filename); // Path object is like this src/contacts.txt

            if (Files.notExists(dataDirectory)) {
                Files.createDirectories(dataDirectory);
            }

            if (!Files.exists(dataFile)) {
                Files.createFile(dataFile);
            }


            // Write some stuff to src/contacts.txt
            List<String> contacts = new ArrayList<>(Arrays.asList("John" + "  |  " + "  Phone Number  " + "281-334-8004", "Michael", "Erik"));
            ArrayList<String> moreContacts = new ArrayList<>(Arrays.asList("Sammy"));

            //System.out.println(lines);
            Files.write(dataFile, contacts); // This overrides by default
            Files.write(dataFile, moreContacts, StandardOpenOption.APPEND);

            contacts.clear();
            System.out.println("Contacts array list is empty?" + contacts.isEmpty());


            // read in contacts from the data file
            contacts = Files.readAllLines(dataFile);
            System.out.printf("Contacts read from file: %s\n", contacts);
            System.out.println("Is contacts an arraylist? " + (contacts instanceof ArrayList));

            int replaceIndex = contacts.indexOf("Michael");
            contacts.remove(replaceIndex);
            contacts.add(replaceIndex, "Bobby");
            Files.write(dataFile, contacts); // this overwrites by default


//            Scanner eb = new Scanner(System.in);
            do {
                printMenu();

                int choice = getUserChoice();
                doUserChoice(choice);
                if (choice == 5) {
                    break;
                }

            } while (true);

            System.out.println("See you later!");


        } catch (IOException e) {
//            System.out.println("Hey an exception happened: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void doUserChoice(int choice) {
        switch (choice) {
            // make a function for view contacts
            case 1:
                viewContacts.printContacts();
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
        System.out.println("menu");
    }
}






















