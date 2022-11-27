package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		//Create a new store
		Store anOrder = new Store();
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());
		
		//Create new DVD objects and add them to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDVD(dvd1);
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDVD(dvd2);
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDVD(dvd3);
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());
		
		//delete DVD from the store
		anOrder.removeDVD(dvd3);
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());
				
		anOrder.removeDVD(dvd2);
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());
				
		anOrder.removeDVD(dvd1);
		System.out.println("Numbers dvd is: " +anOrder.getQtyOrdered());
	}
}
