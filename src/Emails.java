
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import util.FileUtil;

/**
 *
 * @author sascha
 */
public class Emails {

    private static final String FILENAME = "emails.csv";
    private static final String FILENAMEXML = "emails.xml";

    private static ArrayList<String[]> emails = new ArrayList<>();

    private static int menu(String... entries) {
        outputNumberedList(entries);
        System.out.print("Deine Wahl: ");
        return inputInt();
    }
    
    private static void showEmails() {
        System.out.println("\nStored Emails\n-------------\n");
        for(int i = 0; i < emails.size(); i++) {
            System.out.println((i+1) + " | " + emails.get(i)[0] + " | " + emails.get(i)[1]);
        }
    }
    
    private static void addEmail() {
        System.out.println("Enter a name: ");
        String name = input();
        System.out.println("Enter the email of " + name);
        String address = input();
        emails.add(new String[] {name,address});
    }
    
    private static void removeEmail() {
        showEmails();
        System.out.println("Which one to remove ? (0 for 'Main Menu'");
        int choice = inputInt();
        if(choice == 0) {
            return;
        }
        emails.remove(choice - 1);
    }
    
    private static void editEmail() {
        showEmails();
        System.out.println("Which one to edit ? (0 for 'Main Menu'");
        int choice = inputInt();
        if(choice == 0) {
            return;
        }
        
        System.out.println("Editing " + emails.get(choice-1)[0] + "/" + emails.get(choice-1)[1]+ "\nWhat do you want to change?");
        outputNumberedList("Name","Email");
        System.out.println("Your choice: ");
        int choice2 = inputInt();
        if(choice2 == 1) {
            System.out.println("Enter new Name");
            String name = input();
            emails.get(choice-1)[0] = name;
        }
        if(choice2 == 2) {
            System.out.println("Enter new Email");
            String email = input();
            emails.get(choice-1)[1] = email;
        }
    }

    
    private static void mainMenu() {
        System.out.println("Your choice:");
        int choice;
        boolean exit = false;
        do {
            choice = menu("Show Emails", "Add Email", "Remove Email","Edit Email", "Export to XML", "Save & Exit Program");
            switch(choice) {
                case 1:
                    showEmails(); 
                    break;
                case 2:
                    addEmail();
                    break;
                case 3:
                    removeEmail();
                    break;
                case 4:
                    editEmail();
                    break;
                case 5:
                    exportToXml(FILENAMEXML);
                    break;
                case 6:
                    save(FILENAME);
                    exit = true;
                case 0:
                    break;
                default:
                    break;
            }
        } while (!exit);

    } // mainMenu

    //-------------------- File Functions 
    private static void load(String filename) {
        System.out.println("Loading from " + filename);
        FileUtil.loadCSV(filename, emails);
        System.out.println("Loaded " + emails.size() + " Emails");
    }

    private static void save(String filename) {
        String data = "";
        for(int i = 0; i < emails.size(); i++) {
                data += emails.get(i)[0] + "," + emails.get(i)[1] + "\n";
            }
        FileUtil.save(filename, data);
    }
    
    private static void exportToXml(String filename) {
        String data = "";
        data += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<emails>\n";
        for(int i = 0; i < emails.size(); i++) {
                data += "\t<email>\n\t\t<name>" + emails.get(i)[0] + "</name>\n\t\t<address>" + emails.get(i)[1] + "</adress>\n\t</email>\n";
            }
        data += "</emails>";
        FileUtil.save(filename, data);
    }

    // Generic Menu-Functions
    private static void outputNumberedList(String... entries) {
        int i = 1;
        for(String s : entries) {
            System.out.println(i + ". " + s);
            i++;
        }
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
        System.out.println("Bye");
    } // main

} // class
