package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private  static int nbCompactDiscs = 0;
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc() {
        this.setId(++nbCompactDiscs);
    }

    public CompactDisc(String title, String director, String artist) {
        super(director);
        this.setId(++nbCompactDiscs);
        this.setTitle(title);
        this.artist = artist;
    }

    public CompactDisc(String title, int length, String director, String artist) {
        super(length, director);
        this.setTitle(title);
        this.setId(++nbCompactDiscs);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist) {
        super(title, category, cost, director);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track newTrack) {
        if (!this.tracks.contains(newTrack)) {
            this.tracks.add(newTrack);
            System.out.println("Add new track successful!");
        } else {
            System.out.println("This track has already existed!");
        }
    }

    public void removeTrack(Track trackToDel) {
        if (!this.tracks.contains(trackToDel)) {
            System.out.println("Track not found!");
        } else {
            if (this.tracks.remove(trackToDel)) {
                System.out.println("Delete successful!");
            } else {
                System.out.println("Delete failed!");
            }
        }
    }

    public int getLength() {
        int totalLength = 0;
        if (super.getLength() != 0) {
            return super.getLength();
        }
        for (Track t : this.tracks) {
            totalLength += t.getLength();
        }
        return totalLength;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = iter.next();
                nextTrack.play();
            }
        } else {
            throw new PlayerException("ERROR: CD's length is non-positive!");
        }
        for (Track t : this.tracks) {
            try {
                t.play();
            } catch (PlayerException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return "Compact disc: " +
                this.getId() + " | " +
                "artist - " + this.getArtist() + " | " +
                "length - " + this.getLength() + " | " +
                "director - " + this.getDirector() + " | " +
                "title - " + this.getTitle() + " | " +
                "category - " + this.getCategory() + " | " +
                "cost - " + this.getCost() +
                ".";
    }
}