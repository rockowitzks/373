package reservables.cars;

import java.util.*;

import reservables.*;

public class RentalCarCompany extends Company {
	public ArrayList<Location> locations;

	public ArrayList<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(ArrayList<Location> locations) {
		this.locations = locations;
	}

	public  RentalCarCompany() {
		super();
		locations = new ArrayList<Location>();
	}

}
