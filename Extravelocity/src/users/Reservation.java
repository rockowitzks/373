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
	
	// pre: nothing
	// post: initializes the object
	public Reservation() {
		this.account = null;
		this.departingRoute = null;
		this.returningRoute = null;
		this.car = null;
		this.hotel = null;
	}
	
	// pre: parameters corresponding the fields
	// post: initializes the object with the parameters
	public Reservation(Account account, Route departingRoute, Route returningRoute, Car car, Hotel hotel) {
		this.account = account;
		this.departingRoute = departingRoute;
		this.returningRoute = returningRoute;
		this.car = car;
		this.hotel = hotel;
	}
	
	// pre: nothing
	// post: returns account
	public Account getAccount() {
		return this.account;
	}

	// pre: nothing
	// post: returns departingRoute
	public Route getDepartingRoute() {
		return this.departingRoute;
	}

	// pre: nothing
	// post: returns returningRoute
	public Route getReturningRoute() {
		return this.returningRoute;
	}

	// pre: nothing
	// post: returns car
	public Car getCar() {
		return this.car;
	}

	// pre: nothing
	// post: returns hotel
	public Hotel getHotel() {
		return this.hotel;
	}

	// pre: an Account account
	// post: sets the field account to the parameter account
	public void setAccount(Account account) {
		this.account = account;
	}

	// pre: a Route departingRoute
	// post: sets the field departingRoute the parameter departingRoute
	public void setDepartingRoute(Route departingRoute) {
		this.departingRoute = departingRoute;
	}

	// pre: a Route returningRoute
	// post: sets the field returningRoute to the parameter returningRoute
	public void setReturningRoute(Route returningRoute) {
		this.returningRoute = returningRoute;
	}

	// pre: a Car car
	// post: sets the field car to the parameter car
	public void setCar(Car car) {
		this.car = car;
	}

	// pre: a Hotel hotel
	// post: sets the field hotel to the parameter hotel
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
}
