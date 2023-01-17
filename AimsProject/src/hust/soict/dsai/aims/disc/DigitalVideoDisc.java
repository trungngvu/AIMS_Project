package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc() {

    }

    public DigitalVideoDisc(String title) {
        super();
    	nbDigitalVideoDiscs++;
    	this.setId(nbDigitalVideoDiscs);
        this.setTitle(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
    	super(director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
    	super(length, director);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }
    
    public String toString() {
    	return "DigitalVideoDisc: " +
                this.getId() + " | " +
                "title - " + this.getTitle() + " | " +
                "category - " + this.getCategory() + " | " +
                "director - " + this.getDirector() + " | " +
                "length - " + this.getLength() + " | " +
                "cost - " + this.getCost() + "$.";

    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            // TODO Play DVD as have implemented
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }

    }
}