package software;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.StringTokenizer;

import reservables.air.*;
public class Entry implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6509313801532472832L;
	// basically delete the date class from reservables
	// flight
	private java.time.LocalDate departureDate;
	private java.time.LocalDate returnDate;
	private Airport departureAirport;
	private Airport returnAirport;
	private int passengers;
	private double seatPriority;
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
	private String carCity;
	
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
	
	// pre: a Scanner input
	// post: asks for flight information
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
	
	// pre: A Scanner input
	// post: asks for hotel information 
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
	
	// pre: a Scanner input
	// post: asks for the car information
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
	
	// pre: a Scanner input
	// post: asks for the fligth departing date
	public void askFlightDepartDate(Scanner input) {
		while(true) {
		System.out.print("Please enter your departure date (YYYY MM DD): ");
		String date = input.nextLine().trim();
		StringTokenizer line = new StringTokenizer(date, " ");
		String token = line.nextToken();
    	int year = Integer.parseInt(token);
    	token = line.nextToken();
    	int month = Integer.parseInt(token);
    	token = line.nextToken();
		int day = Integer.parseInt(token);
		LocalDate departDate = LocalDate.of(year, month, day);
		if(departDate.compareTo(LocalDate.now()) < 0) {
			System.out.println("Please enter a date after today's date");
			continue;
		}
		this.departureDate = departDate;
		break;
		}
	} //TODO add error checking
	//pre string input
	//post localdate output
	public LocalDate convertDate(String string) {
		//while(true) {
		//System.out.print("Please enter your departure date (YYYY MM DD): ");
		//String date = input.nextLine().trim();
		StringTokenizer line = new StringTokenizer(string, "/");
		String token = line.nextToken();
    	int month = Integer.parseInt(token);
    	token = line.nextToken();
    	int day = Integer.parseInt(token);
    	token = line.nextToken();
		int year = Integer.parseInt(token);
		LocalDate departDate = LocalDate.of(year, month, day);
		if(departDate.compareTo(LocalDate.now()) < 0) {
			System.out.println("Please enter a date after today's date");}
		return departDate;
	
	}
	
	// pre: a Scanner iput 
	// post: asks for a flight return date
	public void askFlightReturnDate(Scanner input) {
		while(true) {
			System.out.print("Please enter your return date (YYYY MM DD): ");
			String date = input.nextLine().trim();
			StringTokenizer line = new StringTokenizer(date, " ");
			String token = line.nextToken();
	    	int year = Integer.parseInt(token);
	    	token = line.nextToken();
	    	int month = Integer.parseInt(token);
	    	token = line.nextToken();
			int day = Integer.parseInt(token);
			LocalDate returnDate = LocalDate.of(year, month, day);
			if(returnDate.compareTo(LocalDate.now()) < 0) {
				System.out.println("Please enter a date after today's date");
				continue;
			}
			this.returnDate = returnDate;
			break;
		}
	}
	
	// pre: a Scanner input
	// post: asks for the departing city
	public void askDepartCity(Scanner input) {
		System.out.print("Please enter the city from which you are leaving: ");
		String response = input.nextLine().trim();
		this.departingCity = response;
		// needs to validate

	}

	// pre: a Scanner input
	// post: asks for the destination city
	public void askDestinationCity(Scanner input) {
		System.out.print("Please enter your destination: ");
		String response = input.nextLine().trim();
		this.destinationCity = response;
		// needs to validate

	}
	
	// pre: a Scanner input
	// post: asks for the seat priority
	public void askSeatPriority(Scanner input) {
		while(true) {
			System.out.print("Would you like First Class, Business, or Economy seating? ");
			String response = input.nextLine().trim();	
			if(response.toLowerCase().equalsIgnoreCase("First Class")) {
				this.seatPriority = 5;
			} else if(response.toLowerCase().equalsIgnoreCase("Business")) {
				this.seatPriority = 2;
			} else if(response.toLowerCase().equalsIgnoreCase("Economy")) {
				this.seatPriority = 0.65;
			} else {
				System.out.println("Please enter First Class, Business, or Economy");
				continue;
			}
			break;
		}
	}
	public void assignSeatPriority(String response) {
		while(true) {
			//System.out.print("Would you like First Class, Business, or Economy seating? ");
			//String response = input.nextLine().trim();	
			if(response.toLowerCase().equalsIgnoreCase("First Class")) {
				this.seatPriority = 5;
			} else if(response.toLowerCase().equalsIgnoreCase("Business")) {
				this.seatPriority = 2;
			} else if(response.toLowerCase().equalsIgnoreCase("Economy")) {
				this.seatPriority = 0.65;
			} else {
				//System.out.println("Please enter First Class, Business, or Economy");
				continue;
			}
			break;
		}
	}
	
	// pre: a scanner input
	// post: asks the user for how many passengers they want to reserve
	public void askPassengers(Scanner input) {
		System.out.print("How many passengers will be flying? : ");
		String response = input.nextLine().trim();
		this.passengers = Integer.parseInt(response);
	}
	
	// pre: a Scanner input
	// post: asks hotel check in date
	public void askHotelCheckInDate(Scanner input) {
		while(true) {
			System.out.print("Please enter your Check-In date (YYYY MM DD): ");
			String token = input.nextLine().trim();
			StringTokenizer line = new StringTokenizer(token, " ");
	    	int year = Integer.parseInt(line.nextToken());
	    	int month = Integer.parseInt(line.nextToken());
			int day = Integer.parseInt(line.nextToken());
			LocalDate hotelCheckIn = LocalDate.of(year, month, day);
			if(hotelCheckIn.compareTo(LocalDate.now()) < 0) {
			System.out.println("Please enter a date after today's date");
			continue;
			}
			
			this.checkInDate = hotelCheckIn;
			break;
		}
	}
	
	// pre: a Scanner input
	// post: asks hotel check out date
	public void askHotelCheckOutDate(Scanner input) {
		while(true) {
			System.out.print("Please enter your Check-Out date (YYYY MM DD): ");
			String token = input.nextLine().trim();
			StringTokenizer line = new StringTokenizer(token, " ");
	    	int year = Integer.parseInt(line.nextToken());
	    	int month = Integer.parseInt(line.nextToken());
			int day = Integer.parseInt(line.nextToken());
			LocalDate hotelCheckOut = LocalDate.of(year, month, day);
			if(hotelCheckOut.compareTo(LocalDate.now()) < 0) {
				System.out.println("Please enter a date after today's date");
				continue;
			}
			this.checkOutDate = hotelCheckOut;
			break;
		}
		
	}
	
	// pre: a Scanner input
	// post: asks room type
	public void askRoomType(Scanner input) {
		while(true) {
			System.out.print("What room type would you like (Luxury, Standard, Economy): ");
			String response = input.nextLine().trim();
			if(response.equalsIgnoreCase("Luxury")) {
				this.roomType = 3;
			}
			else if(response.equalsIgnoreCase("Standard")) {
				this.roomType = 2;
			}
			else if(response.equalsIgnoreCase("Economy")) {
				this.roomType = 1;
			}
			else {
				System.out.println("Please enter Luxury, Standard, or Economy");
				continue;
			}
			break;
		}
	}
	
	// pre: a Scanner input
	// post: asks for the car information
	public void askCarRentalDate(Scanner input) {
		while(true) {
			System.out.print("Please enter your Rental date (YYYY MM DD): ");
			String token = input.nextLine().trim();
			StringTokenizer line = new StringTokenizer(token, " ");
	    	int year = Integer.parseInt(line.nextToken());
	    	int month = Integer.parseInt(line.nextToken());
			int day = Integer.parseInt(line.nextToken());
			LocalDate carRentalDate = LocalDate.of(year, month, day);
			if(carRentalDate.compareTo(LocalDate.now()) < 0) {
				System.out.println("Please enter a date after today's date");
				continue;
			}
			this.takeDate = carRentalDate;
			break;
		}
	
	}
	
	// pre: a Scanner input
	// post: asks for the car information
	public void askCarReturnDate(Scanner input) {
		while(true) {
			System.out.print("Please enter your Return date (YYYY MM DD): ");
			String token = input.nextLine().trim();
			StringTokenizer line = new StringTokenizer(token, " ");
	    	int year = Integer.parseInt(line.nextToken());
	    	int month = Integer.parseInt(line.nextToken());
			int day = Integer.parseInt(line.nextToken());
			LocalDate carReturnDate = LocalDate.of(year, month, day);
			if(carReturnDate.compareTo(LocalDate.now()) < 0) {
				System.out.println("Please enter a daet after today's date");
				continue;
			}
			this.giveBackDate = carReturnDate;
			break;
		}
	}
	
	// pre: a Scanner input
	// post: asks for car class
	public void askCarClass(Scanner input) {
		while(true) {
			System.out.print("What car class would you like (Luxury, Standard, Economy): ");
			String response = input.nextLine().trim();
			if(response.equalsIgnoreCase("Luxury")) {
				this.carClass = 3;
			}
			else if(response.equalsIgnoreCase("Standard")) {
				this.carClass = 2;
			}
			else if(response.equalsIgnoreCase("Economy")) {
				this.carClass = 1;
			}
			else {
				System.out.println("Please enter Luxury, Standard, or Economy");
				continue;
			}
			break;
		}
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
	public double getSeatPriority() {
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
	// post: sets the field checkOutDate to the parameter checkOutDate
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
	
	// pre: nothing
	// post: returns flight
	public boolean getFlight() {
		return this.flight;
	}
	
	// pre: nothing
	// post: returns hotel
	public boolean getHotel() {
		return this.hotel;
	}
	
	// pre: nothing
	// post: returns car
	public boolean getCar() {
		return this.car;
	}

	// pre: nothing
	// post: returns destinationCity
	public String getDestinationCity() {
		return this.destinationCity;
	}

	// pre: a String destinationCity
	// post: sets the field destinationCity to the parameter destinationCity
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}

	// pre: nothing
	// post: returns departingCity
	public String getDepartingCity() {
		return this.departingCity;
	}

	// pre: a String departingCity
	// post: sets the field departingCity to the parameter departingCity
	public void setDepartingCity(String departingCity) {
		this.departingCity = departingCity;
	}

	public void assignRoomType(String response) {
		if(response.equalsIgnoreCase("Luxury")) {
			this.roomType = 3;
		}
		else if(response.equalsIgnoreCase("Standard")) {
			this.roomType = 2;
		}
		else if(response.equalsIgnoreCase("Economy")) {
			this.roomType = 1;
		}		
	}

	public void assignCarClass(String response) {
		if(response.equalsIgnoreCase("Luxury")) {
			this.carClass = 3;
		}
		else if(response.equalsIgnoreCase("Standard")) {
			this.carClass = 2;
		}
		else if(response.equalsIgnoreCase("Economy")) {
			this.carClass = 1;
		}
	}

	public void setCarCity(String selectedItem) {
		carCity = selectedItem;
		
	}

	public String getCarCity() {
		return carCity;
	}
}
