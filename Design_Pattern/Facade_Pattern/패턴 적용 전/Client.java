package before;

import java.util.Scanner;

public class Client {
	private OrderDepartment orderDept = new OrderDepartment();
	private BillingDepartment billingDept = new BillingDepartment();
	private ShippingDepartment shippingDept = new ShippingDepartment();
	
	private Scanner scanner = new Scanner(System.in);
	private Customer customer1 = new Customer("Park", "Busan", 10000);
	private Order order;

	public void makeOrder() {
		
		String item = scanner.next();
		int quantity = scanner.nextInt();
		
		try {
			order = orderDept.makeOrder(customer1, item, quantity, quantity >= 10);
			int price = order.getPrice();
			if ( billingDept.makePayment(order, price) )
				shippingDept.startShipping(order);
			else {
				order.setPending(true);
				throw new NotEnoughBalanceException(order);
			}
		}
		catch ( NotEnoughBalanceException e ) {
			System.out.println("You have not enough money to buy " + order.getItem());
		}
	}
	
	public void cancelOrder() {
		System.out.println("Are you sure to cancel? ");
		String answer = scanner.next();
		if ( ! answer.toUpperCase().equals("Y") ) return;
		
		if ( orderDept.cancelOrder(order) ) {
			billingDept.refund(order);
			shippingDept.stopShipping(order);
		}
		else {
			System.out.println("The order cannot be cancelled");
		}
	}
}
