package reservables.cars;

import java.util.*;

import reservables.*;

public class RentalCarCompany extends Company {
	private ArrayList<Location> locations;


	// pre: nothing
	// post: instantiates the object
	public RentalCarCompany() {
		super();
		this.locations = new ArrayList<Location>();
	}
	
	// pre: an ArrayList of Location locations
	// post: instantiates the object with the parameter
	public RentalCarCompany(String name, double rating, double multiplier, int phoneNumber,
			String emailAddress, ArrayList<Location> locations) {
		super(name, rating, multiplier, phoneNumber, emailAddress);
		this.locations = locations;
	}
	
	// pre: nothing
	// post: returns location
	public ArrayList<Location> getLocations() {
		return this.locations;
	}

	// pre: an ArrayList of Location locations
	// post: sets the field locations to the parameter locations
	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}


}
