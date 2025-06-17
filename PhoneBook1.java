import java.util.HashMap;
import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nPhoneBook Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts (Sorted by Name)");
            System.out.println("3. Delete Contact");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phone = scanner.nextLine();
                    phoneBook.put(name, phone);
                    System.out.println("Contact added.");
                    break;

                case 2:
                    System.out.println("\n--- PhoneBook Contacts (Sorted) ---");
                    if (phoneBook.isEmpty()) {
                        System.out.println("No contacts found.");
                    } else {
                        // Extract names to array
                        String[] names = phoneBook.keySet().toArray(new String[0]);

                        // Bubble Sort the names alphabetically
                        for (int i = 0; i < names.length - 1; i++) {
                            for (int j = 0; j < names.length - i - 1; j++) {
                                if (names[j].compareToIgnoreCase(names[j + 1]) > 0) {
                                    // Swap
                                    String temp = names[j];
                                    names[j] = names[j + 1];
                                    names[j + 1] = temp;
                                }
                            }
                        }

                        // Display sorted contacts
                        for (String n : names) {
                            System.out.println("Name: " + n + ", Phone: " + phoneBook.get(n));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter the name of the contact to delete: ");
                    String nameToDelete = scanner.nextLine();
                    if (phoneBook.containsKey(nameToDelete)) {
                        phoneBook.remove(nameToDelete);
                        System.out.println("Contact deleted.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting PhoneBook.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
