package reservables.cars;

import java.util.*;
import reservables.*;

public class CarRentalLocation extends Location {
	private ArrayList<Car> cars;
	private RentalCarCompany company;

	public ArrayList<Car> getCars() {
		return this.cars;
	}

	public RentalCarCompany getCompany() {
		return this.company;
	}

	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}

	public void setCompany(RentalCarCompany company) {
		this.company = company;
	}

	public CarRentalLocation() {
		super();
		cars = new ArrayList<Car>();
		company = new RentalCarCompany();
	}

}
