package reservables.air;

import java.util.*;
import software.*;


public class Route {
	private Airport begin;
	private ArrayList<Flight> flights;
	private Airport end;
	private ArrayList<Layover> layoverList;
	private int totalTime;
	private double price;

	// pre: a Flight flight
	// post: initializes the object and adds flight to flights
	public Route(Flight flight) {
		this.begin = null;
		this.flights = new ArrayList<Flight>();
		this.end = null;
		this.layoverList = new ArrayList<Layover>();
		this.totalTime = 0;
		this.price = 0;
		this.flights.add(flight);
		
	}
	
	// pre: nothing
	// post: initializes the object
	public Route() {
		this.begin = null;
		this.flights = new ArrayList<Flight>();
		this.end = null;
		this.layoverList = new ArrayList<Layover>();
		this.totalTime = 0;
		this.price = 0;
	}
	
	// pre: nothing
	// post: returns begin
	public Airport getBegin() {
		return this.begin;
	}

	// pre: nothing
	// post: returns flights
	public ArrayList<Flight> getFlights() {
		return this.flights;
	}

	// pre: nothing
	// post: returns end
	public Airport getEnd() {
		return this.end;
	}

	// pre: nothing
	// post: returns layoverList
	public ArrayList<Layover> getLayoverList() {
		return this.layoverList;
	}

	// pre: nothing
	// post: returns totalTime
	public int getTotalTime() {
		return this.totalTime;
	}

	// pre: an Airport begin
	// post: sets the field begin to the parameter begin
	public void setBegin(Airport begin) {
		this.begin = begin;
	}

	// pre: an ArrayList Flight flights
	// post: sets the field flights to the parameter flights
	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}


	// pre: an Airport end
	// post: sets the field end to the parameter end
	public void setEnd(Airport end) {
		this.end = end;
	}

	// pre: an ArrayList of Layover layoverList
	// post: sets the field layoverList to the parameter layoverList
	public void setLayoverList(ArrayList<Layover> layoverList) {
		this.layoverList = layoverList;
	}

	// pre: an int totalTime
	// post: sets the field totalTime to the parameter totalTime
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	// pre: nothing
	// post: returns price
	public double getPrice() {
		return this.price;
	}

	// pre: a double price
	// post: sets the field price to the double price
	public void setPrice(double price) {
		this.price = price;
	}
	
	// pre: a Flight flight
	// post: if flight does not exist in flights, adds flight to flights and returns true, else prints an error
	//		and returns false
	public boolean addFlight(Flight flight) {
		if(!this.flights.contains(flight)) {
			return (this.flights.add(flight));
		} else {
			System.out.println("The flight " + flight + "already exists in flights");
			return false;
		}
	}
	// pre: an Entry entry
	// post: calculates the price of the route
	public double calculatePrice(Entry entry) {
		double answer = 0;
		for(Flight flight : flights) {
			answer += flight.calculatePrice(entry);
		}
		return answer;
	}

	// pre: nothing
	// post: returns true if the route's flight actually connect
	public boolean checkValidity() {
		for(int i = 0; i < flights.size() - 1; i++) {
			if(flights.get(i).getArriving() != flights.get(i + 1).getDeparting()) {
				System.out.println("Arriving of flights (" + i + ") is " + this.flights.get(i).getArriving()
						+ " Departing of flights (" + (i + 1) + ") is " + this.flights.get(i + 1).getDeparting());
				return false;
			}
		}
		return true;
	}

	// pre: nothing
	// post: returns the total time spent in layovers
	public void calcLayover() {
		Layover layover;
		if(!checkValidity()) {
			System.exit(-7);
		}
		
		for(int i = 0; i < this.flights.size() - 1; i++) {
			layover = new Layover();
			layover.setAirport(this.flights.get(i).getArriving());
		}
	}
	
	// pre: nothing
	// post: returns a String of this object
	public String toString() {
		String answer = "";
		for(Flight flight : flights) {
			answer.concat(flight.toString());
		}
		answer.concat("		$" + this.getPrice() + "\n");
		return answer;
	} 
}
