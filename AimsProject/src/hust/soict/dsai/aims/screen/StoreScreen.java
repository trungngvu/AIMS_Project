package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

import javax.swing.*;
import java.awt.*;

public class StoreScreen extends ScreenControl {
    private Store store;
    private Cart cart;

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));
        ObservableList<Media> mediaInStore = store.getItemsInStore();

        for (int i = 0; i < mediaInStore.size(); ++i) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), this.cart);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        super();
        setStoreScreen(this);
        setCurrentScreen(this);
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        store.getItemsInStore().addListener(
                new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> change) {
                        BorderLayout layout = (BorderLayout)cp.getLayout();
                        cp.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                        cp.add(createCenter(),BorderLayout.CENTER);
                        cp.repaint();
                        cp.revalidate();
                    }
                }
        );
    }
}