package reservables.air;

import java.io.Serializable;
import java.util.*;

import reservables.Company;

public class Airline extends Company implements Serializable {
	
	  
	 
	private static final long serialVersionUID = 7382333856064426484L;
	private ArrayList<Airport> airports;
	
	// pre: nothing
	// post: sets airports to a new ArrayList of Airport 
	public Airline() {
		super();
		this.airports = new ArrayList<Airport>();
	}
	
	// pre: an ArrayList of Airport airports
	// post: sets the field airport to the parameter airport and instantiates the object
	public Airline(String name, double rating, double multiplier, int phoneNumber,
			String emailAddress, ArrayList<Airport> airports) {
		super(name, rating, multiplier, phoneNumber, emailAddress);
		this.airports = airports;
	}
	
	// pre: nothing
	// post: returns airports
	public ArrayList<Airport> getAirports() {
		return this.airports;
	}
	
	// pre: an ArrayList<Airport> called airports
	// post: sets the field airports to the parameter airports
	public void setAirports(ArrayList<Airport> airports) {
		this.airports = airports;
	}
	
	// pre: an Airport airport
	// post: adds airport to airports
	public void addAirport(Airport airport) {
		this.airports.add(airport);
	}
	
	// pre: an Airport airport
	// post: if airport exists in airports, removes it and returns true, else returns false
	public boolean removeAirport(Airport airport) {
		return this.airports.remove(airport);
	}
}
