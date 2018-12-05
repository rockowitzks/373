package reservables.hotels;

import java.io.Serializable;

import users.Account;

public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2549258136103137039L;
	private double multiplier;
	private boolean occupied;
	private int number;
	private Hotel hotel;
	private Account guest;

	// pre: nothing
	// post: instantiates the object
	public Room() {
		this.multiplier = 0;
		this.occupied = false;
		this.number = 0;
		this.hotel = null;
		this.guest = null;
	}
	
	// pre: parameters corresponding to fields
	// post: instantiates the objects with the parameters
	public Room (double multiplier, boolean occupied, int number, Hotel hotel, Account guest) {
		this.multiplier = multiplier;
		this.occupied = occupied;
		this.number = number;
		this.hotel = hotel;
		this.guest = guest;
	}
	
	// pre: nothing
	// post: returns multiplier
	public double getMultiplier() {
		return this.multiplier;
	}
	
	// pre: nothing
	// post: returns occupied
	public boolean getOccupied() {
		return this.occupied;
	}

	// pre: nothing
	// post: returns number
	public int getNumber() {
		return this.number;
	}

	// pre: nothing
	// post: returns hotel
	public Hotel getHotel() {
		return this.hotel;
	}

	// pre: a double multiplier
	// post: sets the field multiplier to the parameter multiplier
	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	// pre: a boolean occupied
	// post: sets the field occupied to the parameter occupied
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	// pre: an int number
	// post: sets the field number to the parameter
	public void setNumber(int number) {
		this.number = number;
	}

	// pre: a Hotel hotel 
	// post: sets the field hotel to the parameter hotel
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	// pre: nothing
	// post: returns guest
	public Account getGuest() {
		return this.guest;
	}

	// pre: an Account guest
	// post: sets the field guest to the parameter guest
	public void setGuest(Account guest) {
		this.guest = guest;
	}
	
}
