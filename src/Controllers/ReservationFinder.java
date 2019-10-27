package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;

public class ReservationFinder {
    private JPanel reservationFinderPanel;

    public static void buildScene() {
        SceneBuilder.buildScene("AFRS: Reservation Finder", new ReservationFinder().reservationFinderPanel, new Dimension(400, 288), JFrame.DISPOSE_ON_CLOSE);
    }
}
