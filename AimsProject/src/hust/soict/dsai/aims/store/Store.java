package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

    public void addMedia(Media disc) {
        this.itemsInStore.add(disc);
        System.out.println("Item added successfully");
    }

    public void addMedia(Media... mediaList) {
        for (Media m : mediaList) {
            this.addMedia(m);
        }
        System.out.println("Add new items successful!");
    }

    public void removeMedia(Media disc) {
        if (this.itemsInStore.contains(disc)) {
            if (this.itemsInStore.remove(disc)) {
                System.out.println("Removed item successfully");
            } else {
                System.out.println("Removed item failed");
            }
        } else {
            System.out.println("Item not found!");
        }
    }

    public void printStore() {
        System.out.println("List of items in store:");
        for (Media m : itemsInStore) {
            System.out.println(m.toString());
        }
    }

    public ObservableList<Media> getItemsInStore() {
        return this.itemsInStore;
    }

    public Media searchStore(String title) {
        for (Media media : this.itemsInStore) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        return null;
    }

    public Store() {

    }
}