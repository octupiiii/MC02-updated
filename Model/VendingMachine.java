package Model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Model.Slot;

import java.util.Iterator;

/**
 * Class representing the Vending Machine object that contains the main methods
 * and properties.
 */
public class VendingMachine {
    Scanner scanner = new Scanner(System.in);
    protected ArrayList<Slot> itemSlot;
    private ArrayList<MoneyDenomination> availableCash;
    private ArrayList<Transaction> transactions;
    private ArrayList<Slot> startingInventory, endingInventory;
    private double totalPaymentAmount;

    /**
     * Constructs a VendingMachine object.
     * Initializes the itemSlot and availableCash lists.
     * Sets the totalPaymentAmount to 0.0.
     */
    public VendingMachine() {
        this.itemSlot = new ArrayList<Slot>();
        this.availableCash = new ArrayList<MoneyDenomination>();
        this.transactions = new ArrayList<Transaction>();
        this.startingInventory = new ArrayList<Slot>();
        this.endingInventory = new ArrayList<Slot>();
        this.totalPaymentAmount = 0.0;
    }

    /**
     * Retrieves the list of item slots in the vending machine.
     * 
     * @return the list of item slots
     */
    public ArrayList<Slot> getItemSlot() {
        return itemSlot;
    }

    /**
     * Retrieves the list of available money denominations in the vending machine.
     * 
     * @return the list of available money denominations
     */
    public ArrayList<MoneyDenomination> getAvailableCash() {
        return availableCash;
    }

    /**
     * Initializes the slots in the vending machine.
     * Creates and adds eight slots to the itemSlot list.
     */
    public void initializeSlots() {
        itemSlot.add(new Slot("Slot1"));
        itemSlot.add(new Slot("Slot2"));
        itemSlot.add(new Slot("Slot3"));
        itemSlot.add(new Slot("Slot4"));
        itemSlot.add(new Slot("Slot5"));
        itemSlot.add(new Slot("Slot6"));
        itemSlot.add(new Slot("Slot7"));
        itemSlot.add(new Slot("Slot8"));
        itemSlot.add(new Slot("Slot9"));
    }

    /**
     * Initializes the available denominations of money in the vending machine.
     * Creates and adds different MoneyDenomination instances to the availableCash
     * list.
     */
    public void initializeMoney() {
        availableCash.add(new MoneyDenomination("One Thousand-Bills", 1000.0));
        availableCash.add(new MoneyDenomination("Five Hundred-Bills", 500.0));
        availableCash.add(new MoneyDenomination("Two Hundred-Bills", 200.0));
        availableCash.add(new MoneyDenomination("One Hundred-Bills", 100.0));
        availableCash.add(new MoneyDenomination("Fifty-Bills", 50.0));
        availableCash.add(new MoneyDenomination("Twenty-Bills", 20.0));
        availableCash.add(new MoneyDenomination("Ten-Coins", 10.0));
        availableCash.add(new MoneyDenomination("Five-Coins", 5.0));
        availableCash.add(new MoneyDenomination("One-Coins", 1.0));
        availableCash.add(new MoneyDenomination("25-Centavos", 0.25));
    }

    /**
     * Displays the slots in the vending machine.
     */
    public void displaySlots() {
        for (Slot slot : itemSlot) {
            System.out.println("Slot name: " + slot.getSlotName());
        }
        System.out.println();
    }

    // Vending Features

    /**
     * Sets the item for a specific slot in the vending machine by prompting the
     * user to enter the item details.
     *
     * @param slotIndex The index of the slot to set the item for.
     */

    public void setSlotItem(int slotIndex) {
        Slot tempSlot = itemSlot.get(slotIndex);

        System.out.println("Add Slot Item");

        System.out.print("Enter the item name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Enter the item price: ");
        float price = scanner.nextFloat();

        System.out.print("Enter the item's amount of calories: ");
        float calories = scanner.nextFloat();
        /////
        tempSlot.setItem(new Item(name, price, calories));

        System.out.print("Enter the item's initial stock: ");
        int quantity = scanner.nextInt();
        if (quantity < 10) {
            tempSlot.addQuantity(quantity);
            tempSlot.setInitialQuantity(quantity);
        } else {
            System.out.println("UNSUCCESSFUL STOCKING");

        }

        System.out.println("Item set successfully.");

    }

