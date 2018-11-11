package users;

import reservables.air.Route;
import reservables.cars.Car;
import reservables.hotels.Hotel;

public class Reservation {
	private Account account;
	private Route departingRoute;
	private Route returningRoute;
	private Car car;
	private Hotel hotel;

	public Account getAccount() {
		return this.account;
	}

	public Route getDepartingRoute() {
		return this.departingRoute;
	}

	public Route getReturningRoute() {
		return this.returningRoute;
	}

	public Car getCar() {
		return this.car;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setDepartingRoute(Route departingRoute) {
		this.departingRoute = departingRoute;
	}

	public void setReturningRoute(Route returningRoute) {
		this.returningRoute = returningRoute;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public  Reservation() {
		account = new Account();
		departingRoute = new Route();
		returningRoute = new Route();
		car = new Car();
		hotel = new Hotel();
	}
	
	public Reservation(Account account, Route departingRoute, Route returningRoute, Car car, Hotel hotel) {
		this.account = account;
		this.departingRoute = departingRoute;
		this.returningRoute = returningRoute;
		this.car = car;
		this.hotel = hotel;
	}
}
