package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationMaker {
    private JPanel reservationMakerPanel;
    private JTextField passengerNameTextfield;
    private JButton submitButton;
    private JTextField itineraryIDTextField;

    public ReservationMaker() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passengerNameTextfield.getText().equals("") || itineraryIDTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Please enter both Passenger name and Itinerary ID.",
                            "Missing Required Inputs",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String command = "reserve," + itineraryIDTextField.getText() + "," + passengerNameTextfield.getText() + ";";
                    System.out.println(command);
                }
            }
        });
    }

    public static void buildScene() {
        SceneBuilder.buildScene("ARFS: Reservation Maker", new ReservationMaker().reservationMakerPanel, new Dimension(400, 170), JFrame.DISPOSE_ON_CLOSE);
    }
}
