package main;

public class Alcohol extends Beverage{
    private boolean weekend;
    private final double WEEKENDCOST = .6;
    /**
     * constructor to create an alcohol beverage
     * @param name
     * @param size
     * @param weekend
     */
    public Alcohol(String name, SIZE size, boolean weekend) {
            super(name, TYPE.ALCOHOL, size);
            this.weekend = weekend;
    }
    /**
     * overides the toString method
     * @return str
     */
    public String toString() {
    	String str = "Beverage name: " + getBevName() + ", Beverage size: " + getSize() + ", Offered on the weekend: ";
		if (weekend) {
			str += "True, ";
		} else {
			str += "False, ";
		}
		str += "Price: " + calcPrice();
		return str;
    }
    /**
     * overides the equals method
     * @param alcohol
     * @return bool
     */
    public boolean equals(Alcohol alcohol) {
            if (super.equals(alcohol) && weekend == alcohol.getWeekend()) {
                    return true;
            }
            else {
                    return false;
            }
    }
    /**
     * calculates the price
     * @return price
     */
    public double calcPrice() {
            double price = super.getBasePrice();
            
            if (super.getSize() == SIZE.MEDIUM) {
                    price += super.getSizePrice();
            }
            else if (super.getSize() == SIZE.LARGE) {
                    price += 2 * super.getSizePrice();
            }
            
            if (weekend) {
                    price += WEEKENDCOST;
            }
            
            return price; 
    }
    /**
     * checks if it is the weekend
     * @return weekend
     */
    public boolean getWeekend() {
            return weekend;
    }
    /**
     * gets the weekend fee
     * @return WEEKENDCOST
     */
    public double getWeekendFee() {
            return WEEKENDCOST;
    }
    /**
     * sets the weekend
     * @param weekend
     */
    public void setWeekend(boolean weekend) {
            this.weekend = weekend;
    }
}
