package Model;
import java.util.ArrayList;
import java.util.List;

public class SpecialVendingMachine extends VendingMachine {
    private List<CustomizableProduct> customizableProducts;

    public SpecialVendingMachine() {
        // Initialize the list of customizable products
        customizableProducts = new ArrayList<>();
    }

    public void addCustomizableProduct(CustomizableProduct product) {
        customizableProducts.add(product);
    }

    public void removeCustomizableProduct(CustomizableProduct product) {
        customizableProducts.remove(product);
    }

    public void displayCustomizableProducts() {
        System.out.println("Available Customizable Products:");
        for (int i = 0; i < customizableProducts.size(); i++) {
            System.out.println((i + 1) + ". " + customizableProducts.get(i).getName());
        }
    }

    /**
     * Tests the maintenance features of the vending machine based on the user's
     * choice.
     * 
     * @param choice the user's choice for testing a specific maintenance feature
     */

    @Override
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
                        if (itemSlot.get(slot).getItem() == null) {
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
                    System.out.println("Succesfully added " + numStock + itemSlot.get(index).getDesignatedItem().getName());
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
                System.out.println("\nStocking Customazable Product ");
                break;

            case 8:
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
