package users;

import java.util.*;

import reservables.air.*;
import reservables.cars.*;
import reservables.hotels.*;
import software.*;

// TO DO FOR SUNDAY: add print methods for Website's arrayList, 
public class Account {
	private String name;
	private String email;
	private String accountName;
	private String password;
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
	public Account(String name, String email, String accountName, String password) {
		this.name = name;
		this.email = email;
		this.accountName = accountName;
		this.password = password;
		this.reservations = new ArrayList<Reservation>();
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

	// pre: a Website website
	// post: sets the field website to the parameter website
	public void setWebsite(Website website) {
		this.website = website;
	}

	// pre: 
	// post:
	public void createReservation( ) {
		// TODO should be implemented
	}

	// pre: nothing
	// post: returns the Hotel that the user selects
	public Hotel selectHotel() {
		if(this.getWebsite().getHotelList().isEmpty()) {
			System.out.println("Error: hotel list is empty");
			System.exit(-1);
			return null;
		}
		
		Scanner input = new Scanner(System.in);
		while(true) {
		System.out.println("Which hotel would you like to select? (Write in the number)");
		int index = input.nextInt();
		if(index < 0 || index >= this.getWebsite().getHotelList().size()) {
			System.out.println("Not a valid number");
			continue;
		}
		input.close();
		return this.getWebsite().getHotelList().get(index);
	}
				
	}

	public Car selectCar( ) {
		return null;
		// TODO should be implemented
	}

	public Route selectDepart( ) {
		return null;
		// TODO should be implemented
	}

	public Route selectReturn( ) {
		return null;
		// TODO should be implemented
	}

	public boolean confirmReservation( ) {
		return false;
		// TODO should be implemented
	}
}
