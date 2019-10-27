package Helpers;

import javax.swing.*;
import java.awt.*;

public class SceneBuilder {
    public static void buildScene(String title, Container contentPane, Dimension size, int closeOperation) {

        /**
         * Setup Window
         */
        JFrame frame = new JFrame(title);
        frame.setContentPane(contentPane);
        frame.setSize(size);
        frame.setMaximumSize(size);
        frame.setMinimumSize(size);
        frame.setDefaultCloseOperation(closeOperation);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);

        /**
         * Center Window
         */
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }
}
