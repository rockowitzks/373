package reservables.air;
public class Flight {
	private String flightNumber;
	private Aircraft aircraft;
	private double capacity;
	private Aircraft arriving;
	private Aircraft departing;
	private ArrayList<> seats;
	private int departureTime;
	private Date departureDate;
	private int arrivalTime;
	private Date arrivalDate;

	public String getFlightNumber() {
		return this.flightNumber;
	}

	public Aircraft getAircraft() {
		return this.aircraft;
	}

	public double getCapacity() {
		return this.capacity;
	}

	public Aircraft getArriving() {
		return this.arriving;
	}

	public Aircraft getDeparting() {
		return this.departing;
	}

	public ArrayList<> getSeats() {
		return this.seats;
	}

	public int getDepartureTime() {
		return this.departureTime;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public int getArrivalTime() {
		return this.arrivalTime;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public void setArriving(Aircraft arriving) {
		this.arriving = arriving;
	}

	public void setDeparting(Aircraft departing) {
		this.departing = departing;
	}

	public void setSeats(ArrayList<> seats) {
		this.seats = seats;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public  Flight() {
		// TODO should be implemented
	}

	public void addSeat( ) {
		// TODO should be implemented
	}
}
