package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class VendingVM extends JPanel {

    private JButton[][] squareButtons; // 2D array to store the square buttons

    public VendingVM() {

        // Space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);

        // Uses GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        // Create the 3x3 grid of square buttons
        JPanel jpButtons = new JPanel(new GridLayout(4, 3, 3, 3));
        jpButtons.setBorder(new TitledBorder("Please make a selection"));
        JButton[] buttonGrid = new JButton[10];

        for (int i = 1; i < buttonGrid.length; i++) {
            buttonGrid[i] = new JButton(String.valueOf(i));
            jpButtons.add(buttonGrid[i]);
            // Add ActionListener to the buttons (listener should be defined elsewhere)
            // buttonGrid[i].addActionListener(listener);
        }

        // Place jpButtons in the layout
        gridBagConstraints.gridx = 3; // Column 3 (0-indexed) for the 3x3 grid, so it comes after the grid
        gridBagConstraints.gridy = 0; // Row 0
        gridBagConstraints.gridheight = 4; // Span 4 rows to match the grid
        gridBagConstraints.fill = GridBagConstraints.BOTH; // Allow vertical and horizontal resizing
        gridBagConstraints.weightx = 1.0; // Expand horizontally to fill space
        add(jpButtons, gridBagConstraints);
    }

    // Getter method to access the square buttons from other classes
    public JButton[][] getSquareButtons() {
        return squareButtons;
    }
}
