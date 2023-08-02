package Controller;

import View.*;
import Model.*;

import java.awt.GridLayout;
import java.io.File;
import java.text.Normalizer.Form;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.*;

public class VMController {

    private First first;
    private MaintenanceVM maintenanceVM;
    private VendingVM vendingVM;
    private Model model;
    boolean svmStatus = false;

    public VMController(First first, MaintenanceVM maintenanceVM, VendingVM vendingVM) {
        this.first = first;

        this.first.createVM(e -> {

            JButton button = (JButton) e.getSource();
            String buttonLabel = button.getText();

            if (buttonLabel.equals("Create Vending Machine")) {
                String[] options = { "Regular", "Special" };
                int choice = JOptionPane.showOptionDialog(this.first,
                        "Choose an option for the Vending Machine:",
                        "Vending Machine Options", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        options,
                        options[0]);

                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(this.first, "You Successfully Created a Regular Vending Machine!");
                    model = new Model(new VendingMachine());
                    model.setVMStatus(true);
                } else if (choice == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(this.first, "You Successfully Created a Special Vending Machine!");
                    model = new SVMModel(new SpecialVendingMachine());
                    model.setVMStatus(true);
                    svmStatus = true;
                }
            }

        });

        this.first.testVM(e -> {
            JButton button = (JButton) e.getSource();
            String buttonLabel = button.getText();
            if (buttonLabel.equals("Test Vending Machine")) {
                if (model.getVMStatus()) {
                    String[] options = { "Vending Features", "Maintenance Features" };
                    int choice = JOptionPane.showOptionDialog(this.first,
                            "Choose an option for the Vending Machine",
                            "Vending Machine Options", JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null,
                            options,
                            options[0]);

                    if (choice == JOptionPane.YES_OPTION) {
                        System.out.print("VENDING");
                        first.setVisible(false);
                        vendingVM.setVisible(true);
                        model.setVMStatus(true);
                    } else if (choice == JOptionPane.NO_OPTION) {
                        System.out.print("MAINTENANCE");
                        first.setVisible(false);
                        maintenanceVM.setVisible(true);
                        model.setVMStatus(true);
                    }
                        
   
                } else
                    // Show an error message if the vending machine is not created yet
                    JOptionPane.showMessageDialog(this.first, "Please create a vending machine first!");

            }

        });

        this.first.exit(e ->

        {
            System.exit(0);
        });

        

    }

    public void setInfo(int index, String name, double price, double calories, int stock) {
        Slot tempSlot = model.getVendingMachine().getItemSlot().get(index);
        Item tempItem = new Item(name, price, calories);
        System.out.println("Item set successfully.");

        tempSlot.setSlotName(name);
        tempSlot.setItem(tempItem);
    }

    public void stockItem(int slotIndex, int quantity) {
        Slot tempSlot = model.getVendingMachine().getItemSlot().get(slotIndex);
        if (quantity <= 10) {
            tempSlot.addQuantity(quantity);
            tempSlot.setInitialQuantity(quantity);
        } else
        System.out.println("Error Stock");
    }



}
