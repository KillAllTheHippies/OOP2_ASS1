package view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jamie on 28/02/15.
 */
public class FixedHeightPanel extends JPanel {

    private ArrayList<Container> containers;
    private static final String NAME_LABEL = "Name: ";
    private static final String ADDRESS_LABEL = "Address: ";
    private static final String GENDER_LABEL = "Gender: ";

    public FixedHeightPanel() {

        this.containers = new ArrayList<Container>();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        DialogHorizPanel namePanel = new DialogHorizPanel(NAME_LABEL);
        DialogHorizPanel addressPanel = new DialogHorizPanel(ADDRESS_LABEL);
        DialogHorizPanel genderPanel = new DialogHorizPanel(GENDER_LABEL);

        this.containers.add(namePanel);
        this.containers.add(addressPanel);
        this.containers.add(genderPanel);

        for (Container c : containers) {

            this.add(c);
        }


    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int h = 0;
        for (Component c : containers) {
            h += c.getHeight();
        }
        this.setSize(getParent().getWidth() , h);

    }
}
