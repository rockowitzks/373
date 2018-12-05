package reservables.cars;

import java.io.Serializable;
import java.util.*;

import reservables.*;

public class RentalCarCompany extends Company implements Serializable{
	private HashMap<String, CarRentalLocation> locations;


	// pre: nothing
	// post: instantiates the object
	public RentalCarCompany() {
		super();
		this.locations = new HashMap<String, CarRentalLocation>();
	}
	
	// pre: an ArrayList of Location locations
	// post: instantiates the object with the parameter
	public RentalCarCompany(String name, double rating, double multiplier, int phoneNumber,
			String emailAddress, HashMap<String, CarRentalLocation> locations) {
		super(name, rating, multiplier, phoneNumber, emailAddress);
		this.locations = locations;
	}
	
	// pre: nothing
	// post: returns location
	public HashMap<String, CarRentalLocation> getLocations() {
		return this.locations;
	}

	// pre: an ArrayList of Location locations
	// post: sets the field locations to the parameter locations
	public void setLocations (HashMap<String, CarRentalLocation> locations) {
		this.locations = locations;
	}
	
	public void addLocation (CarRentalLocation carRentalLocation) {
		this.locations.put(carRentalLocation.getCity(), carRentalLocation);
	}

}
