package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReservationFinder {
    private JPanel reservationFinderPanel;
    private JTextField passengerNameTextfield;
    private JComboBox filterComboBox;
    private JButton submitButton;
    private JTextField originAirportCode;
    private JTextField destinationAirportCode;

    public ReservationFinder() {
        /**
         * Hover event listeners
         */
        submitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                submitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                submitButton.setBackground(Color.decode("#4CAAEF"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                submitButton.setBackground(Color.decode("#3C97D9"));
            }
        });

        /**
         * Submit pressed listener
         */
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passengerNameTextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Please enter passenger name.",
                            "Missing Required Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String command = "retrieve," + passengerNameTextfield.getText() + "," + originAirportCode.getText() + "," + destinationAirportCode.getText() + ";";
                    System.out.println(command);
                }
            }
        });
    }

    public static void buildScene() {
        SceneBuilder.buildScene("AFRS: Reservation Finder", new ReservationFinder().reservationFinderPanel, new Dimension(400, 170), JFrame.DISPOSE_ON_CLOSE);
    }
}
