import java.util.Scanner;

public class Input {
    private Scanner scanner;

    public Input() {
         scanner = new Scanner(System.in);
    }

    public String getString() {
        return scanner.nextLine();
    }

    public boolean yesNo() {
        System.out.println("Enter yes or no: ");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public int getInt(int min, int max) {
        System.out.println("Enter a number: ");
        int input = Integer.parseInt(scanner.nextLine());
        if (input < min || input > max) {
            System.out.println("Try Again.");
            return getInt(min, max);
        } else {
            return input;
        }
    }

    public int getInt() throws NumberFormatException {
        try {
            String word = getString();
            return Integer.parseInt(word);
        } catch (NumberFormatException something) {
            System.out.println(something);
            System.out.println("Type a number: ");
            return getInt();
        }
    }

    public double getDouble(double min, double max) {
        System.out.println("Enter a number: ");
        double input = Double.parseDouble(scanner.nextLine());
        if (input < min || input > max) {
            System.out.println("Try Again.");
            return getDouble(min, max);
        } else {
            System.out.println("Your number is: ");
            return input;
        }

    }

    public double getDouble() throws NumberFormatException {
        try {
            String word = getString();
            return Double.parseDouble(word);
        } catch (NumberFormatException something) {
            System.out.println(something);
            System.out.println("Type a number: ");
            return getInt();
        }
    }
}
