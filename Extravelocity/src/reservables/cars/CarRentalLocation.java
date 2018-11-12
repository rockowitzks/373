package reservables.cars;

import java.util.*;
import reservables.*;

public class CarRentalLocation extends Location {
	private ArrayList<Car> cars;
	private RentalCarCompany company;

	// pre: nothing
	// post: instantiates the object
	public CarRentalLocation() {
		super();
		cars = new ArrayList<Car>();
		company = new RentalCarCompany();
	}
	
	// pre: parameters corresponding to fields
	// post: sets the fields to the parameters
	public CarRentalLocation(ArrayList<Car> cars, RentalCarCompany company) {
		super();
		this.cars = cars;
		this.company = company;
	}

	public CarRentalLocation(Location asdf) {
		this.cars = new ArrayList<Car>();
		this.setCountry(asdf.getCountry());
		this.setCity(asdf.getCity());
		this.setState(asdf.getState());
		this.setStreetAddress(asdf.getStreetAddress());
		this.setZipCode(asdf.getZipCode());
	}

	// pre: nothing
	// post: returns cars
	public ArrayList<Car> getCars() {
		return this.cars;
	}

	// pre: nothing
	// post: returns company
	public RentalCarCompany getCompany() {
		return this.company;
	}

	// pre: an ArrayList of Car cars
	// post: sets the field cars to the parameter cars
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	// pre: a RentalCarCompany company
	// post: sets the field company to the parameter company
	public void setCompany(RentalCarCompany company) {
		this.company = company;
	}
	//pre: car list created
	//post adds car
	public void addCar(Car car) {
		this.cars.add(car);
	}
}