    /**
     * Displays the available cash denominations in the vending machine.
     */
    public void displayAvailableCash() {
        int counter = 1;
        System.out.println("Available Cash: ");
        for (MoneyDenomination money : availableCash) {
            System.out.println(counter + ". " + money.getCurrencyName() + " || " + money.getCurrency() + " x "
                    + money.getNumCurrency() + " || " + "Total Amount = " + money.getTotalValue());
            counter++;
        }
        System.out.println();
    }

    /**
     * Calculates and returns the total balance of cash in the vending machine.
     *
     * @return The total balance of cash in the vending machine.
     */
    public double inquireBalance() {
        double sum = 0;
        for (MoneyDenomination money : availableCash) {
            sum += money.getNumCurrency() * money.getCurrency();
        }
        return sum;
    }

    /**
     * Allows the user to replenish the cash in the vending machine by adding more
     * money.
     */
    public void replenishMoney() {
        for (MoneyDenomination money : availableCash) {
            System.out.print("How many " + money.getCurrencyName() + " do you want to add? ");
            int amt = scanner.nextInt();
            money.depositMoney(amt);
            System.out.println();
        }

    }

    /**
     * Allows the user to withdraw money from the vending machine.
     */
    public void withdrawMoney() {
        double totalWD = 0;
        for (MoneyDenomination money : availableCash) {
            System.out.println(money.getCurrencyName() + " || " + money.getCurrency() + " x " + money.getNumCurrency()
                    + " || " + "Total Amount = " + money.getTotalValue());
            System.out.print("How many " + money.getCurrencyName() + " do you want to withdraw?");
            int amt = scanner.nextInt();
            if (amt <= money.getNumCurrency()) {
                money.withdrawMoney(amt);

                System.out
                        .println("Remaining balance: " + money.getCurrencyName() + " || " + money.getCurrency() + " x "
                                + money.getNumCurrency() + " || " + "Total Amount = " + money.getTotalValue());
                totalWD = amt * money.getCurrency();
            }

            else {
                do {
                    System.out.println("Please enter a valid number.");
                    amt = scanner.nextInt();
                } while (amt > money.getNumCurrency());
            }

        }
        System.out.println("You have withdrawn a total amount of PHP" + totalWD + ". Your current balance is "
                + inquireBalance() + ".");
    }

    /**
     * Restocks an item in the vending machine by incrementing its quantity.
     *
     * @param index The index of the slot containing the item to restock.
     */
    public void restockItem(int index, int numStock) {
        itemSlot.get(index).addQuantity(numStock);
    }

    /**
     * Displays the items in the vending machine along with their prices and stock
     * quantities.
     * The display format is organized in columns for better readability.
     */
    public void displaySlotItems() {

        System.out.println("============================================");
        System.out.println("|             VENDING MACHINE              |");
        System.out.println("============================================");
        System.out.println("|   Slot   |   Item    |   Price   | Stock |");
        System.out.println("============================================");

        int counter = 1;
        for (Slot temp : itemSlot) {
            String slotNumber = String.format("| %1$-8s",
                    "Slot " + String.format("%1$-" + getMaxSlotDigits() + "s", counter));
            String itemName;
            String price;
            String stock;

            if (temp.getDesignatedItem() != null) {
                itemName = padString(temp.getDesignatedItem().getName(), 10);
                price = "PHP " + String.format("%.2f", temp.getDesignatedItem().getPrice());
                stock = String.valueOf(temp.getItemQuantity());
            } else {
                itemName = "UNOCCUPIED";
                price = "PHP 0.00";
                stock = "0";
            }

            System.out.println(
                    "|" + slotNumber + "|" + itemName + "|" + padString(price, 8) + " | " + padString(stock, 6) + " |");
            counter++;
        }

        System.out.println("============================================");
    }

