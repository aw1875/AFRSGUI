package Controllers;

import Helpers.SceneBuilder;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;

public class ItineraryFinder {
    private JPanel itineraryPanel;
    private JTabbedPane tabbedPane1;
    private JTextField localOriginTextfield;
    private JTextField localDestinationTextfield;
    private JComboBox localSortingMethod;
    private JSpinner localConnections;
    private JButton localSubmitButton;
    private JTextField onlineOriginTextfield;
    private JTextField onlineDestinationTextfield;
    private JButton onlineSubmitButton;
    private JComboBox onlineSortingMethod;
    private JSpinner onlineConnections;
    private JButton connectButton;
    private JButton disconnectButton;

    public ItineraryFinder() {

        /**
         * Set Connection Spinners up
         */
        localConnections.setModel(new SpinnerNumberModel(0, 0, 2, 1));
        onlineConnections.setModel(new SpinnerNumberModel(0, 0, 2, 1));

        /**
         * Set Sorting Method Combobox's up
         */
        String [] sortMethods = {"Departure Time (Default)", "Arrival Time", "Airfare"};
        for (int i = 0; i < sortMethods.length; i++) {
            localSortingMethod.addItem(sortMethods[i]);
            onlineSortingMethod.addItem(sortMethods[i]);
        }

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
                /**
                 * Disable connect button
                 * Enable submit and disconnect buttons
                 */
                connectButton.setEnabled(false);
                connectButton.setBackground(Color.decode("#E8E8E8"));
                onlineSubmitButton.setEnabled(true);
                onlineSubmitButton.setBackground(Color.decode("#3C97D9"));
                disconnectButton.setEnabled(true);
                disconnectButton.setBackground(Color.decode("#3C97D9"));

                /**
                 * Make connection
                 */
                // TODO: create connection
            }
        });

        /**
         * Disconnect Pressed Event
         */
        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Disable submit and disconnect buttons
                 * Enable connect button
                 */
                connectButton.setEnabled(true);
                connectButton.setBackground(Color.decode("#3C97D9"));
                onlineSubmitButton.setEnabled(false);
                onlineSubmitButton.setBackground(Color.decode("#E8E8E8"));
                disconnectButton.setEnabled(false);
                disconnectButton.setBackground(Color.decode("#E8E8E8"));

                /**
                 * Disconnect
                 */
                // TODO: disconnect
            }
        });

        /**
         * Switched Tab Event
         */
        tabbedPane1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                JTabbedPane tabbedPane = (JTabbedPane) changeEvent.getSource();
                int selectedIndex = tabbedPane.getSelectedIndex();

                if (selectedIndex == 0) {
                    //TODO: add disconnect functionality & remove print
                    System.out.println("Changed to Local Tab");
                }
            }
        });

        /**
         * Submit button events
         */
        localSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (localOriginTextfield.getText().equals("") || localDestinationTextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Please enter both Origin and Destination airport codes.",
                            "Missing Inputs",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String sortMethod = "";
                    switch (localSortingMethod.getSelectedIndex()) {
                        case 0:
                            sortMethod = "departure";
                            break;
                        case 1:
                            sortMethod = "arrival";
                            break;
                        case 2:
                            sortMethod = "airfare";
                            break;
                    }
                    String command = "info," + localOriginTextfield.getText() + "," + localDestinationTextfield.getText() + "," + localConnections.getValue() + "," + sortMethod + ";";
                    System.out.println(command);
                }
            }
        });
        onlineSubmitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (onlineOriginTextfield.getText().equals("") || onlineDestinationTextfield.getText().equals("")) {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
                            "Please enter both Origin and Destination airport codes.",
                            "Missing Inputs",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    String sortMethod = "";
                    switch (onlineSortingMethod.getSelectedIndex()) {
                        case 0:
                            sortMethod = "departure";
                            break;
                        case 1:
                            sortMethod = "arrival";
                            break;
                        case 2:
                            sortMethod = "airfare";
                            break;
                    }
                    String command = "info," + onlineOriginTextfield.getText() + "," + onlineDestinationTextfield.getText() + "," + onlineConnections.getValue() + "," + sortMethod + ";";
                    System.out.println(command);
                }
            }
        });
    }

    /**
     * Build the Scene using SceneBuilder helper class
     */
    public static void buildScene() {
        SceneBuilder.buildScene("AFRS: Itinerary Finder", new ItineraryFinder().itineraryPanel, new Dimension(400, 288), JFrame.DISPOSE_ON_CLOSE);
    }
}
