package main;

public abstract class Beverage {
	private String name;
	private TYPE type;
	private SIZE size;
	final double BASEPRICE = 2, SIZEPRICE = 1;

	/**
	 * Constructor to create a beverage
	 * 
	 * @param name
	 * @param type
	 * @param size
	 */
	Beverage(String name, TYPE type, SIZE size) {
		this.name = name;
		this.type = type;
		this.size = size;
	}

	public abstract double calcPrice();

	/**
	 * overides the toString method
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "Beverage name: " + name + " Beverage size: " + size;
		return str;
	}

	/**
	 * overides the equals method
	 * 
	 * @param beverage
	 * @return bool
	 */
	public boolean equals(Beverage beverage) {
		if (name.equals(beverage.getBevName()) && type.equals(beverage.getType()) && size.equals(beverage.getSize())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * gets the beverage name
	 * 
	 * @return name
	 */
	public String getBevName() {
		return name;
	}

	/**
	 * gets the type
	 * 
	 * @return type
	 */
	public TYPE getType() {
		return type;
	}

	/**
	 * gets the size
	 * 
	 * @return size
	 */
	public SIZE getSize() {
		return size;
	}

	/**
	 * gets the base price
	 * 
	 * @return BASEPRICE
	 */
	public double getBasePrice() {
		return BASEPRICE;
	}

	/**
	 * gets the size price
	 * 
	 * @return SIZEPRICE
	 */
	public double getSizePrice() {
		return SIZEPRICE;
	}

	/**
	 * sets the name
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * sets the type
	 * 
	 * @param type
	 */
	public void setType(TYPE type) {
		this.type = type;
	}

	/**
	 * sets the size
	 * 
	 * @param size
	 */
	public void setSize(SIZE size) {
		this.size = size;
	}
}
