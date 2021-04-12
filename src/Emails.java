
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author sascha
 */
public class Emails {

    private static final String FILENAME = "emails.csv";
    private static final String FILENAMEXML = "emails.xml";

    private static ArrayList<String[]> emails = new ArrayList<>();

    private static void mainMenu() {
        int choice;
        boolean exit = false;
        do {
            // TO DO: write Method menu, than uncomment
            // choice = menu("Show Emails", "Add Email", "Remove Email",
           //          "Edit Email", "Export to XML", "Save & Exit Program");

        } while (!exit);

    } // mainMenu

    //-------------------- File Functions 
    private static void load(String filename) {
        //Create some dummy data
        String[] dummy1 = {"Huey", "huey@duckburg.edu"};
        String[] dummy2 = {"Duey", "dewey@duckburg.edu"};
        emails.add(dummy1);
        emails.add(dummy2);
        // TO DO: real loading

    }

    private static void save(String filename) {
        // TO DO
    }

    // Generic Menu-Functions
    private static void outputNumberedList(String... entries) {
        // TO DO
    }

    // TO-DO: method menu
    // ------------------- Input Functions
    private final static Scanner scan = new Scanner(System.in);

    private static String input() {
        return scan.nextLine();
    }

    private static String input(String text) {
        System.out.println(text);
        return input();
    }

    private static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(input());
            } catch (Exception ex) {
                System.out.println("Please enter a number");
            }
        }
    } // input int

    private static int inputInt(int from, int to) {
        int number = inputInt();
        while (number < from || number > to) {
            System.out.printf("Please enter a number between %d and %d\n", from, to);
            number = inputInt();
        }
        return number;
    }

    private static int inputInt(String text, int from, int to) {
        System.out.println(text);
        return inputInt(from, to);
    }
//------------------------------------------------

    public static void main(String[] args) {
        load(FILENAME);
        mainMenu();
        save(FILENAME);
        System.out.println("Bye");

    } // main

} // class
