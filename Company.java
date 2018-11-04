package reservables;


public abstract class Company {
	private String name;
	private double rating;

	public Company() {
		this.name = "";
		this.setRating(1);
	}
	
	// pre: 
	// post: 
	public String getName() {
		return this.name;
	}

	public double getRating() {
		return this.rating;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	// pre: A double rating
	// post: if the number is between 0 and 5, sets the field rating to the parameter rating,
	// 		otherwise prints an error message
	public void setRating(double rating) {
		if(rating <= 5 && rating > 0) {
		this.rating = rating;
		}
		System.out.println("Not a valid number");
	}

	public double calculatePrice() {
		int price = 0;
		return price;
	}

	
}
