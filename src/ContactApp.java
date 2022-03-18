import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactApp {
    public static Input input = new Input();

    public static void main(String[] args) {

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

        if (!Files.exists(dataFile)) {
            try {
                Files.createFile(dataFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Path contactPath = Paths.get(directory, filename);

        try {

            do {
                printMenu();

                int choice = getUserChoice();
                doUserChoice(choice, contactPath);
                if (choice == 5) {
                    break;
                }

            } while (true);

            System.out.println(ConsoleColors.RED_BRIGHT + "See you later!" + ConsoleColors.RESET);


        } catch (Exception e) {
//            System.out.println("Hey an exception happened: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void doUserChoice(int choice, Path contactPath) {
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
                contactSearch(contactPath);
                break;
            //make a function for deleting contact
            case 4:
                deleteName(contactPath);
            case 5:
                System.out.println(ConsoleColors.CYAN_BRIGHT + "Exit." + ConsoleColors.RESET);
        }
    }

    private static int getUserChoice() {
        return input.getInt();
    }

    private static void printMenu() {
        System.out.println(ConsoleColors.BLUE_BRIGHT + "___________       .__.__  .__                            .___ _________        .__  .__  .__     /\\                                     \n" +
                "\\_   _____/ _____ |__|  | |__| ____   _____    ____    __| _/ \\_   ___ \\  ____ |  | |  | |__| ___)/  ______                             \n" +
                " |    __)_ /     \\|  |  | |  |/  _ \\  \\__  \\  /    \\  / __ |  /    \\  \\/ /  _ \\|  | |  | |  |/    \\ /  ___/                             \n" +
                " |        \\  Y Y  \\  |  |_|  (  <_> )  / __ \\|   |  \\/ /_/ |  \\     \\___(  <_> )  |_|  |_|  |   |  \\\\___ \\                              \n" +
                "/_______  /__|_|  /__|____/__|\\____/  (____  /___|  /\\____ |   \\______  /\\____/|____/____/__|___|  /____  >                             \n" +
                "        \\/      \\/                         \\/     \\/      \\/          \\/                         \\/     \\/                              \n" +
                "_________                __                 __              _____                                                 _____                 \n" +
                "\\_   ___ \\  ____   _____/  |______    _____/  |_  ______   /     \\ _____    ____ _____     ____   ___________    /  _  \\ ______ ______  \n" +
                "/    \\  \\/ /  _ \\ /    \\   __\\__  \\ _/ ___\\   __\\/  ___/  /  \\ /  \\\\__  \\  /    \\\\__  \\   / ___\\_/ __ \\_  __ \\  /  /_\\  \\\\____ \\\\____ \\ \n" +
                "\\     \\___(  <_> )   |  \\  |  / __ \\\\  \\___|  |  \\___ \\  /    Y    \\/ __ \\|   |  \\/ __ \\_/ /_/  >  ___/|  | \\/ /    |    \\  |_> >  |_> >\n" +
                " \\______  /\\____/|___|  /__| (____  /\\___  >__| /____  > \\____|__  (____  /___|  (____  /\\___  / \\___  >__|    \\____|__  /   __/|   __/ \n" +
                "        \\/            \\/          \\/     \\/          \\/          \\/     \\/     \\/     \\//_____/      \\/                \\/|__|   |__|    " + ConsoleColors.RESET);
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "*********************************************************************************************************************************************" + ConsoleColors.RESET);
        System.out.println("\n");
        System.out.println(ConsoleColors.CYAN_BRIGHT + "1. View contacts.\n" + ConsoleColors.RESET + ConsoleColors.PURPLE_BRIGHT + "2. Add a new contact. \n" + ConsoleColors.RESET + ConsoleColors.BLUE_BRIGHT + "3. Search a contact by name. \n" + ConsoleColors.RESET + ConsoleColors.RED_BRIGHT + "4. Delete an existing contact. \n" + ConsoleColors.RESET + ConsoleColors.GREEN_BRIGHT + "5. Exit. \n" + ConsoleColors.RESET + ConsoleColors.YELLOW_BRIGHT + "Enter an option (1, 2, 3, 4 or 5): \n" + ConsoleColors.RESET);
    }

    public static void printContacts(Path contactPath) {
        List<String> contactsList = null;
        try {
            contactsList = Files.readAllLines(contactPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ConsoleColors.CYAN_BRIGHT + "Name  |  Phone Number" + ConsoleColors.RESET);
        System.out.println(ConsoleColors.RED_BRIGHT + "---------------------" + ConsoleColors.RESET);
        for (int i = 0; i < contactsList.size(); i += 1) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + contactsList.get(i) + ConsoleColors.RESET);
        }
    }

    public static void contactSearch(Path contactPath) {
        // read all the lines in the file save them in the list
        // prompt user who to search for
        // get userinput
        // looped through the list of lines
        // inside the loop check if it matches userinput
        // if it matches print it out

        List<String> lines = null;
        try {
            lines = Files.readAllLines(contactPath);
            Scanner cj = new Scanner(System.in);
            System.out.println(ConsoleColors.BLUE + "Please enter in the name you want to search." + ConsoleColors.RESET);
            String searchName = cj.nextLine();
            for (String line : lines) {
                if (line.contains(searchName)) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteName(Path contactPath) {

        List<String> newLines = null;
        List<String> newList;

        try {
            newLines = Files.readAllLines(contactPath);
            newList = new ArrayList<>();
            Scanner cj = new Scanner(System.in);
            System.out.println(ConsoleColors.GREEN + "Please enter in the name you want to delete." + ConsoleColors.RESET);
            String deleteSelectedName = cj.nextLine();
            for (String line : newLines) {
                if (line.contains(deleteSelectedName)) {
                    continue;
                }
                newList.add(line);
            }
            Files.write(contactPath, newList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}