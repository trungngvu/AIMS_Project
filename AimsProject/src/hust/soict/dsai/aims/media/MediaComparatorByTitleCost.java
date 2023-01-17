package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    public int compare(Media o1, Media o2) {
        int compareValue = o1.getTitle().compareToIgnoreCase(o2.getTitle());
        if (compareValue == 0) {
            if (o1.getCost() > o2.getCost()) {
                return 1;
            } else if (o1.getCost() < o2.getCost()) {
                return -1;
            } else return compareValue; // they're completely the same?
        } else return compareValue;
    }
}