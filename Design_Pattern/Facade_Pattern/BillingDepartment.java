package Facade_Pattern;

public class BillingDepartment {

	public boolean makePayment(Order order, int price) {
		int currentBalance = order.getCustomer().getBalance();
		if ( ! (currentBalance >= price) ) return false;
		
		order.getCustomer().setBalance(currentBalance - price);
		order.setPaid(true);
		return true;
	}

	public void refund(Order order) {
		int price = order.getPrice();
		int currentBalance = order.getCustomer().getBalance();
		order.getCustomer().setBalance(currentBalance + price);
	}

}
