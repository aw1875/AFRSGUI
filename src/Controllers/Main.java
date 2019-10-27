package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    private JPanel mainPanel;
    private JButton itinerayFinderButton;
    private JButton reservationFinderButton;
    private JButton reservationMakerButton;
    private JButton airportInfoButton;

    public Main() {
        itinerayFinderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItineraryFinder.buildScene();
            }
        });
        reservationFinderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationFinder.buildScene();
            }
        });
        reservationMakerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReservationMaker.buildScene();
            }
        });
        airportInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AirportInfo.buildScene();
            }
        });
    }

    public static void main(String [] args) {
        SceneBuilder.buildScene("AFRS", new Main().mainPanel, new Dimension(500, 100), JFrame.EXIT_ON_CLOSE);
    }
}
