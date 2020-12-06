package main;

public class Smoothie extends Beverage {
	private boolean protienPowder;
	private int numFruits;
	private final double PROTEINPOWDERCOST = 1.5;
	private final double EXTRAFRUITCOST = .5;

	/**
	 * constructor to create a smoothie beverage
	 * 
	 * @param name
	 * @param size
	 * @param numFruits
	 * @param protienPowder
	 */
	public Smoothie(String name, SIZE size, int numFruits, boolean protienPowder) {
		super(name, TYPE.SMOOTHIE, size);
		this.numFruits = numFruits;
		this.protienPowder = protienPowder;
	}

	/**
	 * overides the toString method
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "Beverage name: " + getBevName() + ", Beverage size: " + getSize() + ", Number of Fruits: "
				+ numFruits + ", Is there protein powder: ";
		if (protienPowder) {
			str += "True, ";
		} else {
			str += "False, ";
		}
		str += "Price: " + calcPrice();
		return str;
	}

	/**
	 * overides the equals method
	 * 
	 * @param smoothie
	 * @return bool
	 */
	public boolean equals(Smoothie smoothie) {
		if (super.equals(smoothie) && numFruits == smoothie.getNumOfFruits()
				&& protienPowder == smoothie.getAddProtien()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * calculates the price of the beverage
	 * 
	 * @return price
	 */
	public double calcPrice() {
		double price = super.getBasePrice();
		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		} else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		price += numFruits * EXTRAFRUITCOST;
		if (protienPowder) {
			price += PROTEINPOWDERCOST;
		}
		return price;
	}

	/**
	 * gets the number of fruits
	 * 
	 * @return numFruits
	 */
	public int getNumOfFruits() {
		return numFruits;
	}

	/**
	 * checks if there is protien
	 * 
	 * @return protienPowder
	 */
	public boolean getAddProtien() {
		return protienPowder;
	}

	/**
	 * gets the cost of fruit
	 * 
	 * @return EXTRAFRUITCOST
	 */
	public double getFruitCost() {
		return EXTRAFRUITCOST;
	}

	/**
	 * gets the protien cost
	 * 
	 * @return PROTIENPOWDERCOST
	 */
	public double getProteinCost() {
		return PROTEINPOWDERCOST;
	}

	/**
	 * sets the number of fruits
	 * 
	 * @param numFruits
	 */
	public void setNumOfFruits(int numFruits) {
		this.numFruits = numFruits;
	}

	/**
	 * sets the protien powder
	 * 
	 * @param proteinPowder
	 */
	public void setProteinPowder(boolean proteinPowder) {
		this.protienPowder = proteinPowder;
	}
}
