import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class FileIO {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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


            Scanner eb = new Scanner(System.in);

            boolean userContinue = true;
            do {
                System.out.println("Would you like to add a new contact? ");
                int addContacts = eb.nextInt();
                System.out.println();
                System.out.println("Here is the updated contact list!");
                System.out.println();
                System.out.println("Name  |  Phone Number  |");
                System.out.println("------ | ------ |");
                for (int i = 0; i <= addContacts; i++) {
                    System.out.printf("%-6d", i);
                    System.out.print(" | ");
                    System.out.printf("%-7d", i * i);
                    System.out.print(" | ");
                    System.out.println(i * i * i);
                }
                System.out.println();
                System.out.println("Would you like enter another contact? (y/n)");
                String userResponse = eb.next();
                if (!(userResponse.equalsIgnoreCase("y"))) {
                    userContinue = false;
                }
            } while (userContinue);

            System.out.println("See you later!");


    }catch (IOException e) {
//            System.out.println("Hey an exception happened: " + e.getMessage());
            e.printStackTrace();
        }
    }
}






















