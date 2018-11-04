package reservables;


public class Location {
	private String streetAddress;
	private String city;
	private String state;
	private int zipCode;
	private String Country;

	public String getStreetAddress() {
		return this.streetAddress;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public int getZipCode() {
		return this.zipCode;
	}

	public String getCountry() {
		return this.Country;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public void setCountry(String Country) {
		this.Country = Country;
	}

	public  Location() {
		// TODO should be implemented
	}
}
