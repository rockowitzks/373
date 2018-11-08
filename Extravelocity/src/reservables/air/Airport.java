package reservables.air;

import java.util.*;

public class Airport {
	private ArrayList<Flight> arrivalList;
	private ArrayList<Flight> departureList;
	private ArrayList<Airline> airlineList;
	double longitude;
	double latitude;
	private String name;
	private int group;

	// pre: nothing
	// post: instantiates the object
	public Airport() {
		arrivalList = new ArrayList<Flight>();
		departureList = new ArrayList<Flight>();
		airlineList = new ArrayList<Airline>();
		this.group = 0;
	}
	
	// pre: parameters corresponding to fields
	// post: sets fields to parameters
	public Airport(ArrayList<Flight> arrivalList, ArrayList<Flight> departureList, String name,
			ArrayList<Airline> airlineList, double longitude, double latitude, int group) {
		this.arrivalList = arrivalList;
		this.departureList = departureList;
		this.latitude = latitude;
		this.longitude = longitude;
		this.airlineList = airlineList;
		this.group = group;
		this.name = name;
	}
	// pre: nothing
	// post: returns arrivalList
	public ArrayList<Flight> getArrivalList() {
		return this.arrivalList;
	}

	// pre: nothing
	// post: returns departureList
	public ArrayList<Flight> getDepartureList() {
		return this.departureList;
	}

	// pre: nothing
	// post: returns name
	public String getName() {
		return this.name;
	}

	// pre: a String name
	// post: sets the field name to the parameter name
	public void setName(String name) {
		this.name = name;
	}

	// pre: nothing
	// post: returns airlineList
	public ArrayList<Airline> getAirlineList() {
		return this.airlineList;
	}

	// pre: nothing
	// post: returns group
	public int getGroup() {
		return this.group;
	}

	// pre: an ArrayList of Flight arrivalList
	// post: sets the field arrivalList to the parameter arrivalList
	public void setArrivalList(ArrayList<Flight> arrivalList) {
		this.arrivalList = arrivalList;
	}
	
	// pre: nothing
	// post: returns longitude
	public double getLongitude() {
		return this.longitude;
	}

	// pre: a double longitude
	// post: sets the field longitude to the parameter longitude
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	// pre: nothing
	// post: returns latitude
	public double getLatitude() {
		return this.latitude;
	}

	// pre: a double latitude
	// post: sets the field latitude to the parameter latitude
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	// pre: an ArrayList of Flight departureList
	// post:sets the field departureList 
	public void setDepartureList(ArrayList<Flight> departureList) {
		this.departureList = departureList;
	}

	// pre: an ArrayList of Airline called airlineList
	// post: sets the field airlineList to the parameter airlineList
	public void setAirlineList(ArrayList<Airline> airlineList) {
		this.airlineList = airlineList;
	}

	// pre: an int group
	// post:sets the field group to the parameter group
	public void setGroup(int group) {
		this.group = group;
	}

	// pre: a flight arrival
	// post: adds arrival to arrivalList
	public void addArrival(Flight arrival) {
		arrivalList.add(arrival);
		}

	// pre: a flight departure
	// post: adds departure to departureList
	public void addDeparture(Flight departure) {
		departureList.add(departure);
	}

	// pre: an Airline airline
	// post: adds airline to airlineList if airline does not exist in airlineList, else prints an error message
	public void addAirline(Airline airline) {
		if(!airlineList.contains(airline)) {
		airlineList.add(airline);
		}
		System.out.println("Error: airline " + airline.getName() + " already exists in " + this.getName() 
		+ ".");
	}
}
