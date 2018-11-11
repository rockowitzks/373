package users;

import java.util.ArrayList;

import reservables.air.*;
import reservables.cars.*;
import reservables.hotels.*;
import software.*;


public class Account {
	private String name;
	private String email;
	private String accountName;
	private String password;
	private ArrayList<Reservation> reservations;
	private Website website;

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public String getPassword() {
		return this.password;
	}

	public ArrayList<Reservation> getReservations() {
		return this.reservations;
	}

	public Website getWebsite() {
		return this.website;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setReservations(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public Account() {
		name = null;
		email = null;
		accountName = null;
		password = null;
		reservations = new ArrayList<Reservation>();

	}
	
	public Account(String name, String email, String accountName, String password) {
		this.name = name;
		this.email = email;
		this.accountName = accountName;
		this.password = password;
		this.reservations = new ArrayList<Reservation>();

	}

	public void createReservation( ) {
		// TODO should be implemented
	}

	public Hotel selectHotel() {
		return null;
		// TODO should be implemented
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
