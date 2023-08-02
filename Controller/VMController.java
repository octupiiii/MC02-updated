package Controller;

import View.First;
import View.MainFrame;
import View.VendingVM;
import Model.Model;

import java.io.File;
import java.text.Normalizer.Form;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import javax.swing.*;

public class VMController {

    private First first;
    private VendingVM vendingVM;

    public VMController(First first, VendingVM vendingVM) {
        this.first = first;
        Model model = new Model();

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
                    model.setVMStatus(true);
                } else if (choice == JOptionPane.NO_OPTION) {
                    JOptionPane.showMessageDialog(this.first, "You Successfully Created a Special Vending Machine!");
                    model.setVMStatus(true);
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
                        first.setVisible(false);
                        vendingVM.setVisible(true);
                    } else if (choice == JOptionPane.NO_OPTION)
                        System.out.print("MAINTENANCE");
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

}
