package reservables.air;

import java.util.*;

import reservables.Company;

public class Airline extends Company {
	private ArrayList<Airport> airports;
	
	// pre: nothing
	// post: sets airports to a new ArrayList of Airport 
	public Airline() {
		this.airports = new ArrayList<Airport>();
	}
	
	// pre: an ArrayList of Airport airports
	// post: sets the field airport to the parameter airport and instantiates the object
	public Airline(ArrayList<Airport> airports) {
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
		boolean remove = this.airports.remove(airport);
		return remove;
	}
}
