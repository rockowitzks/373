package software;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.StringTokenizer;

import reservables.air.*;
public class Entry {

	// basically delete the date class from reservables
	// flight
	private java.time.LocalDate departureDate;
	private java.time.LocalDate returnDate;
	private Airport departureAirport;
	private Airport returnAirport;
	private int passengers;
	private int seatPriority;
	private boolean flight;
	private boolean hotel;
	private boolean car;
	private String departingCity;
	private String destinationCity;
	
	
	// hotel
	private java.time.LocalDate checkInDate;
	private java.time.LocalDate checkOutDate;
	private int roomType;
	
	
	// car
	private java.time.LocalDate takeDate;
	private java.time.LocalDate giveBackDate;
	private int carClass;
	
	// pre: nothing
	// post: instantiates the object
	public Entry() {
		this.departureAirport = null;
		this.returnDate = null;
		this.departureDate = null;
		this.returnAirport = null;
		this.passengers = 0;
		this.seatPriority = 0;
		
		this.checkInDate = null;
		this.checkOutDate = null;
		this.roomType = 0;
		
		this.takeDate = null;
		this.giveBackDate = null;
		this.carClass = 0;
		this.flight = false;
		this.hotel = false;
		this.car = false;
		this.departingCity = null;
		this.destinationCity = null;
	}
	
	// pre: a Website web
	// post: takes the user input for departure and returning city, then adds the airport to the user entry class
	public void findAirportFromCity(Website website) {
		for (Airport airport: website.getAirportList()) {
			if(airport.getCity().equals(this.departingCity)) {
				this.departureAirport = airport;
			}
		}
		for (Airport airport: website.getAirportList()) {
			if(airport.getCity().equals(this.destinationCity)) {
				this.returnAirport = airport;
			}
		}
		
		if(this.departureAirport == null) {
			System.out.println("Could not locate departing airport");
		}
		
		if(this.returnAirport == null) {
			System.out.println("Could not locate destination airport");
		}
	}
	
	public void askFlight(Scanner input) {
		while(true) {
			System.out.print("Would you like to search flights? (y/n): ");
			String response = "";
			response = input.nextLine();
	    	if(response.equalsIgnoreCase("y")) {
	    		this.flight = true;
	    		return;
	    	}
	    	else if(response.equalsIgnoreCase("n")) {
	    		this.flight = false;
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    		this.flight = false;
	    		continue;
	    	}
		}
		
	}
	
	public void askHotel(Scanner input) {
		while(true) {
			System.out.print("Would you like to search hotels? (y/n): ");
			String response = "";
			response = input.nextLine();
			if(response.equalsIgnoreCase("y")) {
	    		this.hotel = true;
	    		return;
	    	}
	    	else if(response.equalsIgnoreCase("n")) {
	    		this.hotel = false;
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    		this.hotel = false;
	    		continue;
	    	}
		}
	}
	
	public void askCar(Scanner input) {
		while(true) {
			System.out.print("Would you like to search cars? (y/n): ");
			String response = input.nextLine();
			if(response.equalsIgnoreCase("y")) {
	    		this.car = true;
	    		return;
	    	}
	    	else if(response.equalsIgnoreCase("n")) {
	    		this.car = false;
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    		this.car = false;
	    		continue;
	    	}
		}
	}
	
	public void askFlightDepartDate(Scanner input) {
		System.out.print("Please enter your departure date (YYYY MM DD): ");
		String date = input.nextLine();
		StringTokenizer line = new StringTokenizer(date, " ");
		String token = line.nextToken();
    	int year = Integer.parseInt(token);
    	token = line.nextToken();
    	int month = Integer.parseInt(token);
    	token = line.nextToken();
		int day = Integer.parseInt(token);
		LocalDate departDate = LocalDate.of(year, month, day);
		this.departureDate = departDate;
	}
	
