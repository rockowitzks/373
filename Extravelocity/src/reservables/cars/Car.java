package reservables.cars;

import users.*;

import java.time.LocalDate;
import java.time.Period;

import software.*;

public class Car {
	private String make;
	private String model;
	private String licensePlate;
	private boolean isAvailable;
	private int carClass;
	private Account renter;
	private double mpg;
	private double stars;
	private double miles;
	private CarRentalLocation carRentalLocation;

	
	// pre: uninstantiated
	// post: new car object created, all fields initialized by default
	public  Car() {
		this.make = null;
		this.model = null;
		this.licensePlate = null;
		this.isAvailable = true;
		this.carClass = 0;
		this.renter = new Account();
		this.mpg = 0;
		this.stars = 0;
		this.miles = 0;
		this.carRentalLocation = new CarRentalLocation();
		}
	
	// pre: parameters that correspond to the fields
	// post: sets the fields to the corresponding parameters
	public Car(String make, String model, String lic, boolean isAvail, int carClass,
			Account renter, int price, double mpg, double stars, double miles,
			CarRentalLocation location) {
		this.make = make;
		this.model = model;
		this.licensePlate = lic;
		this.isAvailable = isAvail;
		this.carClass = carClass;
		this.renter = renter;
		this.mpg = mpg;
		this.stars = stars;
		this.miles = miles;
		this.carRentalLocation = location;
	}	
		
	// pre: nothing
	// post: returns make
	public String getMake() {
		return this.make;
	}

	// pre: nothing
	// post: returns model
	public String getModel() {
		return this.model;
	}

	// pre: nothing
	// post: returns licensePlate
	public String getLicensePlate() {
		return this.licensePlate;
	}

	// pre: nothing
	// post: returns isAvailable
	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	// pre: nothing
	// post: returns carClass
	public int getCarClass() {
		return this.carClass;
	}

	// pre: nothing
	// post: returns renter
	public Account getRenter() {
		return this.renter;
	}

	// pre: nothing
	// post: returns mpg
	public double getMpg() {
		return this.mpg;
	}

	// pre: nothing
	// post: returns stars
	public double getStars() {
		return this.stars;
	}

	// pre: nothing
	// post: returns miles
	public double getMiles() {
		return this.miles;
	}

	// pre: nothing
	// post: returns carRentalLocation
	public CarRentalLocation getCarRentalLocation() {
		return this.carRentalLocation;
	}

	// pre: a String make
	// post: sets the field make to the parameter make
	public void setMake(String make) {
		this.make = make;
	}

	// pre: a String model
	// post: sets the field model to the parameter
	public void setModel(String model) {
		this.model = model;
	}

	// pre: a String licensePlate
	// post: sets the field licensePlate to the parameter licensePlate
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	// pre: a boolean isAvailable
	// post: sets the field isAvailable to the parameter isAvailable
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	// pre: an int carClass
	// post: sets the field carClass to the parameter carClass
	public void setCarClass(int carClass) {
		this.carClass = carClass;
	}

	// pre: an Account renter
	// post: sets the field renter to the account renter
	public void setRenter(Account renter) {
		this.renter = renter;
	}

	// pre: a double mpg
	// post: sets the field mpg to the parameter mpg
	public void setMpg(double mpg) {
		this.mpg = mpg;
	}

	// pre: a double stars
	// post: sets the field stars to the double stars
	public void setStars(double stars) {
		this.stars = stars;
	}

	// pre: a double miles
	// post: sets the field miles to the parameter
	public void setMiles(double miles) {
		this.miles = miles;
	}

	// pre: a CarRentalLocation carRentalLocation
	// post: sets the field carRentalLocation to the parameter carRentalLocation
	public void setCarRentalLocation(CarRentalLocation carRentalLocation) {
		this.carRentalLocation = carRentalLocation;
	}
	
	// pre: type Entry, parameter provided
	// post: calculates the price of the rental car using factors, returns as double
	public double calculateCarPrice(Entry entry) {
		
		Period rentalDuration = Period.between(entry.getGiveBackDate(), entry.getTakeDate());
		Period urgencyFactor = Period.between(entry.getTakeDate(), LocalDate.now());
		double classMultiplier;
		
		switch(this.getCarClass()) {
		case(1):
			classMultiplier = 1.0;
		case(2):
			classMultiplier = 1.5;
		case(3):
			classMultiplier = 2.0;
		default:
			classMultiplier = 0;
			System.out.println("Error. carClass should be between 1 and 3 but it actually is " +
			this.getCarClass() + ".");
		}
		double price =  classMultiplier * carRentalLocation.getCompany().getMultiplier() * 
		rentalDuration.getDays() * (1 + (5.0 * Math.exp( -1.0 * (double)urgencyFactor.getDays())));
		return price;
		
	}

}