    /**
     * Displays the items in the vending machine along with their calorie
     * information.
     * The display format is organized in columns for better readability.
     */
    public void displaySlotCalories() {
        System.out.println("=================================");
        System.out.println("|       VENDING MACHINE          |");
        System.out.println("==================================");
        System.out.println("|  Slot  |   Item    |  Calories |");
        System.out.println("==================================");

        int counter = 1;
        for (Slot temp : itemSlot) {
            String slotNumber = String.format("| %1$-6s",
                    "Slot " + String.format("%1$-" + getMaxSlotDigits() + "s", counter));
            String itemName;
            String calories;

            if (temp.getItem() != null) {
                itemName = padString(temp.getDesignatedItem().getName(), 10);
                calories = String.valueOf(temp.getDesignatedItem().getCalories());
            } else {
                itemName = "UNOCCUPIED";
                calories = "0";
            }

            System.out.println("|" + slotNumber + "|" + itemName + "|" + padString(calories, 9) + " |");
            counter++;
        }

        System.out.println("==================================");
    }

    /**
     * Displays the items in the vending machine along with their stock quantities.
     * The display format is organized in columns for better readability.
     */
    public void displayStockStocks() {

        System.out.println("=================================");
        System.out.println("|       VENDING MACHINE          |");
        System.out.println("==================================");
        System.out.println("|  Slot  |   Item    |   Stock   |");
        System.out.println("==================================");

        int counter = 1;
        for (Slot temp : itemSlot) {
            String slotNumber = String.format("| %1$-6s",
                    "Slot " + String.format("%1$-" + getMaxSlotDigits() + "s", counter));
            String itemName;
            String stock;

            if (temp.getItem() != null) {
                itemName = padString(temp.getDesignatedItem().getName(), 10);
                stock = String.valueOf(temp.getItemQuantity());
            } else {
                itemName = "UNOCCUPIED";
                stock = "0";
            }

            System.out.println("|" + slotNumber + "|" + itemName + "|" + padString(stock, 9) + " |");
            counter++;
        }

        System.out.println("==================================");
    }

    /**
     * Calculates the maximum number of digits required to display the slot numbers.
     *
     * @return The maximum number of digits required for slot numbers.
     */
    private int getMaxSlotDigits() {
        int maxSlotNumber = itemSlot.size();
        return Math.max((int) (Math.log10(maxSlotNumber) + 1), 2);
    }

    /**
     * Pads a string with spaces to match the specified length.
     *
     * @param text   The original string.
     * @param length The desired length of the string after padding.
     * @return The padded string.
     */
    private String padString(String text, int length) {
        if (text.length() < length) {
            StringBuilder paddedText = new StringBuilder(text);
            while (paddedText.length() < length) {
                paddedText.append(" ");
            }
            return paddedText.toString();
        }
        return text;
    }

