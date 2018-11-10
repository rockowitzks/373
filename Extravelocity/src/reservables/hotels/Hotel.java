package reservables.hotels;
import java.time.*;

import java.util.*;
import software.*;
import reservables.*;

import users.*;

public class Hotel {
	private ArrayList<Room> rooms;
	private ArrayList<Account> guests;
	private int stars;
	private int amenities;
	private HotelCompany company;
	private ContactInfo hotelInfo;
	
	//pre: nothing
	//post: returns the list of rooms
	public ArrayList<Room> getRooms() {
		return this.rooms;
	}
	
	//pre: nothing
	//post: returmns the list of guests
	public ArrayList<Account> getGuests() {
		return this.guests;
	}
	
	//pre: nothing
	//post: returns the integer star rating
	public int getStars() {
		return this.stars;
	}
	
	//pre: nothing
	//post: returns the number of services. i.e. breakfast, parking, wifi, etc.
	public int getAmenities() {
		if(amenities == 0) {
			System.out.println("No Amenities");
		}
		else if(amenities == 1) {
			System.out.println("Cable TV, Parking Included"); 
		}
		else if(amenities == 2) {
			System.out.println("Cable TV, Parking and Wifi Included");
		}
		else if(amenities == 3) {
			System.out.println("Cable TV, Parking, Wifi and Breakfast Included");
		}
		return this.amenities;
	}

	//pre: List of rooms, type Room, parameter provided
	//post: sets the list rooms to the provided list
	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	//pre: List of guests, type Account, parameter provided
	//post: sets the list guests to the provided list
	public void setGuests(ArrayList<Account> guests) {
		this.guests = guests;
	}
	
	//pre: integer stars, parameter provided
	//post: sets the integer number of stars to the provided integer
	public void setStars(int stars) {
		this.stars = stars;
	}

	//pre: integer services, parameter provided
	//post: sets the integer number of services to the provided integer
	public void setAmenities(int numServices) {
		this.amenities = numServices;
	}
	
	//pre: nothing
	//post: instantiation of Hotel class, all fields set defaultly.
	public  Hotel() {
		rooms = new ArrayList<Room>();
		guests = new ArrayList<Account>();
		stars = 0;
		amenities = 0;
		company = new HotelCompany();
		setHotelInfo(new ContactInfo());
	}
	public  Hotel(ArrayList<Room> rooms, ArrayList<Account> guests, int stars, int amenities, HotelCompany company, ContactInfo hotelInfo) {
		this.rooms = rooms;
		this.guests = guests;
		this.stars = stars;
		this.amenities = amenities;
		this.company = company;
		this.setHotelInfo(hotelInfo);
	}
	
	//pre: type Entry, parameter provided
	//post: returns the price of the hotel, type double, as a product of factors calculated.
	public double calculateHotelPrice(Entry entry) {
		
		LocalDate now = LocalDate.now();
		LocalDate checkIn = LocalDate.of(entry.getCheckInDate().getYear() , entry.getCheckInDate().getMonth() , entry.getCheckInDate().getDay());
		LocalDate checkOut = LocalDate.of(entry.getCheckOutDate().getYear() , entry.getCheckOutDate().getMonth() , entry.getCheckOutDate().getDay());
		Period stayDuration = Period.between(checkOut, checkIn);
		Period urgencyFactor = Period.between(checkIn, now);
		double price = company.getMultiplier() * entry.getRoomType().getMultiplier() * stayDuration.getDays() * (1 + (5.0 * Math.exp((double)urgencyFactor.getDays())));
		return price;
	}

	public ContactInfo getHotelInfo() {
		return hotelInfo;
	}

	public void setHotelInfo(ContactInfo hotelInfo) {
		this.hotelInfo = hotelInfo;
	}
	
}
