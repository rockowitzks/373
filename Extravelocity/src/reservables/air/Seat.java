package reservables.air;
public class Seat {
	private int number;
	private boolean window;
	private boolean available;
	private int priority;
	private Flight flight;

	// pre: nothing
	// post: initializes the object
	public Seat() {
		this.number = 0;
		this.window = false;
		this.available = true;
		this.priority = 0;
		this.flight = null;
	}
	
	// pre: parameters that correspond to the fields
	// post: initializes the object with those given fields
	public Seat(int number, boolean window, boolean available, int priority, Flight flight) {
		this.number = number;
		this.window = window;
		this.available = available;
		this.priority = priority;
		this.flight = flight;
	}
	
	// pre: nothing
	// post: returns number
	public int getNumber() {
		return this.number;
	}

	// pre: nothing
	// post: returns window
	public boolean getWindow() {
		return this.window;
	}

	// pre: nothing
	// post: returns available
	public boolean getAvailable() {
		return this.available;
	}

	// pre: nothing
	// post: returns priority
	public int getPriority() {
		return this.priority;
	}

	// pre: nothing
	// post: returns the flight
	public Flight getFlight() {
		return this.flight;
	}

	// pre: an int number
	// post: sets the field number to the parameter number
	public void setNumber(int number) {
		this.number = number;
	}

	// pre: a boolean window
	// post: sets the field window to the parameter window
	public void setWindow(boolean window) {
		this.window = window;
	}

	// pre: a boolean available
	// post: sets the field available to the parameter available
	public void setAvailable(boolean available) {
		this.available = available;
	}

	// pre: an int priority
	// post: if priority is 0,1, or 2, sets the field priority to the parameter priority, else prints an error
	public void setPriority(int priority) {
		switch (priority) {
		case 0: priority = 0; break;
		case 1: priority = 1; break;
		case 2: priority = 2; break;
		default: System.out.println("Error, priority " + priority + " is not 0,1, or 2."); break;
		}
	}
	
	// pre: nothing
	// post: returns a seat multiplier based on the priority
	public double getSeatMultiplier() {
		double answer = 0;
		switch (this.getPriority()) {
		case 0: answer = 1; break;
		case 1: answer = 2.2; break;
		case 2: answer = 5.1; break;
		default: answer = 0.1; 
		System.out.println("Error, somehow priority is " + this.getPriority() + ". Fix this. Ending program."); 
		System.exit(-1);
		break;
		}
		return answer;
	}

	// pre: a Flight flight
	// post: sets the field flight to the parameter flight
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
