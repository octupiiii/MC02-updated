import java.util.*;

/**
 * Class representing the main entry point of the vending machine program.
 */
public class Main {
	/**
	 * The main method that runs the vending machine program.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachine();
		VendingMachine specialVM = new SpecialVendingMachine();

		Scanner scanner = new Scanner(System.in);
		Menu menu = new Menu();
		int flag = 0;
		boolean initialized = false;

		do {
			flag = menu.mainMenu();
			if (flag == 1 || flag == 2 || flag == 3) {
				switch (flag) {
					case 1:
						if (!initialized) {

							// vendingMachine.displaySlots();
							int vmChoice = menu.chooseVM();

							if (vmChoice == 1) {

								vendingMachine.initializeSlots();
								vendingMachine.initializeMoney();
								initialized = true;
								System.out.println("\n[ Regular Vending Machine has been Created. ]\n");
							} else if (vmChoice == 2) {

								initialized = true;
								System.out.println("\n[ Sorry. This feature is currently locked. ]\n");
							} else
								System.out.println("\n[ Invalid valid choice. ]\n");

						} else
							System.out.println("\n[ Error: A Vending Machine has already been created. ]\n");
						break;
					case 2:
						if (initialized) {
							int vmTest = menu.testVendingMachine();
							if (vmTest == 1) {
								vendingMachine.testVendingFeatures(menu.testVendingFeatures());
							} else if (vmTest == 2) {
								vendingMachine.testMaintenanceFeatures(menu.testMaintenanceFeatures());
							} else
								System.out.println("Input valid choice.");
						} else
							System.out.println("\n[ Error: Vending Machine has not yet been created ]\n");

						break;
					case 3:
						System.out.println("\n[ Thank you for availing our services! ]\n");
						break;
				}
			} else
				System.out.println("Input valid choice.");
		} while (flag != 3);
		scanner.close();
	}
}
