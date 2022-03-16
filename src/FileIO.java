import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





public class FileIO {
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









        }catch (IOException e) {
//            System.out.println("Hey an exception happened: " + e.getMessage());
            e.printStackTrace();
        }
    }
}






















