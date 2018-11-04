package reservables.cars;

public class CarRentalLocation {
	private ArrayList<> cars;
	private RentalCarCompany company;

	public ArrayList<> getCars() {
		return this.cars;
	}

	public RentalCarCompany getCompany() {
		return this.company;
	}

	public void setCars(ArrayList<> cars) {
		this.cars = cars;
	}

	public void setCompany(RentalCarCompany company) {
		this.company = company;
	}

	public  CarRentalLocation() {
		// TODO should be implemented
	}
}
