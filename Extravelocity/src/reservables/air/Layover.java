package reservables.air;
public class Layover {
	private Airport airport;
	private Flight previous;
	private Flight next;
	private int time;

	// pre: nothing
	// post: initializes object
	public Layover() {
		this.airport = null;
		this.time = 0;
		this.previous = null;
		this.next = null;
	}
	
	public Layover(Airport airport, Flight previous, Flight next, int time) {
		this.airport = airport;
		this.previous = previous;
		this.next = next;
		this.time = time;
	}

	// pre: nothing
	// post: returns the time (in minutes) over the layover
	public void calculateLayover() {
		time = previous.getArrivalTime() - next.getDepartureTime();
	}
	
	// pre: nothing
	// post: returns airport
	public Airport getAirport() {
		return this.airport;
	}

	// pre: nothing
	// post: returns 
	public int getTime() {
		return this.time;
	}

	// pre: an Airport airpot
	// post: sets the field airport to the parameter airport
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	
	// pre: nothing
	// post: returns previous
	public Flight getPrevious() {
		return this.previous;
	}

	// pre: a Flight previous
	// post: sets the field previous to the parameter previous
	public void setPrevious(Flight previous) {
		this.previous = previous;
	}

	// pre: nothing
	// post: returns next
	public Flight getNext() {
		return this.next;
	}

	// pre: a Flight next
	// post: sets the field next to the parameter next
	public void setNext(Flight next) {
		this.next = next;
	}

	// pre: an int time
	// post: sets the field time to the parameter time
	public void setTime(int time) {
		this.time = time;
	}

}
