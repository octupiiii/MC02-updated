import java.util.Scanner;

/**
 * Class representing the menus used for navigating the a vending machine.
 */
public class Menu {
    Scanner sc = new Scanner(System.in);

    /**
     * Displays the main menu and prompts the user for a choice.
     *
     * @return The user's choice.
     */
    public int mainMenu() {
        int choice = 0;
        System.out.println();
        System.out.println("\tChoose Function\n");
        System.out.println("1. Create a Vending Machine"); // stop showing after creating na
        System.out.println("2. Test a Vending Machine");
        System.out.println("3. Exit Program");
        System.out.print("\nEnter your choice: ");

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer choice.");
            // Clear the invalid input from the scanner buffer
            sc.nextLine();
            choice = mainMenu(); // Recursive call to display the menu again
        }

        return choice;
    }

    /**
     * Displays the menu for choosing a type of vending machine to create
     *
     * @return The user's choice.
     */
    public int chooseVM() {
        int choice = 0;
        System.out.println();
        System.out.println("\nSelect Type of Vending Machine to Create: ");
        System.out.println("\n1. Regular Vending Machine");
        System.out.println("2. Special Vending Machine\n");

        System.out.print("Enter your choice: ");
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer choice.");
            // Clear the invalid input from the scanner buffer
            sc.nextLine();
            choice = mainMenu(); // Recursive call to display the menu again
        }

        return choice;
    }

    /**
     * Displays the menu for testing a vending machine and prompts the user for a
     * choice.
     *
     * @return The user's choice.
     */
    public int testVendingMachine() {
        int choice = 0;
        System.out.println();
        System.out.println("Choose Vending Machine Feature to test:");
        System.out.println();
        System.out.println("1. Vending Features");
        System.out.println("2. Maintenance Features\n");

        System.out.print("Enter your choice: ");

        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer choice.");
            // Clear the invalid input from the scanner buffer
            sc.nextLine();
            choice = testVendingMachine(); // Recursive call to display the menu again
        }

        return choice;
    }

    /**
     * Displays the menu for testing maintenance features and prompts the user for a
     * choice.
     *
     * @return The user's choice.
     */
    public int testMaintenanceFeatures() {
        int choice = 0;
        System.out.println("Choose Maintenance Feature to test:");
        System.out.println("1. Stocking a new item");
        System.out.println("2. Restocking an existing item");
        System.out.println("3. Setting item price");
        System.out.println("4. Withdrawing money");
        System.out.println("5. Replenishing money for change");
        System.out.println("6. Displaying Summary of Transactions");
        System.out.println("7. Exit Maintenance Features Test");

        System.out.print("\nEnter your choice: ");
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer choice.");
            // Clear the invalid input from the scanner buffer
            sc.nextLine();
            choice = testMaintenanceFeatures(); // Recursive call to display the menu again
        }

        return choice;
    }

    /**
     * Displays the menu for testing vending features and prompts the user for a
     * choice.
     *
     * @return The user's choice.
     */
    public int testVendingFeatures() {
        int choice = 0;

        System.out.println("\nChoose Vending Feature to test:\n");
        System.out.println("1. Buy Item");
        System.out.println("2. View amount of Calories");
        System.out.println("3. Exit Vending Features Test");

        System.out.print("\nEnter your choice: ");
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
        } else {
            System.out.println("Invalid input. Please enter a valid integer choice.");
            // Clear the invalid input from the scanner buffer
            sc.nextLine();
            choice = testVendingFeatures(); // Recursive call to display the menu again
        }

        return choice;
    }

    /**
     * Closes the scanner object if it is not null.
     */
    public void closeScanner() {
        if (sc != null) {
            sc.close();
        }
    }

}