	public void askFlightReturnDate(Scanner input) {
		System.out.print("Please enter your return date (YYYY MM DD): ");
		String date = input.nextLine();
		StringTokenizer line = new StringTokenizer(date, " ");
		String token = line.nextToken();
    	int year = Integer.parseInt(token);
    	token = line.nextToken();
    	int month = Integer.parseInt(token);
    	token = line.nextToken();
		int day = Integer.parseInt(token);
		LocalDate returnDate = LocalDate.of(year, month, day);
		this.returnDate = returnDate;
	}
	
	public void askDepartCity(Scanner input) {
		System.out.print("Please enter the city from which you are leaving: ");
		String response = input.nextLine().trim();
		this.departingCity = response;
		// needs to validate

	}

	public void askDestinationCity(Scanner input) {
		System.out.print("Please enter your destination: ");
		String response = input.nextLine().trim();
		this.destinationCity = response;
		// needs to validate

	}
	
	public void askSeatPriority(Scanner input) {
		System.out.print("Would you like First Class, Business, or Economy seating? ");
		String response = input.nextLine().trim();
		if(response.toLowerCase().equals("First Class")) {
			this.seatPriority = 5;
		}
		else if(response.toLowerCase().equals("Business")) {
			this.seatPriority = 2;
		}
		else if(response.toLowerCase().equals("Economy")) {
			this.seatPriority = 1;
		}
		else {
			this.seatPriority = 1;
		}
	}
	
	// pre: a scanner input
	// post: asks the user for how many passengers they want to reserve
	public void askPassengers(Scanner input) {
		System.out.print("How many passengers will be flying? : ");
		String response = input.nextLine().trim();
		this.passengers = Integer.parseInt(response);
	}
	
