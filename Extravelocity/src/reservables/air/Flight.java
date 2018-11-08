package reservables.air;

import java.util.*;
import java.time.*;

import software.*;

public class Flight {
	private String flightNumber;
	private Airline airline;
	private Aircraft aircraft;
	private double capacity;
	private Airport arriving; // arriving is an airport
	private Airport departing; // departing is an airport
	private ArrayList<Seat> seats;
	private int departureTime; // change this to a time object
	private Date departureDate;
	private int arrivalTime; // change this to a time object
	private Date arrivalDate;
	private double distance;
	private double price;

	// pre: nothing
	// post: instantiates the object
	public  Flight() {
		this.airline = null;
		this.flightNumber = null;
		this.aircraft = null;
		this.capacity = 0;
		this.arriving = null;
		this.departing = null;
		this.seats = new ArrayList<Seat>();
		this.departureTime = 0;
		this.departureDate = null;
		this.arrivalTime = 0;
		this.arrivalDate = null;
	}
	
	// pre: parameters corresponding
	// post: sets the fields to the corresponding parameters
	public Flight(String flightNumber, Airline airline, Aircraft aircraft, double capacity, Airport arriving,
			Airport departing, ArrayList<Seat> seats, int departureTime, Date departureDate,
			int arrivalTime, Date arrivalDate, double distance, double price) {
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.aircraft = aircraft;
		this.capacity = capacity;
		this.arriving = arriving;
		this.departing = departing;
		this.seats = seats;
		this.departureTime = departureTime;
		this.departureDate = departureDate;
		this.arrivalTime = arrivalTime;
		this.arrivalDate = arrivalDate;
		this.distance = distance;
		this.price = price;
	}
	
	// pre: nothing
	// post: returns true if the seats size equals or exceeds the capacity, false if it is less than capacity, and prints
	//	and error seats size exceeds capacity
	public boolean isFull() {
		if(this.seats.size() > capacity) {
			System.out.println("You made a mistake, seats size is " +  this.seats.size() + 
					" and capacity is " + this.capacity + ". Dumb mistake.");
		}
		return !(this.seats.size() < capacity);
	}
	
	// pre: nothing
	// post: returns flight Number
	public String getFlightNumber() {
		return this.flightNumber;
	}

	// pre: nothing
	// post: returns aircraft
	public Aircraft getAircraft() {
		return this.aircraft;
	}

	// pre: nothing
	// post: returns distance
	public double getDistance() {
		return distance;
	}

	// pre: a double distance
	// post: sets the field distance to the parameter distance
	public void setDistance(double distance) {
		this.distance = distance;
	}

	// pre: nothing
	// post: returns capacity
	public double getCapacity() {
		return this.capacity;
	}

	// pre: nothing
	// post: returns arriving airport
	public Airport getArriving() {
		return this.arriving;
	}

	// pre: nothing
	// post: returns departing airport
	public Airport getDeparting() {
		return this.departing;
	}

	// pre: nothing
	// post: returns the list of seats
	public ArrayList<Seat> getSeats() {
		return this.seats;
	}

	// pre: nothing
	// post: returns departureTime
	public int getDepartureTime() {
		return this.departureTime;
	}

	// pre: nothing
	// post: returns this flight's airline
	public Airline getAirline() {
		return this.airline;
	}

	// pre: an Airline airline
	// post: sets the field airline to the parameter airline
	public void setAirline(Airline airline) {
		this.airline = airline;
	}

	// pre: nothing
	// post: returns the departure date
	public Date getDepartureDate() {
		return this.departureDate;
	}

	// pre: nothing
	// post: returns the arrival time
	public int getArrivalTime() {
		return this.arrivalTime;
	}

	// pre: nothing
	// post: returns the arrival date
	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	// pre: a String flightNumber
	// post: returns flightNumber
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	// pre: an Aircraft aircraft
	// post: sets the field aircraft to the parameter aircraft
	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	// pre: a double capacity
	// post: sets the field capacity to the parameter capacity
	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	// pre: an Airport arriving
	// post: sets the field arriving to the parameter arriving
	public void setArriving(Airport arriving) {
		this.arriving = arriving;
	}

	// pre: an Airport departing
	// post: sets the field departing to the parameter departing
	public void setDeparting(Airport departing) {
		this.departing = departing;
	}

	// pre: an ArrayList of Seat seats
	// post: sets the field seats the parameter seats
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}

	// pre: an int departureTime
	// post: sets the field departureTime to the parameter departureTime
	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	// pre: a Date departureDate
	// post: sets the field departureDate to the parameter departureDate
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	// pre: an int arrivalTime
	// post: sets the field arrivalTime to the parameter arrivalTime
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	// pre: a Date arrivalDate
	// post: sets the field arrivalDate to the parameter arrivalDate
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	// pre: nothing
	// post: returns the price of the flight
	public double getPrice() {
		return this.price;
	}

	// pre: a double price
	// post: sets the field price to the parameter price
	public void setPrice(double price) {
		this.price = price;
	}

	// pre: an Entry entry
	// post: calculates the price of flight
	public void calculatePrice(Entry entry) {
		Random r = new Random();
		double randomNumber = 20 + (30 - 20) * r.nextDouble();
		double temp = 1.0 / (entry.getDepartureDate().getDay() - LocalDate.now().getDayOfMonth());
		double answer = entry.getSeatPriority().getPriority() * temp *
				(this.getDistance() / (20 + this.getAircraft().getFuelEfficiency()) * 
				1.2 * this.getAirline().getMultiplier()) + randomNumber; // multiply this by date
		answer = Math.max(80, answer);
		
		this.setPrice(answer);
	}
	
	// pre: a Seat seat
	// post: if capacity is not full, adds seat to seats
	public void addSeat(Seat seat) {
		if(!this.isFull()) {
		this.seats.add(seat);
		} else {
			System.out.println("Cannot add seat, capacity is full.");
		}
	}
}
