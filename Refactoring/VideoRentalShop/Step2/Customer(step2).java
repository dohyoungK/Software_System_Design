package VideoRentalShop;

import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();
	public Customer(String name) {
		_name = name;
	};
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	public String getName() {
		return _name;
	};

	public String statement() {
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each: _rentals) {
			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
		return result;
	}
	private double getTotalCharge() {
		double result = 0;
		for (Rental each: _rentals)	result += each.getCharge();
		return result;
	}
	private double getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental each: _rentals)	result += each.getFrequentRenterPoints();
		return result;
	}
}
