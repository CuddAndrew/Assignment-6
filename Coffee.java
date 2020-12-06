package main;

public class Coffee extends Beverage {

	public boolean extraShotCoffee, extraShotSyrup;
	final double EXTRACOFFEE = .5, EXTRASYRUP = .5;

	/**
	 * constructor to create a coffee beverage
	 * 
	 * @param name
	 * @param size
	 * @param ESCoffee
	 * @param ESSyrupt
	 */
	Coffee(String name, SIZE size, boolean ESCoffee, boolean ESSyrupt) {
		super(name, TYPE.COFFEE, size);
		extraShotCoffee = ESCoffee;
		extraShotSyrup = ESSyrupt;
	}

	/**
	 * overides the toString method return str
	 */
	public String toString() {
		String str = "Beverage name: " + getBevName() + ", Beverage size: " + getSize() + ", Extra shot of Coffee: ";
		if (extraShotCoffee) {
			str += "True ,";
		} else {
			str += "False ,";
		}
		if (extraShotSyrup) {
			str += "Extra shot of Syrup: True.";
		} else {
			str += "Extra shot of Syrup: False, ";
		}
		str += "price: " + calcPrice();
		return str;
	}

	/**
	 * overides the calcPrice abstract method
	 * 
	 * @return price
	 */
	@Override
	public double calcPrice() {
		double price = super.getBasePrice();

		if (super.getSize() == SIZE.MEDIUM) {
			price += super.getSizePrice();
		} else if (super.getSize() == SIZE.LARGE) {
			price += 2 * super.getSizePrice();
		}
		if (extraShotCoffee) {
			price += EXTRACOFFEE;
		}
		if (extraShotSyrup) {
			price += EXTRASYRUP;
		}
		return price;
	}

	/**
	 * overides the equals method
	 * 
	 * @param coffee
	 * @return bool
	 */
	public boolean equals(Coffee coffee) {
		if (super.equals(coffee) && extraShotCoffee == coffee.getExtraShot()
				&& extraShotSyrup == coffee.getExtraSyrup()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * checks if there is an extra shot
	 * 
	 * @returnv extraShotCoffee
	 */
	public boolean getExtraShot() {
		return extraShotCoffee;
	}

	/**
	 * checks if there is extra syrup
	 * 
	 * @return extraShotSyrup
	 */
	public boolean getExtraSyrup() {
		return extraShotSyrup;
	}

	/**
	 * gets the coffee cost
	 * 
	 * @return EXTRACOFFEE
	 */
	public double getCoffeeCost() {
		return EXTRACOFFEE;
	}

	/**
	 * gets the syrup cost
	 * 
	 * @return EXTRASYRUP
	 */
	public double getSyrupCost() {
		return EXTRASYRUP;
	}

	/**
	 * sets extra coffee
	 * 
	 * @param bool
	 */
	public void setExtraShotCoffee(boolean bool) {
		extraShotCoffee = bool;
	}

	/**
	 * sets extra syrup
	 * 
	 * @param bool
	 */
	public void setExtraSyrup(boolean bool) {
		extraShotSyrup = bool;
	}
}
