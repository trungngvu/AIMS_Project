package hust.soict.dsai.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ScreenControl extends JFrame {
    protected static JFrame storeScreen;
    protected static JFrame cartScreen;
    protected static JFrame addBookScreen;
    protected static JFrame addCDScreen;
    protected static JFrame addDVDScreen;
    protected JFrame currentScreen;

    public void setStoreScreen(JFrame storeScreen) {
        this.storeScreen = storeScreen;
    }

    public void setCartScreen(JFrame cartScreen) {
        this.cartScreen = cartScreen;
    }

    public void setAddBookScreen(JFrame addBookScreen) {
        this.addBookScreen = addBookScreen;
    }

    public void setAddCDScreen(JFrame addCDScreen) {
        this.addCDScreen = addCDScreen;
    }

    public void setAddDVDScreen(JFrame addDVDScreen) {
        this.addDVDScreen = addDVDScreen;
    }

    public void setCurrentScreen(JFrame currentScreen) {
        this.currentScreen = currentScreen;
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(new menuListener());
        smUpdateStore.add(addBook);
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(new menuListener());
        smUpdateStore.add(addCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(new menuListener());
        smUpdateStore.add(addDVD);


        menu.add(smUpdateStore);
        JMenuItem viewStoreOpt = new JMenuItem("View Store");
        viewStoreOpt.addActionListener(new menuListener());
        menu.add(viewStoreOpt);
        JMenuItem viewCartOpt = new JMenuItem("View Cart");
        viewCartOpt.addActionListener(new menuListener());
        menu.add(viewCartOpt);


        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.BLACK);

        JButton cart = new JButton("View Cart");
        cart.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (!cartScreen.isVisible()) {
                            cartScreen.setVisible(true);
                            currentScreen.setVisible(false);
                        }
                    }
                }
        );
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    public class menuListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = e.getActionCommand();
            if (menu.equals("View Store") && !storeScreen.equals(currentScreen)) {
                storeScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("View Cart") && !cartScreen.equals(currentScreen)) {
                cartScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("Add Book") && !addBookScreen.equals(currentScreen)) {
                addBookScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("Add CD") && !addCDScreen.equals(currentScreen)) {
                addCDScreen.setVisible(true);
                currentScreen.setVisible(false);
            } else if (menu.equals("Add DVD") && !addDVDScreen.equals(currentScreen)) {
                addDVDScreen.setVisible(true);
                currentScreen.setVisible(false);
            }
        }
    }
}