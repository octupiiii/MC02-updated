package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MaintenanceVM extends JPanel {
    private JTextField nameField;
    private JTextField priceField;
    private JTextField caloriesField;
    private JTextField stockField;

    public MaintenanceVM() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Panel 1: Add buttons
        JPanel panel1 = createPanelWithButtons();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        add(panel1, constraints);

        // Panel 2: Empty
        JPanel panel2 = new JPanel();
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(panel2, constraints);

        // Panel 3: Empty
        JPanel panel3 = new JPanel();
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        add(panel3, constraints);
    }

    private JPanel createPanelWithButtons() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));

        // Add 9 buttons to the panel
        for (int i = 1; i <= 9; i++) {
            JButton button = new JButton("Button " + i);
            button.addActionListener(new ButtonActionListener());
            panel.add(button);
        }

        return panel;
    }

    private static class ButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Handle button click action here
            JButton button = (JButton) e.getSource();
            String buttonText = button.getText();
    
            // Customize the JOptionPane options
            Object[] options = {"Add Item", "Close"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Button clicked: " + buttonText,
                    "Button Clicked",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]);
    
            if (choice == JOptionPane.YES_OPTION) {
                // If "Add Item" is clicked, show another JOptionPane to get item details
                JPanel panel = new JPanel(new GridLayout(4, 2));
                panel.add(new JLabel("Name:"));
                JTextField nameField = new JTextField(15);
                panel.add(nameField);
    
                panel.add(new JLabel("Price:"));
                JTextField priceField = new JTextField(15);
                panel.add(priceField);
    
                panel.add(new JLabel("Calories:"));
                JTextField caloriesField = new JTextField(15);
                panel.add(caloriesField);
    
                panel.add(new JLabel("Stock:"));
                JTextField stockField = new JTextField(15);
                panel.add(stockField);
    
                int result = JOptionPane.showConfirmDialog(null, panel, "Enter Item Details", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    
                if (result == JOptionPane.OK_OPTION) {
                    // Process the entered item details here
                    String name = nameField.getText();
                    double price = 0.0;
                    double calories = 0.0;
                    int stock = 0;
    
                    try {
                        price = Double.parseDouble(priceField.getText());
                        calories = Double.parseDouble(caloriesField.getText());
                        stock = Integer.parseInt(stockField.getText());
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for price, calories, and stock.",
                                "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
    
                    // Here you can use the name, price, calories, and stock variables as needed
                    System.out.println("Item added: " + buttonText);
                    System.out.println("Name: " + name);
                    System.out.println("Price: " + price);
                    System.out.println("Calories: " + calories);
                    System.out.println("Stock: " + stock);
                }
            }
        }
    }
    
}
