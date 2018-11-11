package software;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.StringTokenizer;

import reservables.air.*;
import reservables.hotels.*;
public class Entry {

	// basically delete the date class from reservables
	// flight
	private java.time.LocalDate departureDate;
	private java.time.LocalDate returnDate;
	private Airport departureAirport;
	private Airport returnAirport;
	private int passengers;
	private int seatPriority;
	private boolean flight, hotel, car;
	private String departingCity;
	private String destinationCity;
	
	
	// hotel
	private java.time.LocalDate checkInDate;
	private java.time.LocalDate checkOutDate;
	private Room roomType;
	
	
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
		this.roomType = null;
		
		this.takeDate = null;
		this.giveBackDate = null;
		this.carClass = 0;
		this.flight = false;
		this.hotel = false;
		this.car = false;
		this.departingCity = null;
		this.destinationCity = null;
	}
	
	public void askFlight() {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("Would you like to search flights? (y/n): ");
			String response = input.next();
	    	if(response.equalsIgnoreCase("y")) {
	    		flight = true;
	    		input.close();
	    		return;
	    	}
	    	else if(response.equalsIgnoreCase("n")) {
	    		flight = false;
	    		input.close();
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    		flight = false;
	    		continue;
	    	}
		}
		
	}
	
	public void askHotel() {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("Would you like to search hotels? (y/n): ");
			String response = input.next();
			if(response.equalsIgnoreCase("y")) {
	    		hotel = true;
	    		input.close();
	    		return;
	    	}
	    	else if(response.equalsIgnoreCase("n")) {
	    		hotel = false;
	    		input.close();
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    		hotel = false;
	    		continue;
	    	}
		}
	}
	
	public void askCar() {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.print("Would you like to search cars? (y/n): ");
			String response = input.next();
			if(response.equalsIgnoreCase("y")) {
	    		car = true;
	    		input.close();
	    		return;
	    	}
	    	else if(response.equalsIgnoreCase("n")) {
	    		car = false;
	    		input.close();
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    		car = false;
	    		continue;
	    	}
		}
	}
	
	public void askFlightDepartDate() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your departure date (YYYY MM DD): ");
		StringTokenizer line = new StringTokenizer(input.nextLine(), " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate departDate = LocalDate.of(year, month, day);
		this.departureDate = departDate;
		input.close();
	}
	
	public void askFlightReturnDate() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your departure date (YYYY MM DD): ");
		StringTokenizer line = new StringTokenizer(input.nextLine(), " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate returnDate = LocalDate.of(year, month, day);
		this.returnDate = returnDate;
		input.close();
	}
	
	public void askDepartCity() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the city from which you are leaving: ");
		String response = input.next();
		this.departingCity = response;
		// needs to validate
		input.close();
	}

	public void askDestinationCity() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your destination: ");
		String response = input.next();
		this.destinationCity = response;
		// needs to validate
		input.close();
	}
	
	public void askSeatPriority() {
		Scanner input = new Scanner(System.in);
		System.out.print("Would you like First Class, Business, or Economy seating?: ");
		String response = input.next();
		if(response.toLowerCase().equals("First Class")) {
			this.seatPriority = 2;
		}
		else if(response.toLowerCase().equals("Business")) {
			this.seatPriority = 1;
		}
		else if(response.toLowerCase().equals("Economy")) {
			this.seatPriority = 0;
		}
		else {
			this.seatPriority = 0;
		}
		// needs to validate
		input.close();
	}
	
	public void askPassengers() {
		Scanner input = new Scanner(System.in);
		System.out.print("How many passengers will be flying? : ");
		String response = input.next();
		this.passengers = Integer.parseInt(response);
		input.close();
	}
	
	public void askHotelCheckInDate() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your Check-In date (YYYY MM DD): ");
		StringTokenizer line = new StringTokenizer(input.nextLine(), " ");
    	int year = Integer.parseInt(line.nextToken());
    	int month = Integer.parseInt(line.nextToken());
		int day = Integer.parseInt(line.nextToken());
		LocalDate departDate = LocalDate.of(year, month, day);
		this.departureDate = departDate;
		input.close();
	
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
	public Seat getSeatPriority() {
		return this.seatPriority;
	}
	
	// pre: a Seat seatPriority
	// post: sets the field seatPriority to the parameter seatPriority
	public void setSeatPriority(Seat seatPriority) {
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
	public Room getRoomType() {
		return this.roomType;
	}
	
	// pre: a Room roomType
	// post: sets the field roomType to the parameter roomType
	public void setRoomType(Room roomType) {
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
		return departingCity;
	}

	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}
}
