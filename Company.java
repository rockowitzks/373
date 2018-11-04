package reservables;


public abstract class Company {
	private String name;
	private double rating;

	// pre: nothing
	// post: sets the name to empty and rating to 1 
	public Company() {
		this.name = "";
		this.setRating(1);
	}
	
	// pre: nothing
	// post: returns this object's name
	public String getName() {
		return this.name;
	}

	// pre: nothing
	// post: returns this object's rating
	public double getRating() {
		return this.rating;
	}

	// pre: a String name
	// post: sets the field name to the parameter name
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

	// pre: nothing 
	// post: caclulates price
	public abstract double calculatePrice();

	
}
