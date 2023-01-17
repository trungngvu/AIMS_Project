package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddItemToStoreScreen extends ScreenControl {
    protected static Store store;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;

    JPanel createCenter(JPanel childPanel) {
        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());
        JPanel boxY = new JPanel();
        boxY.setLayout(new BoxLayout(boxY, BoxLayout.Y_AXIS));

        // Enter child row
        boxY.add(childPanel);
        center.add(boxY);
        return center;
    }

    public AddItemToStoreScreen(Store store) {
        super();
        this.store = store;
    }
}