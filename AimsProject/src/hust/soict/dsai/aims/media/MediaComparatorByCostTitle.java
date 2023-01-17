package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media o1, Media o2) {
        if (o2.getCost() > o1.getCost()) {
            return 1;
        } else if (o2.getCost() < o1.getCost()) {
            return -1;
        } else return o1.getTitle().compareToIgnoreCase(o2.getTitle());
    }
}