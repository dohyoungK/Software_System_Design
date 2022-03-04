package before;

public class OrderDepartment {

	public Order makeOrder(Customer customer, String item, int quantity, boolean canBeCancelled) {
		Order order = new Order(customer, item, quantity, canBeCancelled);
		return order;
	}

	public boolean cancelOrder(Order order) {
		order.setCancelled(order.isCanBeCancelled());
		return order.isCanBeCancelled();
	}
}
