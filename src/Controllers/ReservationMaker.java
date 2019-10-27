package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;

public class ReservationMaker {
    private JPanel reservationMakerPanel;

    public static void buildScene() {
        SceneBuilder.buildScene("ARFS: Reservation Maker", new ReservationMaker().reservationMakerPanel, new Dimension(400, 288), JFrame.DISPOSE_ON_CLOSE);
    }
}
