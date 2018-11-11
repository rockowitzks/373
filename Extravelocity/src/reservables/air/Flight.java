package reservables.air;

import java.util.*;
import java.time.*;

import software.*;

public class Flight {
	private String flightNumber;
	private Airline airline;
	private Aircraft aircraft;
	private double capacity;
	private Airport arriving; 
	private Airport departing; 
	private ArrayList<Seat> seats;
	private int departureTime; 
	private java.time.LocalDateTime departureDate;
	private int arrivalTime; 
	private java.time.LocalDateTime arrivalDate;
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
			Airport departing, ArrayList<Seat> seats, int departureTime, java.time.LocalDateTime departureDate,
			int arrivalTime, java.time.LocalDateTime arrivalDate, double distance, double price) {
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
	// post: returns true if seat size equals capacity, exits if seat size is greater than capacity, false otherwise
	public boolean isFull() {
		if(this.seats.size() > capacity) {
			System.out.println("You made a mistake, seats size is " +  this.seats.size() + 
					" and capacity is " + this.capacity + ". Dumb mistake.");
			System.exit(-1);
			return true;
		}
		return (this.seats.size() == capacity);
	}
	
	// pre: an int people and an int seatClass
	// post: returns true if there are enough seats to accommodate the amount people in the given seatClass
	public boolean hasEnoughSeats(int people, int seatClass) {
		int available = 0;
		for(Seat seat: this.getSeats()) {
			if(seat.getAvailable() && seat.getPriority() == seatClass) {
				available++;
			}
		}
		return (available >= people);
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
		return this.distance;
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
	public java.time.LocalDateTime getDepartureDate() {
		return this.departureDate;
	}

	// pre: nothing
	// post: returns the arrival time
	public int getArrivalTime() {
		return this.arrivalTime;
	}

	// pre: nothing
	// post: returns the arrival date
	public java.time.LocalDateTime getArrivalDate() {
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
	public void setDepartureDate(java.time.LocalDateTime departureDate) {
		this.departureDate = departureDate;
	}

	// pre: an int arrivalTime
	// post: sets the field arrivalTime to the parameter arrivalTime
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	// pre: a Date arrivalDate
	// post: sets the field arrivalDate to the parameter arrivalDate
	public void setArrivalDate(java.time.LocalDateTime arrivalDate) {
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
	
	// pre: nothing
	// post: returns the flight duration
	public Duration getDuration() {
		return Duration.between(getDepartureDate(), getArrivalDate());		
	}

	// pre: nothing
	// post: returns a double that is based on the distance of the flight,
	//		which acts as a multiplier in price calculation
	public double getDistancePrice() {
		if(this.getDistance() > 0 && this.getDistance() < 4500) {
			return 0.002 * this.getDistance();
		} else if (this.getDistance() >= 4500 && this.getDistance() < 8000) {
			return 0.003 * this.getDistance();
		} else if(this.getDistance() >= 8000) {
			return 0.0035 * this.getDistance();
		} else {
			System.out.println("Error, distance should be greater than 0 but it is " + this.getDistance());
			return 0;
		}
	}
	
	// pre: an Entry entry
	// post: calculates the price of flight
	public double calculatePrice(Entry entry) {
		Random r = new Random();
		double randomNumber = 20 + (30 - 20) * r.nextDouble();
		
		Period urgencyFactor = Period.between(entry.getDepartureDate(), LocalDate.now());
		long duration = this.getDuration().toHours();
		
		
		double sum = this.getAirline().getMultiplier() + randomNumber - (0.7 * duration);
		double product = (1 + Math.exp(-1.0 * urgencyFactor.getDays())) * this.getArriving().getAirportMultiplier()
				* this.getDeparting().getAirportMultiplier() * entry.getSeatPriority().getPriority()
				* this.getDistancePrice();
		
		double answer = product * sum;
		answer = Math.max(50, answer);
		
		this.setPrice(answer);
		return this.getPrice();
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
	
	// pre: nothing
	// post: converts the flight's information to a String 
	public String toString() {
		String answer = "";
		answer.concat(this.getFlightNumber() + "  " + this.getAirline().getName());
		answer.concat(" ");
		return answer;
	}
}
