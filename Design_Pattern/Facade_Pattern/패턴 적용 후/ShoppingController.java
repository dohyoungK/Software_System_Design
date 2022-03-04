package Facade_Pattern;

public class ShoppingController {
	private OrderDepartment orderDept;
	private BillingDepartment billingDept;
	private ShippingDepartment shippingDept;
	
	public ShoppingController(OrderDepartment orderDept, BillingDepartment billingDept, ShippingDepartment shippingDept) {
		this.orderDept = orderDept;
		this.billingDept = billingDept;
		this.shippingDept = shippingDept;
	}
	
	public void makeOrder(Order order, Customer customer1, String item, int quantity) {
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
	
	public void cancelOrder(Order order) {
		if ( orderDept.cancelOrder(order) ) {
			billingDept.refund(order);
			shippingDept.stopShipping(order);
		}
		else {
			System.out.println("The order cannot be cancelled");
		}
	}
}
