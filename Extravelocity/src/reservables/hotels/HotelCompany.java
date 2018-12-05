package reservables.hotels;

import java.io.Serializable;
import java.util.*;

import reservables.*;

public class HotelCompany extends Company implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7638609284942675841L;
	private ArrayList<Hotel> hotels;

	// pre: nothing
	// post: instantiates the object
	public HotelCompany() {
		super();
		this.hotels = new ArrayList<Hotel>();
	}
	
	// pre: parameters corresponding to fields
	// post: instantiates the object with the given parameters
	public HotelCompany(String name, double rating, double multiplier, int phoneNumber,
			String emailAddress, ArrayList<Hotel> hotels) {
		super(name, rating, multiplier, phoneNumber, emailAddress);
		this.hotels = hotels;
	}
	
	// pre: nothing
	// post: returns hotels
	public ArrayList<Hotel> getHotels() {
		return this.hotels;
	}

	// pre: an ArrayList of Hotel hotels
	// post: sets the field hotel to the parameter hotel
	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}	
	
	// pre: a Hotel hotel
	// post: returns true if it added, false otherwise
	public boolean addHotel(Hotel hotel) {
		if(this.hotels == null) {
			this.hotels = new ArrayList<Hotel>();
		}
		hotel.setCompany(this);
		return this.hotels.add(hotel);
	}
}
