package reservables.hotels;
import java.time.*;

import java.util.*;
import software.*;

import users.*;

public class Hotel {
	private ArrayList<Room> rooms;
	private ArrayList<Account> guests;
	private int stars;
	private int amenities;
	private double price;
	private HotelCompany company;
	
	// pre: nothing
	// post: instantiation of Hotel class, all fields set by default.
	public  Hotel() {
		this.rooms = new ArrayList<Room>();
		this.guests = new ArrayList<Account>();
		this.stars = 0;
		this.amenities = 0;
		this.company = null;
		this.price = 0;
	}
	
	// pre: parameters that correspond to fields
	// post: sets the fields to the parameters
	public  Hotel(ArrayList<Room> rooms, ArrayList<Account> guests, int stars, int amenities, HotelCompany company,
			double price) {
		this.rooms = rooms;
		this.guests = guests;
		this.stars = stars;
		this.amenities = amenities;
		this.company = company;
		this.price = price;
	}
		
	// pre: nothing
	// post: returns company
	public HotelCompany getCompany() {
		return this.company;
	}

	// pre: a HotelCompany company
	// post: sets the field company to the parameter company
	public void setCompany(HotelCompany company) {
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
	// post: returns the amenity code
	public int getAmenities() {
		return this.amenities;
	}
	
	// pre: nothing
	// post: returns price
	public double getPrice() {
		return this.price;
	}

	// pre: a double price
	// post: sets the field price to the parameter price
	public void setPrice(double price) {
		this.price = price;
	}

	// pre: nothing
	// post: returns a String that indicates what amenities you get based on the amenity code
	public String getAmenityString() {
		String answer = "";
		switch (amenities) {
		case(0): 
			answer = "No Amenities.";
		case(1):
			answer = "Cable TV, Parking Included";
		case(2):
			answer = "Cable TV, Parking and Wifi Included";
		case(3):
			answer = "Cable TV, Parking, Wifi and Breakfast Included";
		default:
			answer = "Error, amenities is supposed to be 0 - 3 but it is " + this.amenities + ".";
		}
		return answer;
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
	public void setAmenities(int amenities) {
		this.amenities = amenities;
	}
	
	// pre: type Entry, parameter provided
	// post: returns the price of the hotel, type double, as a product of factors calculated.
	public double calculateHotelPrice(Entry entry) {
		LocalDate now = LocalDate.now();
		Period stayDuration = Period.between(entry.getCheckOutDate(), entry.getCheckInDate());
		Period urgencyFactor = Period.between(entry.getCheckInDate(), now);
		double price = company.getMultiplier() * entry.getRoomType() * 
				stayDuration.getDays() * (1 + (5.0 * Math.exp( -1.0 * (double)urgencyFactor.getDays())));
		this.setPrice(price);
		return price;
	}
	
	// pre: nothing
	// post: returns a String consisting of company, amenities, and cost
	public String toString() {
		return (this.getCompany().getName() + " " + this.getAmenityString() + " $" + (this.getPrice()) + ".");
	}
	
}
