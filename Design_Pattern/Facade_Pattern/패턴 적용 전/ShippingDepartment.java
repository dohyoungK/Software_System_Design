package before;

public class ShippingDepartment {

	public void startShipping(Order order) {
		String address = order.getCustomer().getAddress();
		String item = order.getItem();
		int quantity = order.getQuantity();
		
		System.out.println("Start shipping: " + item + ", Quantity: " + quantity + ", Address: " + address); 
		
	}

	public void stopShipping(Order order) {
		String address = order.getCustomer().getAddress();
		String item = order.getItem();
		int quantity = order.getQuantity();
		
		System.out.println("Stop shipping: " + item + ", Quantity: " + quantity + ", Address: " + address); 
	}
}
