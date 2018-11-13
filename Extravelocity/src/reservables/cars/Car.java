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
	private double price;
	private double miles;
	private CarRentalLocation carRentalLocation;
	private RentalCarCompany rentalCarCompany;

	
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
		this.price = 0;
		this.rentalCarCompany = null;
		}
	
	// pre: parameters that correspond to the fields
	// post: sets the fields to the corresponding parameters
	public Car(String make, String model, String license, RentalCarCompany rentalCarCompany,
			boolean isAvailable, int carClass, Account renter, double mpg, double stars, double miles,
			CarRentalLocation location, double price) {
		this.make = make;
		this.model = model;
		this.licensePlate = license;
		this.isAvailable = isAvailable;
		this.carClass = carClass;
		this.renter = renter;
		this.mpg = mpg;
		this.stars = stars;
		this.miles = miles;
		this.carRentalLocation = location;
		this.price = price;
		this.rentalCarCompany = rentalCarCompany;
	}	
		
	public Car(int carClass) {
		this.make = null;
		this.model = null;
		this.licensePlate = null;
		this.isAvailable = true;
		this.carClass = carClass;
		this.renter = new Account();
		this.mpg = 0;
		this.stars = 0;
		this.miles = 0;
		this.carRentalLocation = new CarRentalLocation();
		this.price = 0;
		this.rentalCarCompany = null;
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
	// post:returns price
	public double getPrice() {
		return this.price;
	}

	// pre: a double price
	// post: sets the field price to the parameter price
	public void setPrice(double price) {
		this.price = price;
	}

	// pre: a boolean isAvailable
	// post: sets the field isAvailable to the parameter isAvailable
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
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
	// post: returns rentalCarCompany
	public RentalCarCompany getRentalCarCompany() {
		return this.rentalCarCompany;
	}

	// pre: a RentalCarCompany rentalCarCompany
	// post: sets the field rentalCarCompany to the parameter rentalCarCompany
	public void setRentalCarCompany(RentalCarCompany rentalCarCompany) {
		this.rentalCarCompany = rentalCarCompany;
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
	
	// pre: nothing
	// post: returns a string based on the car class
	public String getCarClassString() {
		switch(this.getCarClass()) {
		case(1):
			return "Economy";
		case(2):
			return "Standard"; 
		case(3):
			return "Luxury";
		default:
			System.exit(-10);
			return ("Error, car class is " + this.getCarClass() + "when it should be 1-3.");
		}
	}
	
	// pre: type Entry, parameter provided
	// post: calculates the price of the rental car using factors, returns as double
	public double calculateCarPrice(Entry entry) {
		
		Period rentalDuration = Period.between(entry.getTakeDate(), entry.getGiveBackDate()); // positive
		Period urgencyFactor = Period.between(LocalDate.now(), entry.getTakeDate()); // positve
		double classMultiplier = 0;
		
		switch(this.getCarClass()) {
		case(1):
			classMultiplier = 2.0; break;
		case(2):
			classMultiplier = 4.0; break;
		case(3):
			classMultiplier = 5.0; break;
		default:
			classMultiplier = 0;
			System.out.println("Error. carClass should be between 1 and 3 but it actually is " +
			this.getCarClass() + "."); break;
		}
		
		double price =  classMultiplier * this.getRentalCarCompany().getMultiplier() * 
		rentalDuration.getDays() * rentalDuration.getDays() *
		(1 + (5.0 * Math.exp(-1.0 * (double)urgencyFactor.getDays())));
		this.setPrice(price);
		return price;
		
	}
	
	// pre: nothing
	// post: prints the car 
	public String toString() {
		double price = (Math.round(this.getPrice() * 100.0)) / 100.0 ;
		return (this.getRentalCarCompany().getName() + "	" + this.getCarClassString() + " $" + price);
	}
}
