package hust.soict.dsai.aims;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.screen.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Book;

import javax.naming.LimitExceededException;
import java.util.Scanner;

public class Aims {
    public static Cart cart = new Cart();
    public static Store store = new Store();

    public static Scanner input = new Scanner(System.in);

    public static boolean hasPlacedOrder = false;

    public static void showMenu() {
        do {
            System.out.println("\nAIMS PROJECT:");
            System.out.println("---------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("---------------------");
            System.out.print("Please choose a number (0-1-2-3): ");
            int option = input.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    store.printStore();
                    storeMenu();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    cart.printCart();
                    cartMenu();
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!hasPlacedOrder);
    }

    public static void updateStore() {
        do {
            System.out.println("\nUpdate options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media to the store");
            System.out.println("2. Remove a media from the store");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.print("Please choose a number (0-1-2): ");
            int option = input.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.print("Enter media's information: ");
                    break;
                case 2:
                    System.out.print("Enter media's information: ");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!hasPlacedOrder);

    }

    public static void storeMenu() {
        do {
            System.out.println("\nStore options:");
            System.out.println("---------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("---------------------");
            System.out.print("Please choose a number (0-1-2-3-4): ");
            int option = input.nextInt();
            input.nextLine();
            String mediaTitle;
            Media resultMedia;
            switch (option) {
                case 0:
                    return;
                case 1:
                    System.out.print("Enter the media's title: ");
                    mediaTitle = input.nextLine();
                    resultMedia = store.searchStore(mediaTitle);
                    if (resultMedia != null) {
                        //
                        System.out.println(resultMedia.toString());
                        mediaDetailsMenu(resultMedia);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the media's title: ");
                    mediaTitle = input.nextLine();
                    resultMedia = store.searchStore(mediaTitle);
                    if (resultMedia != null) {
                        try {
                            cart.addMedia(resultMedia);
                        } catch (LimitExceededException e) {
                            e.printStackTrace();
                            throw new RuntimeException(e);
                        }
                        // System.out.println("Add items to cart successful!");
                        System.out.println("Current number of items in cart: " + cart.getNumberOfOrderedItems() + ".");
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the media's title: ");
                    mediaTitle = input.nextLine();
                    resultMedia = store.searchStore(mediaTitle);
                    if (resultMedia != null) {
                        if (resultMedia instanceof CompactDisc) {
                            CompactDisc resultCD = (CompactDisc) resultMedia;
                            try {
                                resultCD.play();
                            } catch (PlayerException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else if (resultMedia instanceof DigitalVideoDisc) {
                            DigitalVideoDisc resultDVD = (DigitalVideoDisc) resultMedia;
                            try {
                                resultDVD.play();
                            } catch (PlayerException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println("This items can't be played!");
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 4:
                    cart.printCart();
                    if (cart.getNumberOfOrderedItems() != 0) {
                        cartMenu();
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!hasPlacedOrder);
    }

    public static void mediaDetailsMenu(Media media) {
        do {
            System.out.println("\nMedia options:");
            System.out.println("---------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("---------------------");
            System.out.print("Please choose a number (0-1-2): ");
            int option = input.nextInt();
            switch (option) {
                case 0:
                    return;
                case 1:
                    try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 2:
                    if (media instanceof CompactDisc) {
                        CompactDisc cd = (CompactDisc) media;
                        try {
                            cd.play();
                        } catch (PlayerException e) {
                            throw new RuntimeException(e);
                        }
                    } else if (media instanceof DigitalVideoDisc) {
                        DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                        try {
                            dvd.play();
                        } catch (PlayerException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!hasPlacedOrder);

    }

    public static void cartMenu() {
        do {
            System.out.println("\nCart options:");
            System.out.println("---------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("---------------------");
            System.out.print("Please choose a number (0-1-2-3-4-5): ");
            int option = input.nextInt();
            input.nextLine();
            String targetTitle;
            Media targetMedia;
            switch (option) {
                case 0:
                    return;
                case 1:
                    cartFilterMenu();
                    break;
                case 2:
                    cartSortMenu();
                    break;
                case 3:
                    System.out.print("Enter the title of the media: ");
                    targetTitle = input.nextLine();
                    targetMedia = cart.getOneMedia(targetTitle);
                    cart.removeMedia(targetMedia);
                    break;
                case 4:
                    System.out.print("Enter the title of the media: ");
                    targetTitle = input.nextLine();
                    targetMedia = cart.getOneMedia(targetTitle);
                    if (targetMedia != null) {
                        if (targetMedia instanceof CompactDisc) {
                            CompactDisc cd = (CompactDisc) targetMedia;
                            try {
                                cd.play();
                            } catch (PlayerException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else if (targetMedia instanceof DigitalVideoDisc) {
                            DigitalVideoDisc dvd = (DigitalVideoDisc) targetMedia;
                            try {
                                dvd.play();
                            } catch (PlayerException e) {
                                e.printStackTrace();
                                throw new RuntimeException(e);
                            }
                        } else {
                            System.out.println("This items can't be played!");
                        }
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;
                case 5:
                    if (cart.getNumberOfOrderedItems() != 0) {
                        hasPlacedOrder = true;
                        cart.emptyCart();
                        System.out.println("Your order has been set!");
                    } else
                        System.out.println("Your cart is empty!");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (!hasPlacedOrder);
    }

    public static void cartFilterMenu() {
        System.out.println("\nFilter options:");
        System.out.println("---------------------");
        System.out.println("1. Filter by id");
        System.out.println("2. Filter by title");
        System.out.println("0. Back");
        System.out.println("---------------------");
        System.out.print("Please choose a number (0-1-2): ");
        int option = input.nextInt();
        input.nextLine();
        int filterID;
        String filterTitle;
        switch (option) {
            case 0:
                return;
            case 1:
                System.out.print("Enter id: ");
                filterID = input.nextInt();
                cart.searchCart(filterID);
                break;
            case 2:
                System.out.print("Enter title: ");
                filterTitle = input.nextLine();
                cart.searchCart(filterTitle);
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    public static void cartSortMenu() {
        System.out.println("\nSorting options:");
        System.out.println("---------------------");
        System.out.println("1. Sort by title -> cost");
        System.out.println("2. Sort by cost -> title");
        System.out.println("0. Back");
        System.out.println("---------------------");
        System.out.print("Please choose a number (0-1-2): ");
        int option = input.nextInt();
        switch (option) {
            case 0:
                return;
            case 1:
                cart.sortByTitleCost();
                break;
            case 2:
                cart.sortByCostTitle();
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
    }

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        Book book1 = new Book("Harry Potter and the Order of the phoenix", "fantasy", 26f);

        CompactDisc cd1 = new CompactDisc("Midnights", "Taylor Swift", "Taylor Swift");

        store.addMedia(dvd1, dvd2, dvd3, book1, cd1);
        try {
            cart.addMedia(dvd1, dvd2);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }
        try {
            cart.addMedia(book1);
        } catch (LimitExceededException e) {
            throw new RuntimeException(e);
        }

        // showMenu();
        new CartScreen(cart, store);
        new AddDigitalVideoDiscToStoreScreen(store);
        new AddCompactDiscToStoreScreen(store);
        new AddBookToStoreScreen(store);
        new StoreScreen(store, cart);
    }
}