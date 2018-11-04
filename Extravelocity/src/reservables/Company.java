package reservables;


public abstract class Company {
	private String name;
	private double rating;

	public String getName() {
		return this.name;
	}

	public double getRating() {
		return this.rating;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double calculatePrice() {
		// TODO should be implemented
		int price = 0;
		return price;
	}

	public  Company() {
		// TODO should be implemented
	}
}
