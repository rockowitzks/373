package reservables;


public class Company {
	private String name;
	private double rating;
	private double multiplier;
	private int phoneNumber;
	private String emailAddress;
	protected enum comapanies {};
	
	// pre: nothing
	// post: sets the name to empty and rating to 1 
	public Company() {
		this.name = "";
		this.phoneNumber = 0;
		this.emailAddress = null;
		this.rating = 0;
		this.multiplier = 0;
	}
	
	// pre: the parameters that correspond to field lists
	// post sets the fields to the corresponding parameters
	public Company(String name, double rating, double multiplier, double price, int phoneNumber,
			String emailAddress) {
		this.name = name;
		this.setRating(rating);
		this.setMultiplier(multiplier);
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
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
	// post: returns the object's multiplier
	public double getMultiplier() {
		return this.multiplier;
	}

	// pre: nothing
	// post: returns phoneNumber
	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	// pre: an int phoneNumber
	// post: sets the field phoneNumver to the parameter phoneNumber
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// pre: nothing
	// post: returns emailAddress
	public String getEmailAddress() {
		return this.emailAddress;
	}

	// pre: a String emailAddress
	// post: sets the field emailAddress to the parameter emailAddress
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	// pre: nothing
	// post: prints the company's email address and phone number
	public void printContactInfo() {
		System.out.println(this.getName() + " can be reached at " + this.getPhoneNumber() + "."
				+ " Or, you can email " + this.getName() + " at " + this.getEmailAddress() + ".");
	}

	// pre: an int multiplier
	// post: if the parameter is positive, sets the field multiplier to the parameter multiplier
	public void setMultiplier(double multiplier) {
		if(multiplier >= 0) {
		this.multiplier = multiplier;
		} else {
			System.out.println("The multiplier given, " + multiplier + " is negative.");;
		}
	}
}
