package Facade_Pattern;

import java.util.Scanner;

public class Client {
	private Scanner scanner = new Scanner(System.in);
	private Customer customer1 = new Customer("Park", "Busan", 10000);
	private Order order;
	private ShoppingController shoppingController;
	public Client(ShoppingController shoppingController) {
		this.shoppingController = shoppingController;
	}
	
	public void makeOrder() {	
		String item = scanner.next();
		int quantity = scanner.nextInt();
		
		shoppingController.makeOrder(order, customer1, item, quantity);
	}
	
	public void cancelOrder() {
		System.out.println("Are you sure to cancel? ");
		String answer = scanner.next();
		if ( ! answer.toUpperCase().equals("Y") ) return;
		
		shoppingController.cancelOrder(order);
	}
}
