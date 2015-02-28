package view;


import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Jamie on 24/02/15.
 */
public class SurgeryFrame extends JFrame {

    private JButton addButton;
    private JButton closeButton;
    private JTable patientTable;

    public SurgeryFrame(String title) {
        super(title);

        // Content of our JFrame
        JPanel mainPanel = new JPanel();

        // set border layout
        mainPanel.setLayout(new BorderLayout());

        // create the side and bottom panels and add them to the layout
        JPanel sidePanel = createSideButtonPanel();
        mainPanel.add(sidePanel, BorderLayout.EAST);
        JPanel bottomPanel = createBottomButtonPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // create the table which is in a scrollPane
        JScrollPane tableScrollPane = createTableScrollPane();
        mainPanel.add(tableScrollPane, BorderLayout.CENTER);


        this.getContentPane().add(mainPanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    private JScrollPane createTableScrollPane() {
        patientTable = new JTable();


        ArrayList<Patient> tempPatients = new ArrayList<Patient>();

        ChildPatient p1 = new ChildPatient("Billy", "Nowhere", "Male", "Sesame Street");
        AdultPatient p2 = new AdultPatient("Jimmy", "Somewhere", "Male", "Unemployed");
        ChildPatient p3 = new ChildPatient("Jenny", "The Moon", "Female", "Martian base #2451");
        AdultPatient p4 = new AdultPatient("Lucky", "Mars Colony 1", "Male", "Suicidal Pioneer");

        tempPatients.add(p1);
        tempPatients.add(p2);
        tempPatients.add(p3);
        tempPatients.add(p4);


        SurgeryTableModel tableModel = new SurgeryTableModel(tempPatients);
        patientTable.setModel(tableModel);


        JScrollPane tableScrollPane = new JScrollPane(patientTable);
        return tableScrollPane;
    }


    /**
     * This method creates the bottom JPanel, puts buttons on it and returns the fully constructed JPanel
     */
    private JPanel createBottomButtonPanel() {
        // Instantiate panel, button & listener, add listener to button,
        // add button to panel, return panel.
        JPanel buttonPanel = new JPanel();
        closeButton = new JButton("Close");
        ButtonsActionListener buttonListener =
                new ButtonsActionListener(this);

        closeButton.addActionListener(buttonListener);

        buttonPanel.add(closeButton);

        return buttonPanel;
    }

    private JPanel createSideButtonPanel() {
        // instantiate the buttons
        addButton = new JButton("Add Patient");
        JButton deleteButton = new JButton("Delete Patient");

        // Instantiate the listener for the buttons,
        // passing it in a reference to this class (SurgeryFrame)
        // and assign it to the buttons
        ButtonsActionListener buttonListener = new ButtonsActionListener(this);
        addButton.addActionListener(buttonListener);
        deleteButton.addActionListener(buttonListener);

        // Create panel, assign layout, add components.
        JPanel sideButtonPanel = new JPanel();
        sideButtonPanel.setLayout(new BoxLayout(sideButtonPanel, BoxLayout.Y_AXIS));
        sideButtonPanel.add(addButton);
        sideButtonPanel.add(Box.createVerticalStrut(5));
        sideButtonPanel.add(deleteButton);

        return sideButtonPanel;
    }

    //Inner class implementation of ActionListener
    private class ButtonsActionListener implements ActionListener {
        //This is to allow this inner class to refer to its
        //containing class (i.e. SurgeryFrame)
        private SurgeryFrame outerClass;

        public ButtonsActionListener(SurgeryFrame outerClass) {
            this.outerClass = outerClass;
        }

        public void actionPerformed(ActionEvent e) {
            //We know that the source of any ActionEvent
            //in this program MUST be a JButton seeing as
            //we only added an instance of this listener to
            //JButton objects
            JButton sourceButton = (JButton) e.getSource();

            if (sourceButton.equals(addButton)) {

                // Launch a dialog and set its size when the add button is clicked
                AddPatientDialog addPatDlg =
                        new AddPatientDialog(this.outerClass, "Add Patient");

                //addPatDlg.setSize(600, 200);

                addPatDlg.setVisible(true);

            } else if (sourceButton.equals(closeButton)) {

                dispose();

            }

            // This is the code that responds to the delete button
            else {
                // check if row is selected
                if (patientTable.getSelectedRow() == -1) {

                    JOptionPane.showMessageDialog(outerClass, "You need to select a table row",
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
                // If table row is selected then launch delete dialog
                else {

                    String message = "Are you sure you want to delete a patient?";
                    int answer =
                            JOptionPane.showConfirmDialog(outerClass, message);
                    if (answer == JOptionPane.YES_OPTION) {
                        System.out.println("Patient Deletion Confirmed");
                    } else if (answer == JOptionPane.NO_OPTION) {
                        System.out.println("Patient Deletion Cancelled");
                    }

                }

            }

        }
    }

}
