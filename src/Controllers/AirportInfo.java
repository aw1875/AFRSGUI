package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AirportInfo {
    private JPanel airportInfoPanel;
    private JTextField airportCodeTextField;
    private JButton submitButton;

    public AirportInfo() {
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (airportCodeTextField.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Please enter Airport Code.",
                            "Missing Required Input",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String command = "airport," + airportCodeTextField.getText() + ";";
                    System.out.println(command);
                }
            }
        });
    }

    public static void buildScene() {
        SceneBuilder.buildScene("ARFS: Airport Info", new AirportInfo().airportInfoPanel, new Dimension(400, 125), JFrame.DISPOSE_ON_CLOSE);
    }
}
