package View;

import Controller.VMController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public MainFrame() {
        super("ICE ICE BaBY");
        cardLayout = new CardLayout();
        First first = new First();
        VendingVM vendingVM = new VendingVM();

        // sets our layout as a card layout
        setLayout(cardLayout);

        new VMController(first, vendingVM);

        add(first, "Main Menu");
        add(vendingVM, "Vending Features");

        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