	public void askHotelCheckInDate(Scanner input) {
		System.out.print("Please enter your Check-In date (YYYY MM DD): ");
		String token = input.nextLine().trim();
		StringTokenizer line = new StringTokenizer(token, " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate hotelCheckIn = LocalDate.of(year, month, day);
		this.checkInDate = hotelCheckIn;

	}
	
	public void askHotelCheckOutDate(Scanner input) {
		System.out.print("Please enter your Check-Out date (YYYY MM DD): ");
		String token = input.nextLine().trim();
		StringTokenizer line = new StringTokenizer(token, " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate hotelCheckOut = LocalDate.of(year, month, day);
		this.checkOutDate = hotelCheckOut;
	}
	
	public void askRoomType(Scanner input) {
		System.out.print("What room type would you like (Luxury, Standard, Economy): ");
		String response = input.nextLine().trim();
		int type = 0;
		if(response.equals("Luxury")) {
			type = 3;
		}
		else if(response.equals("Standard")) {
			type = 2;
		}
		else if(response.equals("Economy")) {
			type = 1;
		}
		else {
			type = 1;
		}
		this.roomType = type;
	}
	
	public void askCarRentalDate(Scanner input) {
		System.out.print("Please enter your Rental date (YYYY MM DD): ");
		String token = input.nextLine().trim();
		StringTokenizer line = new StringTokenizer(token, " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate carRentalDate = LocalDate.of(year, month, day);
		this.takeDate = carRentalDate;
	}
	
	public void askCarReturnDate(Scanner input) {
		System.out.print("Please enter your Return date (YYYY MM DD): ");
		String token = input.nextLine().trim();
		StringTokenizer line = new StringTokenizer(token, " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate carReturnDate = LocalDate.of(year, month, day);
		this.giveBackDate = carReturnDate;
	}
	
	public void askCarClass(Scanner input) {
		System.out.print("What car class would you like (Luxury, Standard, Economy): ");
		String response = input.nextLine().trim();
		int type = 0;
		if(response.equals("Luxury")) {
			type = 3;
		}
		else if(response.equals("Standard")) {
			type = 2;
		}
		else if(response.equals("Economy")) {
			type = 1;
		}
		else {
			type = 1;
		}
		this.carClass = type;
	}
	
	// pre: nothing
	// post: return departureDate
	public java.time.LocalDate getDepartureDate() {
		return this.departureDate;
	}
	
	// pre: a Date departureDate
	// post: sets the field departureDate to the parameter departureDate
	public void setDepartureDate(java.time.LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	// pre: nothing
	// post: returns returnDate
	public java.time.LocalDate getReturnDate() {
		return this.returnDate;
	}
	
	// pre: a LocalDate returnDate
	// post: sets the field returnDate to the parameter returnDate
	public void setReturnDate(java.time.LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	// pre: nothing
	// post: returns departureAirport
	public Airport getDepartureAirport() {
		return this.departureAirport;
	}
	
	// pre: an Airport departureAirport
	// post: sets the field departureAirport to the parameter departureAirport
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	
	// pre: nothing 
	// post: returns returnAirport
	public Airport getReturnAirport() {
		return this.returnAirport;
	}
	
	// pre: an Airport returnAirport
	// post: sets the field returnAirport to the parameter returnAirport
	public void setReturnAirport(Airport returnAirport) {
		this.returnAirport = returnAirport;
	}
	
	// pre: nothing
	// post: returns passengers
	public int getPassengers() {
		return this.passengers;
	}
	
	// pre: an int passengers
	// post: sets the field passengers to the parameter passengers
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
	// pre: nothing
	// post: returns seatPriority
	public int getSeatPriority() {
		return this.seatPriority;
	}
	
	// pre: a Seat seatPriority
	// post: sets the field seatPriority to the parameter seatPriority
	public void setSeatPriority(int seatPriority) {
		this.seatPriority = seatPriority;
	}
	
	// pre: nothing
	// post returns checkInDate
	public java.time.LocalDate getCheckInDate() {
		return this.checkInDate;
	}
	
	// pre: a LocalDate checkInDate
	// post: sets the field checkInDate to the parameter checkInDate
	public void setCheckInDate(java.time.LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	// pre: nothing
	// post: returns checkOutDate
	public java.time.LocalDate getCheckOutDate() {
		return this.checkOutDate;
	}
	
	// pre: a LocalDate checkOutDate
	// post: sets teh field checkOutDate to the parameter checkOutDate
	public void setCheckOutDate(java.time.LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	// pre: nothing
	// post: returns roomType
	public int getRoomType() {
		return this.roomType;
	}
	
	// pre: a Room roomType
	// post: sets the field roomType to the parameter roomType
	public void setRoomType(int roomType) {
		this.roomType = roomType;
	}
	
	// pre: nothing
	// post: returns takeDate (takeDate of the car)
	public java.time.LocalDate getTakeDate() {
		return this.takeDate;
	}
	
	// pre: a LocalDate takeDate
	// post: sets the field takeDate to the parameter takeDate
	public void setTakeDate(java.time.LocalDate takeDate) {
		this.takeDate = takeDate;
	}
	
	// pre: nothing
	// post: returns giveBackDate
	public java.time.LocalDate getGiveBackDate() {
		return this.giveBackDate;
	}
	
	// pre: a LocalDate giveBackDate
	// post: sets the field giveBackDate to the parameter giveBackDate
	public void setGiveBackDate(java.time.LocalDate giveBackDate) {
		this.giveBackDate = giveBackDate;
	}
	
	// pre: nothing
	// post: returns carClass
	public int getCarClass() {
		return this.carClass;
	}
	
	// pre: an int carClass
	// post: sets the field carClass to the parameter carClass
	public void setCarClass(int carClass) {
		this.carClass = carClass;
	}
	public boolean getFlight() {
		return this.flight;
	}
	public boolean getHotel() {
		return this.hotel;
	}
	public boolean getCar() {
		return this.car;
	}

	public String getDestinationCity() {
		return destinationCity;
	}

	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	public String getDepartingCity() {
		return this.departingCity;
	}

	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}
}
