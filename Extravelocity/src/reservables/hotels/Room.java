package reservables.hotels;

import users.Account;

public class Room {
	private double multiplier;
	private boolean occupied;
	private int number;
	private Hotel hotel;
	private Account guest;

	public double getMultiplier() {
		return this.multiplier;
	}
	
	public boolean getOccupied() {
		return this.occupied;
	}

	public int getNumber() {
		return this.number;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setMultiplier(double multiplier) {
		this.multiplier = multiplier;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Room() {
		multiplier = 0;
		occupied = false;
		number = 0;
		hotel = new Hotel();
		setGuest(new Account());
	}

	public Account getGuest() {
		return guest;
	}

	public void setGuest(Account guest) {
		this.guest = guest;
	}
	
}
