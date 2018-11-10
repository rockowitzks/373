package reservables.hotels;

import java.util.*;

import reservables.*;

public class HotelCompany extends Company {
	public ArrayList<Hotel> hotels;

	public ArrayList<Hotel> getHotels() {
		return this.hotels;
	}

	public void setHotels(ArrayList<Hotel> hotels) {
		this.hotels = hotels;
	}

	public HotelCompany(String name, double rating, double multiplier, ArrayList<Hotel> hotels) {
		this.setName(name);
		this.setRating(rating);
		this.setMultiplier(multiplier);
		this.hotels = hotels;
	}
	public HotelCompany() {
		hotels = new ArrayList<Hotel>();
	}

}
