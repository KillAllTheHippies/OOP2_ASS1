package view;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jamie on 24/02/15.
 */
public class AddPatientDialog extends JDialog {

    private JPanel mainPanel;

    private JButton btnAddPatient, btnClose;
    // create constants for the labels
    private static final String NAME_LABEL = "Name: ";
    private static final String ADDRESS_LABEL = "Address: ";
    private static final String GENDER_LABEL = "Gender: ";

    public AddPatientDialog(Frame owner, String title) {

        super(owner, title);


        mainPanel = new JPanel();

        // set border layout on the panel
        mainPanel.setLayout(new BorderLayout());

        // Add bottom panel
        JPanel bottomPanel = createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add center panel
        JPanel centerPanel = createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);


        // add the main panel to the dialog
        this.getContentPane().add(mainPanel);

        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);


        this.setPreferredSize(new Dimension(500,180));
        //this.setMinimumSize(new Dimension(500,180));


    }

    public JPanel createCenterPanel() {


        // create the panel
        JPanel centerPanel = new JPanel();

        // set a layout

        // Set vertical box layout on the main panel
        //centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));


        // Create our 3 horizontal panels (custom component extended from JPanel)
        // and pass in the text for the label

        DialogHorizPanel namePanel = new DialogHorizPanel(NAME_LABEL);
        DialogHorizPanel addressPanel = new DialogHorizPanel(ADDRESS_LABEL);
        DialogHorizPanel genderPanel = new DialogHorizPanel(GENDER_LABEL);

        //FixedHeightPanel testPanel = new FixedHeightPanel();


        //centerPanel.add(testPanel);

        // add the panels to the center panel
        centerPanel.add(namePanel);
        centerPanel.add(addressPanel);
        centerPanel.add(genderPanel);


        return centerPanel;
    }

    public JPanel createBottomPanel() {

        JPanel panel = new JPanel();

        btnAddPatient = new JButton("Add Patient");
        btnAddPatient.addActionListener(new ButtonsActionListener(this));

        btnClose = new JButton("Close");
        btnClose.addActionListener(new ButtonsActionListener(this));

        panel.add(btnAddPatient);
        panel.add(btnClose);

        return panel;
    }

    private class ButtonsActionListener implements ActionListener {
        //This is to allow this inner class to refer to its
        //containing class (i.e. WorldCupFrame)
        private AddPatientDialog outerClass;

        public ButtonsActionListener(AddPatientDialog outerClass) {
            this.outerClass = outerClass;
        }

        public void actionPerformed(ActionEvent e) {
            //We know that the source of any ActionEvent
            //in this program MUST be a JButton seeing as
            //we only added an instance of this listener to
            //JButton objects
            JButton sourceButton = (JButton) e.getSource();

            if (sourceButton.equals(btnAddPatient)) {

                System.out.println("Add Patient Clicked.");
            } else if (sourceButton.equals(btnClose)) {

                dispose();
            }


        }
    }
}