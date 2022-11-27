package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_NUMBERS_STORES = 50;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_NUMBERS_STORES];
	private int qtyStore = 0;
	
	public int getQtyOrdered() {
		return qtyStore;
	}
	
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyStore == MAX_NUMBERS_STORES) {
			System.out.println("The cart is already full");
		}else {
			this.itemsInStore[qtyStore] = disc;
			qtyStore++;
			System.out.println("The disc has been added to store");
		}
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		if (qtyStore == 0) {
			System.out.println("The cart is null");
		}else {
			for (int i = 0; i < qtyStore; i++) {
				if (this.itemsInStore[i] == disc) {
					this.itemsInStore[i] = this.itemsInStore[qtyStore - 1];
					this.itemsInStore[qtyStore - 1] = null;
					qtyStore--;
				}
			}
			System.out.println("The disc has been deleted from store");
		}
	}
}
