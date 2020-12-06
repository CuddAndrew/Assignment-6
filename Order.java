package main;

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages;

	/**
	 * creates a random number
	 * 
	 * @return randInt
	 */
	public int randomNum() {
		Random rand = new Random();
		int randInt = rand.nextInt(90_000 - 10_000) + 10_000;
		return randInt;
	}

	/**
	 * constructor to create an order
	 * 
	 * @param orderTime
	 * @param orderDay
	 * @param customer
	 */
	public Order(int orderTime, DAY orderDay, Customer customer) {
		orderNumber = getOrderNo();
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.customer = customer;
		beverages = new ArrayList<>();
	}

	/**
	 * creates a new coffee beverage
	 * 
	 * @param name
	 * @param size
	 * @param extraShotCoffee
	 * @param extraShotSyrup
	 */
	public void addNewBeverage(String name, SIZE size, boolean extraShotCoffee, boolean extraShotSyrup) {
		Coffee coffee = new Coffee(name, size, extraShotCoffee, extraShotSyrup);
		beverages.add(coffee);
	}

	/**
	 * creates a new smoothie beverage
	 * 
	 * @param name
	 * @param size
	 * @param numFruits
	 * @param proteinPowder
	 */
	public void addNewBeverage(String name, SIZE size, int numFruits, boolean proteinPowder) {
		Smoothie smoothie = new Smoothie(name, size, numFruits, proteinPowder);
		beverages.add(smoothie);
	}

	/**
	 * creates a new alcohol beverage
	 * 
	 * @param name
	 * @param size
	 */
	public void addNewBeverage(String name, SIZE size) {
		boolean weekend = false;
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			weekend = true;
		}
		Alcohol alcohol = new Alcohol(name, size, weekend);
		beverages.add(alcohol);
	}

	/**
	 * overides the toString method
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "Order number: " + getOrderNo() + ", Order time: " + orderTime + ", Order day: " + getOrderDay()
				+ "\n" + customer.toString();

		for (Beverage beverage : beverages) {
			str += "\n" + beverage.toString();
		}
		str += "\n Order cost: " + calcOrderTotal();

		return str;
	}

	/**
	 * checks if it is the weekend
	 * 
	 * @return bool
	 */
	public boolean isWeekend() {
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}
		return false;
	}

	/**
	 * gets the beverage
	 * 
	 * @param num
	 * @return beverage
	 */
	public Beverage getBeverage(int num) {
		return beverages.get(num);
	}

	/**
	 * compares the orders
	 * 
	 * @param order
	 * @return 0, 1, -1
	 */
	public int compareTo(Order order) {
		if (orderNumber == order.getOrderNo()) {
			return 0;
		} else if (orderNumber > order.getOrderNo()) {
			return 1;
		} else {
			return -1;
		}
	}

	/**
	 * calculates the order total
	 * 
	 * @return orderTotal
	 */
	public double calcOrderTotal() {
		double orderTotal = 0;

		for (Beverage beverage : beverages) {
			orderTotal += beverage.calcPrice();
		}

		return orderTotal;
	}

	/**
	 * finds the number of beverage types
	 * 
	 * @param type
	 * @return count
	 */
	public int findNumOfBeveType(TYPE type) {
		int count = 0;

		for (Beverage beverage : beverages) {
			if (beverage.getType() == type) {
				count++;
			}
		}

		return count;
	}

	/**
	 * gets the total ammount of items
	 * 
	 * @return items
	 */
	public int getTotalItems() {
		return beverages.size();
	}

	/**
	 * finds the order number
	 * 
	 * @return orderNumber
	 */
	public int getOrderNo() {
		return orderNumber;
	}

	/**
	 * finds the orderTime
	 * 
	 * @return orderTime
	 */
	public int getOrderTime() {
		return orderTime;
	}

	/**
	 * gets the order day
	 * 
	 * @return orderDay
	 */
	public DAY getOrderDay() {
		return orderDay;
	}

	/**
	 * gets the customer
	 * 
	 * @return customer
	 */
	public Customer getCustomer() {
		return new Customer(customer);
	}

	/**
	 * gets the beverages
	 * 
	 * @return beverages
	 */
	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	/**
	 * sets the order number
	 * 
	 * @param orderNumber
	 */
	public void setOrderNum(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * sets the order time
	 * 
	 * @param orderTime
	 */
	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	/**
	 * sets the order day
	 * 
	 * @param orderDay
	 */
	public void setOrderDay(DAY orderDay) {
		this.orderDay = orderDay;
	}

	/**
	 * sets the customer
	 * 
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
