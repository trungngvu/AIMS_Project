package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CartScreenController {
    // Cart definition
    private Cart cart;

    private Store store;

    // All the FXML Usage
    @FXML
    private MenuItem addBookOpt;

    @FXML
    private MenuItem addCDOpt;

    @FXML
    private MenuItem addDVDOpt;

    @FXML
    private Label totalCostLabel;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private Button placeOrderBtn;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
    }

    @FXML
    void addBookOptPressed(ActionEvent event) {
        Frame[] arr = Frame.getFrames();
        for (Frame f : arr) {
            f.setVisible(f.getTitle().equals("Add Book To Store"));
        }
    }

    @FXML
    void addCDOptPressed(ActionEvent event) {
        Frame[] arr = Frame.getFrames();
        for (Frame f : arr) {
            f.setVisible(f.getTitle().equals("Add CD To Store"));
        }
    }

    @FXML
    void addDVDOptPressed(ActionEvent event) {
        Frame[] arr = Frame.getFrames();
        for (Frame f : arr) {
            f.setVisible(f.getTitle().equals("Add DVD To Store"));
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent e) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("Category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("Cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Media>() {
                    @Override
                    public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                        if (newValue != null) {
                            updateButtonBar(newValue);
                        }
                    }
                });

        tblMedia.setItems(this.cart.getItemsOrdered());

        updateTotalCost();
        tblMedia.getItems().addListener(
                new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> change) {
                        updateTotalCost();
                    }
                });
    }

    @FXML
    void btnPlayPressed(ActionEvent event) {
        JFrame f = new JFrame();
        for (Frame fr : Frame.getFrames()) {
            if (fr.getTitle().equals("Cart")) {
                f = (JFrame) fr;
                break;
            }
        }

        Media selectedMediaTitle = tblMedia.getSelectionModel().selectedItemProperty().get();

        try {
            ((Playable) selectedMediaTitle).play();

            JDialog d = new JDialog(f, selectedMediaTitle.getTitle() + " is now being played...", true);
            JButton b = new JButton("Cancel");
            d.setLayout(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    d.setVisible(false);
                }
            });
            d.add(new JLabel("Click here to escape"));
            c.insets = new Insets(0, 10, 0, 0);
            d.add(b, c);
            d.setSize(300, 100);
            d.setLocationRelativeTo(f);
            d.setVisible(true);
        } catch (PlayerException ex) {
            JOptionPane.showMessageDialog(
                    f,
                    ex.getMessage(),
                    "Illegal media length",
                    JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    @FXML
    void orderBtnPressed(ActionEvent event) {
        cart.emptyCart();
        totalCostLabel.setText(String.format("%.2f", cart.totalCost()) + "$");

        JFrame f = new JFrame();
        for (Frame fr : Frame.getFrames()) {
            if (fr.getTitle().equals("Cart")) {
                f = (JFrame) fr;
                break;
            }
        }
        JDialog d = new JDialog(f, "Place order successful!", true);
        JButton b = new JButton("Cancel");
        d.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                d.setVisible(false);
            }
        });
        d.setSize(300, 100);
        d.add(new JLabel("Click here to escape"));
        c.insets = new Insets(0, 10, 0, 0);
        d.add(b, c);
        f.setLocationRelativeTo(null);
        d.setLocationRelativeTo(f);
        d.setVisible(true);
    }

    @FXML
    void viewStoreOptPressed(ActionEvent event) {
        Frame[] arr = Frame.getFrames();
        for (Frame f : arr) {
            f.setVisible(f.getTitle().equals("Store"));
        }
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof Playable);
    }

    void showFilteredMedia(String filterValue) {
        cart.filterCart(filterValue, radioBtnFilterId.isSelected());
    }

    void updateTotalCost() {
        Platform.runLater(
                new Runnable() {
                    @Override
                    public void run() {
                        totalCostLabel.setText(String.format("%.2f", cart.totalCost()) + "$");
                    }
                });
    }
}