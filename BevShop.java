package main;

/*
Class: CMSC203 CRN 25800
Program: Assignment 6
Instructor: Prof. Grinberg
Summary of Description: This program is used to order drinks and use different methods on them such as calculating prices
Due Date: 12/06/2020
Integrity Pledge: I pledge that I have completed the programming assignment independently.
I have not copied the code from a student or any source.
Student: Andrew Cudd
*/
import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
	private int numOfAlcoholInOrder;
	private int currentOrderIdx;
	private ArrayList<Order> orders;

	/**
	 * declares the array list
	 */
	public BevShop() {
		orders = new ArrayList<>();
	}

	/**
	 * Overrides the toString method
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "Monthly Orders\n";

		for (Order o : orders) {
			str += o.toString();
		}
		str += "Total Sale: " + totalMonthlySale();

		return str;
	}

	/**
	 * chekcs if the time is valid
	 * 
	 * @return bool
	 */
	public boolean validTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) {
			return true;
		}
		return false;
	}

	/**
	 * checks if the age is valid
	 * 
	 * @return bool
	 */
	public boolean validAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	/**
	 * checks if you have had less than 3 drinks
	 * 
	 * @return bool
	 */
	public boolean eligibleForMore() {
		if (numOfAlcoholInOrder < 3) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if you have more than the maximum fruit
	 * 
	 * @param num
	 * @return bool
	 */
	public boolean isMaxFruit(int num) {
		if (num > MAX_FRUIT) {
			return true;
		}
		return false;
	}

	/**
	 * creates a new order
	 * 
	 * @param time
	 * @param day
	 * @param customerName
	 * @param customerAge
	 */
	public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrderIdx = orders.indexOf(order);
		numOfAlcoholInOrder = 0;
	}

	/**
	 * creates a coffee order
	 * 
	 * @param bevname, size, extraShot, extraSyrup
	 */
	public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrderIdx).addNewBeverage(bevName, size, extraShot, extraSyrup);
	}

	/**
	 * creates a smoothie order
	 * 
	 * @param bevName, size, numOfFruits, addProtein
	 */
	public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
		orders.get(currentOrderIdx).addNewBeverage(bevName, size, numOfFruits, addProtein);
	}

	/**
	 * creates an alchohol order
	 * 
	 * @param bevName size
	 */
	public void processAlcoholOrder(String bevName, SIZE size) {
		orders.get(currentOrderIdx).addNewBeverage(bevName, size);
		numOfAlcoholInOrder++;
	}

	/**
	 * finds an order in the list
	 * 
	 * @param orderNo
	 * @return the order
	 */
	public int findOrder(int orderNo) {
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getOrderNo() == orderNo) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * finds the total price of the order
	 * 
	 * @param orderNo
	 * @return orderSale
	 */
	public double totalOrderPrice(int orderNo) {
		double orderSale = 0;

		for (Order order : orders) {
			if (order.getOrderNo() == orderNo) {
				for (Beverage beverage : order.getBeverages()) {
					orderSale += beverage.calcPrice();
				}
			}
		}

		return orderSale;
	}

	/**
	 * Finds the total sales of the month
	 * 
	 * @return totalSale
	 */
	public double totalMonthlySale() {
		double totalSale = 0;

		for (Order order : orders) {
			for (Beverage beverage : order.getBeverages()) {
				totalSale += beverage.calcPrice();
			}
		}

		return totalSale;
	}

	/**
	 * finds the total number of orders
	 * 
	 * @return number of orders
	 */
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}

	/**
	 * sorts the orders
	 */
	public void sortOrders() {

		for (int i = 0; i < orders.size() - 1; i++) {
			int minOrderNumIdx = i;
			for (int j = i + 1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo()) {
					minOrderNumIdx = j;
				}
			}

			Order temp = orders.get(minOrderNumIdx);
			orders.set(minOrderNumIdx, orders.get(i));
			orders.set(i, temp);
		}
	}

	/**
	 * finds the order at the index
	 * 
	 * @param index
	 * @return order
	 */
	public Order getOrderAtIndex(int index) {
		return orders.get(index);
	}

	/**
	 * gets the current order
	 * 
	 * @return order
	 */
	public Order getCurrentOrder() {
		return orders.get(currentOrderIdx);
	}

	/**
	 * gets the number of alcoholic drinks
	 * 
	 * @return alchoholic drinks
	 */
	public int getNumOfAlcoholDrink() {
		return numOfAlcoholInOrder;
	}

	/**
	 * Gets the max order for alcohol
	 * 
	 * @return max order for alcohol
	 */
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * gets the minimum age for an alcoholic drink
	 * 
	 * @return minimumm age for alcohol
	 */
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

}
