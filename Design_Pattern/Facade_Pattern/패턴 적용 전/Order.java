package before;

public class Order {
	private final Customer customer;
	private final String item;
	private final int quantity;
	
	private final boolean canBeCancelled;
	private boolean paid;
	private boolean pending;
	private boolean cancelled;

	public Order(Customer customer, String item, int quantity, boolean canBeCancelled) {
		this.customer = customer;
		this.item = item;
		this.quantity = quantity;
		this.canBeCancelled = canBeCancelled;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public boolean isPending() {
		return pending;
	}

	public void setPending(boolean pending) {
		this.pending = pending;
	}

	public int getPrice() {
		int unitPrice = item.length();
		return unitPrice * quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getItem() {
		return item;
	}
	public Customer getCustomer() {
		return customer;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	public boolean isCanBeCancelled() {
		return canBeCancelled;
	}

}
