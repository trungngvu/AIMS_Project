package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import javax.naming.LimitExceededException;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    // private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    FilteredList<Media> filteredItems = new FilteredList<>(itemsOrdered, m -> true);

    public void addMedia(Media newMedia) throws LimitExceededException {
        if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The order is full!");
            throw new LimitExceededException("ERROR: the number of media has reached its limit!");
        } else {
            if (this.itemsOrdered.contains((newMedia))) {
                System.out.println("This item has already existed!");
                throw new LimitExceededException("ERROR: this item has already been added!");
            } else {
                this.itemsOrdered.add(newMedia);
                System.out.println("Add item to cart successful!");
            }
        }
    }

    public void addMedia(Media mediaList[]) throws LimitExceededException {
        if (itemsOrdered.size() + mediaList.length >= MAX_NUMBERS_ORDERED) {
            System.out.println("Not enough space left to add " + mediaList.length + " items!");
            throw new LimitExceededException("ERROR: the number of media has reached its limit!");
        } else {
            if (this.itemsOrdered.contains((newMedia))) {
                System.out.println("This item has already existed!");
                throw new LimitExceededException("ERROR: this item has already been added!");
            } else {
                this.itemsOrdered.add(newMedia);
                System.out.println("Add item to cart successful!");
            }
        }
    }

    public void addMedia(Media m1, Media m2) throws LimitExceededException {
        if (itemsOrdered.size() + mediaList.length >= MAX_NUMBERS_ORDERED) {
            System.out.println("Not enough space left to add 2 items!");
            throw new LimitExceededException("ERROR: the number of media has reached its limit!");
        } else {
            try {
                this.addMedia(m1);
            } catch (LimitExceededException e) {
                throw new RuntimeException(e);
            }
            try {
                this.addMedia(m2);
            } catch (LimitExceededException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Add items successful!");
        }
    }

    public void removeMedia(Media medToDel) {
        if (this.itemsOrdered.size() == 0) {
            System.out.println("Nothing to delete!");
        } else {
            if (this.itemsOrdered.contains(medToDel)) {
                if (this.itemsOrdered.remove(medToDel)) {
                    System.out.println("Delete successful!");
                } else {
                    System.out.println("Delete failed!");
                    // throw new RuntimeException("ERROR: Something wrong!");
                }
            } else {
                System.out.println("Item not found!");
                // throw new Exception("ERROR: Item not found!");
            }
        }
    }

    public float totalCost() {
        float total = 0.0f;
        for (Media m : this.itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (this.filteredItems.size() != 0) {
            for (Media m : filteredItems) {
                System.out.println(m.toString());
            }
        } else
            System.out.println("Empty! Nothing in your order list.");
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
        // System.out.println();
    }

    public void searchCart(String title) {
        List<Media> findResult = new ArrayList<Media>();

        for (Media m : this.filteredItems) {
            if (m.isMatch(title)) {
                findResult.add(m);
            }
        }

        if (findResult.size() > 0) {
            System.out.println("Result:");
            for (Media m : findResult) {
                System.out.println(m.toString());
            }
        } else {
            System.out.println("No items found!");
        }
    }

    public void searchCart(int id) {
        if (id <= 0) {
            System.out.println("Invalid ID!");
        } else {
            List<Media> findResult = new ArrayList<Media>();

            for (Media media : this.filteredItems) {
                if (media.isMatch(id)) {
                    findResult.add(media);
                }
            }
            if (findResult.size() > 0) {
                System.out.println("Results:");
                for (Media media : findResult) {
                    System.out.println(media.toString());
                }
            } else {
                System.out.println("No items found!");
            }
        }
    }

    public void filterCart(String title, boolean type) {
        if (title == null || title.length() == 0) {
            filteredItems.setPredicate(m -> true);
        } else {
            if (type) {
                try {
                    int idValue = Integer.parseInt(title);
                    filteredItems.setPredicate(m -> m.getId() == idValue);
                } catch (NumberFormatException e) {
                    System.out.println("The id value is invalid!");
                }
            } else {
                filteredItems.setPredicate(m -> m.getTitle().contains(title));
            }

        }
    }

    public void sortByCostTitle() {
        Collections.sort(this.filteredItems, Media.COMPARE_BY_COST_TITLE);
        System.out.println("List after sort:");
        for (Media m : this.filteredItems) {
            System.out.println(m.toString());
        }
    }

    public void sortByTitleCost() {
        Collections.sort(this.filteredItems, Media.COMPARE_BY_TITLE_COST);
        System.out.println("List after sort:");
        for (Media m : this.filteredItems) {
            System.out.println(m.toString());
        }
    }

    public int getNumberOfOrderedItems() {
        return this.filteredItems.size();
    }

    public ObservableList<Media> getItemsOrdered() {
        return this.filteredItems;
    }

    public Media getOneMedia(String title) {
        for (Media m : this.filteredItems) {
            if (m.isMatch(title)) {
                return m;
            }
        }
        return null;
    }

    public Media getOneMedia(int id) {
        for (Media m : this.filteredItems) {
            if (m.isMatch(id)) {
                return m;
            }
        }
        return null;
    }

    public void emptyCart() {
        this.itemsOrdered.clear();
    }
}