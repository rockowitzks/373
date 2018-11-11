package reservables.air;

import java.io.Serializable;

public class Connection implements Serializable{
	

	private static final long serialVersionUID = 1698920737376716174L;
	private Airport destination;
	private int flightsPerDay;
	
	// pre: nothing
	// post: instantiates the object
	public Connection() {
		this.destination = null;
		this.flightsPerDay = 0;
	}
	
	// pre: an Airport destination and an int flightsPerDay
	// post: instantiates the object with the parameters as fields
	public Connection(Airport destination, int flightsPerDay) {
		this.destination = destination;
		this.flightsPerDay = flightsPerDay;
	}

	// pre: nothing
	// post: returns destination
	public Airport getDestination() {
		return this.destination;
	}
	
	// pre: an airport destination
	// post: sets the field destination to the parameter destination
	public void setDestination(Airport destination) {
		this.destination = destination;
	}
	
	// pre: nothing
	// post: returns flightsPerDay
	public int getFlightsPerDay() {
		return this.flightsPerDay;
	}
	
	// pre: an int flightsPerDay
	// post: sets the field flightsPerDay
	public void setflightsPerDay(int flightsPerDay) {
		this.flightsPerDay = flightsPerDay;
	}
}
