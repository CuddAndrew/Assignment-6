package main;

public class Customer {
	private String name;
	private int age;

	/**
	 * constructor to create a customer
	 * 
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * constructor to copy a customer
	 * 
	 * @param customer
	 */
	public Customer(Customer customer) {
		name = customer.getName();
		age = customer.getAge();
	}

	/**
	 * overides the toString method
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "Customer name: " + getName() + ", Customer age: " + getAge();
		return str;
	}

	/**
	 * gets the name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the age
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
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
	 * sets the age
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}
}