    /**
     * Accepts payment from the user by allowing them to insert money into the
     * vending machine.
     * Keeps track of the total payment amount.
     */
    public void acceptPayment() {
        double totalInsertedMoney = 0;

        // Display the available denominations
        System.out.println("\n[ Available Money to Insert ]\n");
        for (int i = 0; i < availableCash.size(); i++) {
            MoneyDenomination denomination = availableCash.get(i);
            System.out.println((i + 1) + ". " + denomination.getCurrencyName());
        }

        boolean insertMore = true;
        while (insertMore) {
            System.out.print("\nEnter the denomination number: ");
            int denominationNumber = scanner.nextInt();

            if (denominationNumber >= 1 && denominationNumber <= availableCash.size()) {
                MoneyDenomination selectedDenomination = availableCash.get(denominationNumber - 1);
                System.out.print("Enter the amount: ");
                int amount = scanner.nextInt();

                selectedDenomination.depositMoney(amount);
                totalInsertedMoney += amount * selectedDenomination.getCurrency();
                this.totalPaymentAmount += selectedDenomination.getCurrency() * amount;
                System.out.println(
                        "\n[ Payment accepted: " + amount + " " + selectedDenomination.getCurrencyName() + " ]");
                System.out.println("[ Total value of " + selectedDenomination.getCurrencyName() + ": PHP"
                        + selectedDenomination.getCurrency() * amount + " ]\n");
                System.out.println("\n[ Total inserted money: " + totalInsertedMoney + " ]\n");

            } else {
                System.out.println("\n[ Invalid denomination number. ]\n");
            }

            // Ask if the user wants to insert more money
            System.out.print("Do you want to insert more money? (yes/no): ");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("no")) {
                insertMore = false;
            }
        }
    }

    /**
     * Dispenses an item from the vending machine to the user, based on the selected
     * slot number.
     * Calculates the change and updates the item quantity if the payment is
     * sufficient.
     */
    public void dispenseItem() {
        double change = 0;

        // Display the available items
        displaySlotItems();

        System.out.println("Choose the function: ");
        System.out.println("1. Purchase an item ");
        System.out.println("2. Cancel the purchase ");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        if (choice == 2) {
            cancelPurchase();
            totalPaymentAmount = 0; // Reset totalPaymentAmount to 0
        } else {
            System.out.print("Enter the slot number to dispense item: ");
            int slotNumber = scanner.nextInt() - 1;

            if (slotNumber >= 0 && slotNumber < itemSlot.size()) {
                Slot selectedSlot = itemSlot.get(slotNumber);
                Item item = selectedSlot.getDesignatedItem();

                if (item != null) {
                    System.out.println();
                    System.out.println("[ Selected item: " + item.getName() + " ]");
                    System.out.println("[ Price: " + item.getPrice() + " ]");

                    double amountInserted = totalPaymentAmount;

                    boolean temp = checkChange(amountInserted - item.getPrice());

                    // if funds are sufficient
                    if (amountInserted >= item.getPrice() && temp == true) {
                        change = amountInserted - item.getPrice();
                        System.out.println("\n[ Dispensing item: " + item.getName() + " ]");
                        System.out.println("Change: " + change);

                        // updates transaction summary
                        boolean transactionFound = false;
                        Iterator<Transaction> iterator = transactions.iterator();
                        while (iterator.hasNext()) {
                            Transaction tr = iterator.next();
                            if (tr.getItem().getName().equals(item.getName())) {
                                tr.addNumSold();
                                transactionFound = true;
                            }
                        }
                        if (!transactionFound) {
                            transactions.add(new Transaction(item, 1));
                        }

                        temp = produceChange(change);
                        this.totalPaymentAmount = change;
                        // Destroys 1 instance of the slot item
                        selectedSlot.decQuantity();

                        // If the quantity becomes zero, remove the item from the slot
                        if (selectedSlot.getItemQuantity() == 0) {
                            selectedSlot.setItem(null);
                        }

                    } else { // if funds are insufficient
                        if (amountInserted < item.getPrice()) {
                            System.out.println("Insufficient funds.");
                            cancelPurchase();
                        } else {
                            informInsufficientChange();
                            cancelPurchase();
                        }

                        totalPaymentAmount = 0; // Reset totalPaymentAmount to 0
                    }
                } else {
                    System.out.println("Slot is empty. Please select a slot with an item.");
                }
            } else {
                System.out.println("Invalid slot number.");
            }

            totalPaymentAmount = 0; // Reset totalPaymentAmount to 0 after a successful purchase
        }
    }

    /**
     * Calculates and displays the change to be returned to the user.
     * Deducts the appropriate denominations from the available cash in the vending
     * machine.
     * 
     * @param amount is the change needed to be dispensed
     * @retun true if change can be dispensed with the available cash, false
     *        otherwise
     */
    public boolean produceChange(double amount) {
        // Create a copy of availableCash to track remaining denominations
        List<MoneyDenomination> remainingDenominations = new ArrayList<>(availableCash);

        // Calculate and display the change in different denominations
        System.out.println("\nCalculating total change . . .");
        for (MoneyDenomination denomination : remainingDenominations) {
            double denominationValue = denomination.getCurrency();
            if (amount >= denominationValue && denomination.getNumCurrency() > 0) {
                int numDenominations = (int) (amount / denominationValue);
                numDenominations = Math.min(numDenominations, denomination.getNumCurrency()); // Limit to available
                                                                                              // denominations
                amount -= denominationValue * numDenominations;
                denomination.setNumCurrency(denomination.getNumCurrency() - numDenominations); // Update remaining
                                                                                               // denominations
                System.out
                        .println("[ Dispensing < " + numDenominations + " > " + denomination.getCurrencyName() + " ]");
            }
        }

        // Check if the machine was able to produce exact change or not
        if (amount == 0) {
            return true; // Exact change dispensed
        } else {
            System.out.println("The machine cannot produce the requested change. Please enter the exact denomination.");
            return false; // Exact change not possible
        }

    }

    /**
     * Calculates the change to be returned to the user.
     * Deducts the appropriate denominations from the available cash in the vending
     * machine.
     * 
     * @param amount is the change needed to be dispensed
     * @retun true if change can be dispensed with the available cash, false
     *        otherwise
     */
    public boolean checkChange(double amount) {
        // Calculate and display the change in different denominations
        for (MoneyDenomination denomination : availableCash) {
            double denominationValue = denomination.getCurrency();
            if (denomination.getNumCurrency() > 0) {
                if (amount >= denominationValue) {
                    int numDenominations = (int) (amount / denominationValue);
                    amount -= denominationValue * numDenominations;
                }
            }
        }

        if (amount > 0) {
            return false;
        }
        return true;
    }

    /**
     * Cancels the current purchase and returns the money to the user.
     */
    public void cancelPurchase() {
        System.out.println("Canceling purchase. Returning money: PHP" + totalPaymentAmount);
        produceChange(totalPaymentAmount);
        totalPaymentAmount = 0.0;
    }

    /**
     * Informs the user that there is insufficient change in the vending machine to
     * complete the transaction.
     */
    public void informInsufficientChange() {
        System.out.println("Not enough change. Transaction canceled.");
    }

    /**
     * Displays the calorie count for each item in the vending machine.
     */
    public void displayCalories() {
        System.out.println("Calories per item:");
        for (Slot slot : itemSlot) {
            Item item = slot.getDesignatedItem();
            if (item != null) {
                System.out.println(item.getName() + ": " + item.getCalories());
            }
        }
    }

    /**
     * Displays a summary of the transactions, including the sold items, quantities,
     * and total sales.
     */
    public void displayTransactionsStock() {
        System.out.println("[ Summary of Transactions ] ");
        int counter = 1;
        double totalIncome = 0;
        if (transactions.size() == 0)
            System.out.println("No transactions yet. ");
        for (Transaction transaction : transactions) {
            double itemIncome = transaction.getNumSold() * transaction.getItem().getPrice();
            System.out.println(counter++ + ". Sold : " + transaction.getItem().getName() + " || Quantity: "
                    + transaction.getNumSold()
                    + " x " + transaction.getItem().getPrice() + " || Total Amount Sold: " + itemIncome);
            totalIncome += itemIncome;
        }
        System.out.println("Total Sales = " + totalIncome);
    }

    /**
     * Stores the starting inventory by adding non-null slots to the
     * startingInventory list.
     */
    public void storeStartingInventory() {
        for (Slot slot : itemSlot) {
            if (slot.getItem() != null) {
                startingInventory.add(slot);
                // System.out.println("Item: " + slot.getItem().getName() + " - Stock [ " +
                // slot.getItem().getQuantity() + " ]");
            }
        }
    }

    /**
     * Displays the starting inventory, including the item names and initial stock
     * quantities.
     */
    public void displayStartingInventory() {
        for (Slot slot : startingInventory) {
            if (slot.getItem() != null)
                System.out.println("Item: " + slot.getDesignatedItem().getName() + " - Stock [ "
                        + slot.getInitialQuantity() + " ]");
            else
                System.out.println("Item: " + "UNOCCUPIED" + " - Stock [ " + "0" + " ]");
        }
    }

    /**
     * Displays the ending inventory, including the item names and current stock
     * quantities.
     */
    public void displayEndingInventory() {
        for (Slot slot : endingInventory) {
            if (slot.getItem() != null)
                System.out.println(
                        "Item: " + slot.getDesignatedItem().getName() + " - Stock [ " + slot.getItemQuantity() + " ]");
            else
                System.out.println("Item: " + "UNOCCUPIED" + " - Stock [ " + "0" + " ]");
        }
    }

    /**
     * Stores the ending inventory by adding non-null slots to the endingInventory
     * list,
     * considering only unique items.
     */
    public void storeEndingInventory() {
        List<Item> uniqueItems = new ArrayList<>();

        for (Slot slot : itemSlot) {
            Item item = slot.getDesignatedItem();
            if (item != null && !isItemInList(uniqueItems, item)) {
                endingInventory.add(slot);
                uniqueItems.add(item);
            }
        }
    }

    /**
     * Checks if an item is already present in the given item list.
     *
     * @param itemList The list of items to check.
     * @param item     The item to search for.
     * @return {@code true} if the item is found in the list, {@code false}
     *         otherwise.
     */
    private boolean isItemInList(List<Item> itemList, Item item) {
        for (Item listItem : itemList) {
            if (listItem.equals(item)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tests the vending machine features based on the user's choice.
     * 
     * @param choice the user's choice for testing a specific feature
     */
    public void testVendingFeatures(int choice) {
        int temp;
        switch (choice) {
            case 1:
                // insert money
                displaySlotItems();
                System.out.println();
                System.out.println("1. Insert money into the Vending Machine");
                System.out.println("2. Cancel purchase");
                System.out.print("\n\tEnter your choice: ");
                temp = scanner.nextInt();

                if (temp == 1) {
                    acceptPayment();
                    dispenseItem();
                } else if (temp == 2) {
                    System.out.println("\n[ Canceling Purchase . . . ]");
                    break;
                } else
                    System.out.println("[ Enter valid choice. ]");
                displaySlotItems();
                break;

            case 2:
                // view calories
                displaySlotCalories();
                // displayCalories();
                break;

            case 3:
                System.out.println("\nDisabling Maintenance Testing Mode...\n");
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    /**
     * Tests the maintenance features of the vending machine based on the user's
     * choice.
     * 
     * @param choice the user's choice for testing a specific maintenance feature
     */
    public void testMaintenanceFeatures(int choice) {
        int index;
        switch (choice) {

            case 1:
                // addSlot();
                int i = 0, flag = 0;

                System.out.println("Stocking Items. . .");
                while (flag == 0 && i < itemSlot.size()) {
                    displaySlotItems();
                    System.out.print("Enter the slot you wish to put item in (type -1 to stop adding items): ");
                    int slot = scanner.nextInt();
                    slot -= 1;
                    if (slot + 1 > 0) {
                        if (itemSlot.get(slot).getDesignatedItem() == null) {
                            setSlotItem(slot);
                            i++;
                        } else {
                            System.out.println("Slot is already occupied. Select another slot."); // loop
                        }
                    } else
                        flag = 1;
                }
                storeStartingInventory();

                break;
            case 2:
                displayStockStocks();
                System.out.print("Enter item you wish to restock: ");
                index = scanner.nextInt() - 1;
                if (itemSlot.get(index).getItem() != null) {
                    System.out.print("Enter number of items you wish to stock: ");
                    int numStock = scanner.nextInt();
                    restockItem(index, numStock);
                    System.out.println(
                            "Succesfully added " + numStock + itemSlot.get(index).getDesignatedItem().getName());
                    System.out.println(itemSlot.get(index).getDesignatedItem().getName() + " Stock = "
                            + itemSlot.get(index).getItemQuantity());
                } else
                    System.out.println("Slot is unoccupied. Choose an occupied slot."); // loop
                displayStockStocks();
                break;

            case 3:
                displaySlotItems();
                System.out.print("Enter item you wish to reprice: ");
                index = scanner.nextInt() - 1;
                if (itemSlot.get(index).getItem() != null) {

                    System.out.print("Enter new price: ");
                    float newPrice = scanner.nextFloat();

                    itemSlot.get(index).getDesignatedItem().setPrice(newPrice);
                    displaySlotItems();
                } else
                    System.out.println("Slot is unoccupied. Choose an occupied slot.");
                break;
            case 4:
                // withdrawing money
                System.out.print("Current Cash Available: ");
                displayAvailableCash();
                System.out.println();
                withdrawMoney();
                System.out.println();
                System.out.print("Remaining Cash Available: ");
                displayAvailableCash();
                System.out.println();
                break;

            case 5:
                replenishMoney();
                break;

            case 6:
                System.out.println("[ Displaying Summary of Transactions. . . ] \n");
                displayTransactionsStock();

                System.out.println("\n[ Displaying starting inventory... ]\n");
                displayStartingInventory();

                System.out.println("\n[ Displaying ending inventory... ]\n");
                storeEndingInventory();
                displayEndingInventory();
                break;

            case 7:
                System.out.println("\nDisabling Maintenance Testing Mode...\n");
                break;

            default:
                System.out.println("Invalid choice. Please choose a valid option.");
        }
    }

    /**
     * Closes the scanner object if it is not null.
     */
    public void closeScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }

}
