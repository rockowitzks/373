package reservables.cars;

public class Car {
	private String make;
	private String model;
	private String license plate;
	private boolean isAvailable;
	private String type;
	private Account renter;
	private int price;
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

	public String getLicense plate() {
		return this.license plate;
	}

	public boolean getIsAvailable() {
		return this.isAvailable;
	}

	public String getType() {
		return this.type;
	}

	public Account getRenter() {
		return this.renter;
	}

	public int getPrice() {
		return this.price;
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

	public void setLicense plate(String license plate) {
		this.license plate = license plate;
	}

	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setRenter(Account renter) {
		this.renter = renter;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public  Car() {
		// TODO should be implemented
	}
}
