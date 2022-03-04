package Facade_Pattern;

public class Customer {
	private String name;
	private String address;
	private int balance;

	public Customer(String name, String address, int balance) {
		this.setName(name);
		this.setAddress(address);
		this.setBalance(balance);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
