package reservables.hotels;
import java.time.*;

import java.util.*;
import software.*;
//import reservables.*;

import users.*;

public class Hotel {
	private ArrayList<Room> rooms;
	private ArrayList<Account> guests;
	private int stars;
	private int amenities;
	private HotelCompany company;
	
	// pre: nothing
	// post: instantiation of Hotel class, all fields set by default.
	public  Hotel() {
		rooms = new ArrayList<Room>();
		guests = new ArrayList<Account>();
		stars = 0;
		amenities = 0;
		company = new HotelCompany();
	}
	
	// pre: parameters that correspond to fields
	// post: sets the fields to the parameters
	public  Hotel(ArrayList<Room> rooms, ArrayList<Account> guests, int stars, int amenities, HotelCompany company) {
		this.rooms = rooms;
		this.guests = guests;
		this.stars = stars;
		this.amenities = amenities;
		this.company = company;
	}
		
	// pre: nothing
	// post: returns the list of rooms
	public ArrayList<Room> getRooms() {
		return this.rooms;
	}
	
	// pre: nothing
	// post: returns the list of guests
	public ArrayList<Account> getGuests() {
		return this.guests;
	}
	
	// pre: nothing
	// post: returns the integer star rating
	public int getStars() {
		return this.stars;
	}
	
	// pre: nothing
	// post: returns the number of services. i.e. breakfast, parking, wifi, etc.
	public int getAmenities() {
		
		switch (amenities) {
		case(0): 
			System.out.println("No Amenities.");
		case(1):
			System.out.println("Cable TV, Parking Included");
		case(2):
			System.out.println("Cable TV, Parking and Wifi Included");
		case(3):
			System.out.println("Cable TV, Parking, Wifi and Breakfast Included");
		default:
			System.out.println("Error, amenities is supposed to be 0 - 3 but it is " + this.amenities + ".");
		}
		return this.amenities;
	}

	// pre: List of rooms, type Room, parameter provided
	// post: sets the list rooms to the provided list
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	// pre: List of guests, type Account, parameter provided
	// post: sets the list guests to the provided list
	public void setGuests(ArrayList<Account> guests) {
		this.guests = guests;
	}
	
	// pre: integer stars, parameter provided
	// post: sets the integer number of stars to the provided integer
	public void setStars(int stars) {
		this.stars = stars;
	}

	// pre: integer services, parameter provided
	// post: sets the integer number of services to the provided integer
	public void setAmenities(int numServices) {
		this.amenities = numServices;
	}
	
	// pre: type Entry, parameter provided
	// post: returns the price of the hotel, type double, as a product of factors calculated.
	public double calculateHotelPrice(Entry entry) {
		LocalDate now = LocalDate.now();
		Period stayDuration = Period.between(entry.getCheckOutDate(), entry.getCheckInDate());
		Period urgencyFactor = Period.between(entry.getCheckInDate(), now);
		double price = company.getMultiplier() * entry.getRoomType().getMultiplier() * 
				stayDuration.getDays() * (1 + (5.0 * Math.exp( -1.0 * (double)urgencyFactor.getDays())));
		return price;
	}
	
}
