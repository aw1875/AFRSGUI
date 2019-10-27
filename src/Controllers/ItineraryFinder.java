package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ItineraryFinder {
    private JPanel itineraryPanel;
    private JTabbedPane tabbedPane1;
    private JTextField localOriginTextfield;
    private JTextField localDestinationTextfield;
    private JComboBox comboBox1;
    private JSpinner spinner1;
    private JButton localSubmitButton;
    private JTextField onlineOriginTextfield;
    private JTextField onlineDestinationTextfield;
    private JButton onlineSubmitButton;
    private JComboBox comboBox2;
    private JSpinner spinner2;
    private JButton connectButton;
    private JButton disconnectButton;

    public ItineraryFinder() {

        /**
         * Hover event listeners
         */
        localSubmitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                localSubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                localSubmitButton.setBackground(Color.decode("#4CAAEF"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                localSubmitButton.setBackground(Color.decode("#3C97D9"));
            }
        });
        onlineSubmitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                onlineSubmitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                onlineSubmitButton.setBackground(Color.decode("#4CAAEF"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                onlineSubmitButton.setBackground(Color.decode("#3C97D9"));
            }
        });
        connectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (connectButton.isEnabled()) {
                    connectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    connectButton.setBackground(Color.decode("#4CAAEF"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (connectButton.isEnabled()) {
                    connectButton.setBackground(Color.decode("#3C97D9"));
                }
            }
        });
        disconnectButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                if (disconnectButton.isEnabled()) {
                    disconnectButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    disconnectButton.setBackground(Color.decode("#4CAAEF"));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                if (disconnectButton.isEnabled()) {
                    disconnectButton.setBackground(Color.decode("#3C97D9"));
                }
            }
        });

        /**
         * Connect Pressed Event
         */
        connectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectButton.setEnabled(false);
                connectButton.setBackground(Color.decode("#E8E8E8"));
                disconnectButton.setEnabled(true);
                disconnectButton.setBackground(Color.decode("#3C97D9"));
            }
        });
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectButton.setEnabled(true);
                connectButton.setBackground(Color.decode("#3C97D9"));
                disconnectButton.setEnabled(false);
                disconnectButton.setBackground(Color.decode("#E8E8E8"));
            }
        });
    }

    public static void buildScene() {
        SceneBuilder.buildScene("AFRS: Itinerary Finder", new ItineraryFinder().itineraryPanel, new Dimension(400, 288), JFrame.DISPOSE_ON_CLOSE);
    }
}
