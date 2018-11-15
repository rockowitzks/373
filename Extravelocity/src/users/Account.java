package users;

import java.util.*;

import reservables.air.*;
import reservables.cars.*;
import reservables.hotels.*;
import software.*;

public class Account {
	private String name;
	private String email;
	private String accountName;
	private String password;
	private Card card;
	private ArrayList<Reservation> reservations;
	private Website website;

	// pre: nothing
	// post: initializes the object
	public Account() {
		name = null;
		email = null;
		accountName = null;
		password = null;
		reservations = new ArrayList<Reservation>();
	}
	
	// pre: parameters corresponding the fields
	// post: sets the fields to the parameters and instantiates the object
	public Account(String name, String email, String accountName, String password, Website website) {
		this.name = name;
		this.email = email;
		this.accountName = accountName;
		this.password = password;
		this.reservations = new ArrayList<Reservation>();
		this.website = website;
	}
	
	// pre: nothing
	// post: returns name
	public String getName() {
		return this.name;
	}

	// pre: nothing
	// post:" returns email
	public String getEmail() {
		return this.email;
	}

	// pre: nothing
	// post: returns accountName
	public String getAccountName() {
		return this.accountName;
	}

	// pre: nothing
	// post: returns password
	public String getPassword() {
		return this.password;
	}
	
	// pre: nothing
	// post: returns card
	public Card getCard() {
		return this.card;
	}
	
	// pre: a Card card
	// post: sets the field card to the parameter card
	public void setCard(Card card) {
		this.card = card;
	}
	// pre: nothing
	// post: returns reservation
	public ArrayList<Reservation> getReservations() {
		return this.reservations;
	}

	// pre: nothing
	// post: returns website
	public Website getWebsite() {
		return this.website;
	}

	// pre: a String name
	// post: sets the field name to the parameter name
	public void setName(String name) {
		this.name = name;
	}

	// pre: a String email
	// post: sets the field email to the parameter email
	public void setEmail(String email) {
		this.email = email;
	}

	// pre: a String accountName
	// post: sets the field accountName to the parameter accountName
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	// pre: a String password
	// post: sets the field password to the parameter password
	public void setPassword(String password) {
		this.password = password;
	}

	// pre: an ArrayList of Reservation reservations
	// post: sets the field reservations to the parameter reservations
	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	// pre: a Reservation reservation 
	// post: adds the reservation to the account's reservation list and set's the reservation's account to this
	public void addRerservation(Reservation reservation) {
		this.getReservations().add(reservation);
		reservation.setAccount(this);
	}

	// pre: a Website website
	// post: sets the field website to the parameter website
	public void setWebsite(Website website) {
		this.website = website;
	}

	// pre: a Scanner input
	// post: returns the Hotel that the user selects
	public Hotel selectHotel(Scanner input) {
		if(this.getWebsite().getHotelList().isEmpty()) {
			System.out.println("Error: hotel list (Account.java selectHotel) is empty");
			System.exit(-1);
			return null;
		}
		
		while(true) {
			System.out.println("Which hotel would you like to select? (Write in the number)");
			int index = Integer.parseInt(input.nextLine());
			if(index < 0 || index >= this.getWebsite().getHotelList().size()) {
				System.out.println(index + " is not a valid number because it is negative or greater than the "
						+ "last index of the hotel list " + (this.website.getHotelList().size() - 1) + ".");
				continue;
			}
			return this.getWebsite().getHotelList().get(index);
		}
	}

	// pre: a Scanner input
	// post: returns the Car that the user selects
	public Car selectCar(Scanner input) {
		if(this.getWebsite().getCarList().isEmpty()) {
			System.out.println("Error: car list is empty");
			System.exit(-1);
			return null;
		}
		
		while(true) {
			System.out.println("Which car would you like to select? (Write in the number)");
			int index = Integer.parseInt(input.nextLine());
			if(index < 0 || index >= this.getWebsite().getCarList().size()) {
				System.out.println(index + " is not a valid number because it is negative or greater than the "
						+ "last index of the car list " + (this.website.getCarList().size() - 1) + ".");
				continue;
			}
			return this.getWebsite().getCarList().get(index);
		}
	}

	// pre: a Scanner input
	// post: asks the user to select the departing route 
	public Route selectDepartingRoute(Scanner input) {
		if(this.getWebsite().getDepartureRouteList().isEmpty()) {
			System.out.println("Error: departure route list is empty");
			System.exit(-1);
			return null;
		}
		
		while(true) {
			System.out.println("Which departing route would you like to select? (Write in the number)");
			int index = Integer.parseInt(input.nextLine());
			if(index < 0 || index >= this.getWebsite().getDepartureRouteList().size()) {
				System.out.println(index + " is not a valid number because it is negative or greater than the "
						+ "last index of the departing route list " + 
						(this.website.getDepartureRouteList().size() - 1) + ".");
				continue;
			}
			return this.getWebsite().getDepartureRouteList().get(index);
		}
	}

	// pre: a Scanner input
	// post: asks the user to select the departing route
	public Route selectReturningRoute(Scanner input) {
		if(this.getWebsite().getReturnRouteList().isEmpty()) {
			System.out.println("Error: return route list list is empty");
			System.exit(-1);
			return null;
		}
		
		while(true) {
			System.out.println("Which return route would you like to select? (Write in the number)");
			int index = Integer.parseInt(input.nextLine());
			if(index < 0 || index >= this.getWebsite().getReturnRouteList().size()) {
				System.out.println(index + " is not a valid number because it is negative or greater than the "
						+ "last index of the returning route list " + 
						(this.website.getReturnRouteList().size() - 1) + ".");
				continue;
			}
			return this.getWebsite().getReturnRouteList().get(index);
		}
	}

	// pre: a Reservation reservation and a Scanner input
	// post: prints the parameters of reservation, and asks the user to confirm if that is what they desire
	// if they answer yes, adds it to reservation list and returns true, otherwise returns false
	public boolean confirmReservation(Reservation reservation, Scanner input) {
		reservation.printReservation();
		while(true) {
			System.out.println("Is this reservation satisfactory? (Type y or n)");
			String answer = input.nextLine().trim();
			if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) {
				// ProcessPayment
				System.out.println("Alright, reservation added");
				this.addRerservation(reservation);
				return true;
			} else if(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) {
				System.out.println("Reservation not added. Ending program.");
				return false;
			}
			System.out.println("Please enter y, yes, n, or no. You entered " + answer + ".");
			continue;
		}
	}
	
	// pre: nothing
	// post: returns the email and name of the object
	public String toString() {
		return (this.getEmail() + "    " + this.getName() + "\n");
	}
}
