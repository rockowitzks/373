package reservables.air;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


public class Airport implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Flight> arrivalList;
	private ArrayList<Flight> departureList;
	private ArrayList<Airline> airlineList;
	private ArrayList<Connection> connections;
	private String longitude;
	private HashMap<LocalDateTime, Boolean> generated;
	private String latitude;
	private String name;
	private int group;
	private String city;
	private double airportMultiplier;

	// pre: nothing
	// post: instantiates the object
	public Airport() {
		arrivalList = new ArrayList<Flight>();
		departureList = new ArrayList<Flight>();
		airlineList = new ArrayList<Airline>();
		connections = new ArrayList<Connection>();	
		this.generated = new HashMap<LocalDateTime, Boolean>();
		this.group = 0;
	}
	
	// pre: parameters corresponding to fields
	// post: sets fields to parameters
	public Airport(ArrayList<Flight> arrivalList, ArrayList<Flight> departureList, String name,
			ArrayList<Airline> airlineList, String longitude, String latitude, int group) {
		this.arrivalList = arrivalList;
		this.departureList = departureList;
		this.latitude = latitude;
		this.longitude = longitude;
		this.airlineList = airlineList;
		this.group = group;
		this.name = name;
		this.generated = new HashMap<LocalDateTime, Boolean>();
	}
	
	public HashMap<LocalDateTime, Boolean> getGenerated() {
		return generated;
	}

	public void setGenerated(HashMap<LocalDateTime, Boolean> generated) {
		this.generated = generated;
	}

	//pre: parameters correspond to fields found in file
	//post: sets fields to parameters
	public Airport(String name, String city, String lat, String ln, double multiplier) {
		arrivalList = new ArrayList<Flight>();
		departureList = new ArrayList<Flight>();
		airlineList = new ArrayList<Airline>();
		connections = new ArrayList<Connection>();
		this.name = name;
		this.setCity(city);
		this.latitude = lat;
		this.longitude = ln;
		this.airportMultiplier = multiplier;
		this.generated = new HashMap<LocalDateTime, Boolean>();
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
	
	// pre: nothing
	// post: returns airportMultiplier;
	public double getAirportMultiplier() {
		return this.airportMultiplier;
	}

	// pre: a double airportMultipler
	// post: sets the field airportMultiplier to the parameter airportMultiplier if the parameter is not greater than 1.4
	public void setAirportMultiplier(double airportMultiplier) {
		if(airportMultiplier  <= 1.4 && airportMultiplier > 0) {
		this.airportMultiplier = airportMultiplier;
		} else {
			System.out.println("Error. AirportMultipler is " + airportMultiplier + ". It should be between 0 and 1.4!");
		}
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
	public String getLongitude() {
		return this.longitude;
	}

	// pre: a double longitude
	// post: sets the field longitude to the parameter longitude
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	// pre: nothing
	// post: returns latitude
	public String getLatitude() {
		return this.latitude;
	}

	// pre: a double latitude
	// post: sets the field latitude to the parameter latitude
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	// pre: an ArrayList of Flight departureList
	// post:sets the field departureList 
	public void setDepartureList(ArrayList<Flight> departureList) {
		this.departureList = departureList;
	}

	
	// pre: nothing
	// post: returns connections
	public ArrayList<Connection> getConnections() {
		return this.connections;
	}

	// pre: an ArrayList of Connection connections
	// post: sets the field connections to the parameter connections
	public void setConnections(ArrayList<Connection> connections) {
		this.connections = connections;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
	
	// pre: a Connection connection
	// post: adds connection to connections
	public void addConnection(Connection connection) {
		this.connections.add(connection);
	}
	
	// pre: a FileOutPutStream out
	// post: writes Object
	public void airportOut(FileOutputStream out) throws IOException {
		ObjectOutputStream objOut = new ObjectOutputStream(out);
		objOut.writeObject(this);
	}
	
	// pre: nothing
	// post: returns the name of the airport
	public String toString() {
		return this.getName();
	}

}
