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

	public String getMake() {
		return this.make;
	}

	public String getModel() {
		return this.model;
	}

	public String getLicensePlate() {
		return this.licensePlate;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public int getCarClass() {
		return this.carClass;
	}

	public Account getRenter() {
		return this.renter;
	}

	public double getMpg() {
		return this.mpg;
	}

	public double getStars() {
		return this.stars;
	}

	public double getMiles() {
		return this.miles;
	}

	public CarRentalLocation getCarRentalLocation() {
		return this.carRentalLocation;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setCarClass(int carClass) {
		this.carClass = carClass;
	}

	public void setRenter(Account renter) {
		this.renter = renter;
	}


	public void setMpg(double mpg) {
		this.mpg = mpg;
	}

	public void setStars(double stars) {
		this.stars = stars;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public void setCarRentalLocation(CarRentalLocation carRentalLocation) {
		this.carRentalLocation = carRentalLocation;
	}
	// pre: uninstantiated
	// post: new car object created, all fields initialized defautly
	public  Car() {
		make = "";
		model = "";
		licensePlate = "";
		isAvailable = true;
		carClass = 0;
		renter = new Account();
		mpg = 0;
		stars = 0;
		miles = 0;
		carRentalLocation = new CarRentalLocation();
	}
	
	public Car(String make, String model, String lic, boolean isAvail, int carClass, Account renter, int price, double mpg, double stars, double miles, CarRentalLocation location) {
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
	
	//pre: type Entry, parameter provided
	//post: calculates the price of the rental car using factors, returns as double
	public double calculateCarPrice(Entry entry) {
		
		LocalDate now = LocalDate.now();
		LocalDate takeCar = LocalDate.of(entry.getTakeDate().getYear() , entry.getTakeDate().getMonth() , entry.getTakeDate().getDay());
		LocalDate returnCar = LocalDate.of(entry.getReturnDate().getYear() , entry.getReturnDate().getMonth() , entry.getReturnDate().getDay());
		Period rentalDuration = Period.between(returnCar, takeCar);
		Period urgencyFactor = Period.between(takeCar, now);
		double classMultiplier;
		if(this.getCarClass() == 3) {
			classMultiplier = 2.0;
		}
		else if(this.getCarClass() == 2) {
			classMultiplier = 1.5;
		}
		else if (this.getCarClass() == 1) {
			classMultiplier = 1.0;
		}
		else {
			classMultiplier = 0;
		}
		double price =  classMultiplier * carRentalLocation.getCompany().getMultiplier() * rentalDuration.getDays() * (1 + (5.0 * Math.exp((double)urgencyFactor.getDays())));
		return price;
		
	}

}
