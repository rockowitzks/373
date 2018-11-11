package reservables.air;

import java.io.Serializable;

public class Connection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1698920737376716174L;
	private Airport destination;
	private int flightsPerDay;
	
	public Connection(Airport dest, int flights) {
		this.destination = dest;
		this.flightsPerDay = flights;
	}

	public Airport getDestination() {
		return this.destination;
	}
	public void setDestination(Airport a) {
		this.destination = a;
	}
	public int getFlightsPerDay() {
		return this.flightsPerDay;
	}
	public void setflightsPerDay(int a) {
		this.flightsPerDay = a;
	}
}
