package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;

public class AirportInfo {
    private JPanel airportInfoPanel;

    public static void buildScene() {
        SceneBuilder.buildScene("ARFS: Airport Info", new AirportInfo().airportInfoPanel, new Dimension(400, 288), JFrame.DISPOSE_ON_CLOSE);
    }
}
