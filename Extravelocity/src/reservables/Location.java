package reservables;

import java.io.Serializable;

public class Location implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 310449543644675118L;
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String country;

	// pre: nothing
	// post: sets the the fields to null and zero
	public Location() {
		this.streetAddress = null;
		this.city = null;
		this.state = null;
		this.zipCode = 0;
	}
	// pre: nothing
	// post: returns the object's street address
	public String getStreetAddress() {
		return this.streetAddress;
	}

	// pre: nothing
	// post: returns the object's city
	public String getCity() {
		return this.city;
	}

	// pre: nothing
	// post: returns the objects state
	public String getState() {
		return this.state;
	}

	// pre: nothing
	// post: returns the object's zip code
	public int getZipCode() {
		return this.zipCode;
	}

	// pre: nothing
	// post: returns the object's country
	public String getCountry() {
		return this.country;
	}

	// pre: a String streetAddress
	// post: sets the field streetAddress to the parameter streetAddress
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	// pre: a String city
	// post: sets the field city to the parameter city
	public void setCity(String city) {
		this.city = city;
	}

	// pre: a String state
	// post: sets the field state to the parameter state
	public void setState(String state) {
		this.state = state;
	}

	// pre: an int zipCode that is at least five digits long
	// post: if zipCode is at least five digits, sets the field zipCode to the parameter zipCode, else prints an error message
	public void setZipCode(int zipCode) {
		if(countDigits(zipCode) >= 5) {
		this.zipCode = zipCode;
		} 
//		else {
//			System.out.println("Error, the inputed zipCode, " + zipCode + ", is less than five digits.");
//		}
	}

	// pre: a String country
	// post: sets the field country to the parameter
	public void setCountry(String country) {
		this.country = country;
	}
	
	// pre: an int number
	// post: returns the number of digits in number
	public int countDigits(int number) {
		int answer = 0;
		while(number > 0) {
			number /= 10;
			answer++;
		}
		return answer;
	}
}
