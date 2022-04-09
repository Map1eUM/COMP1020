package Assignment3;

import static java.lang.Math.random;

public abstract class Item {
	protected int id;
	protected static int itemNum;
	public Item() {
		itemNum++;
	}
	public static int getTotalNumberOfItems() {
		return itemNum;
	}
	public int getID() {
		return id;
	}
	
}
