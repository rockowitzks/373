package software;

import reservables.air.*;
import reservables.hotels.*;
public class Entry {

	// basically delete the date class from reservables
	// flight
	private java.time.LocalDate departureDate;
	private java.time.LocalDate returnDate;
	private Airport departureAirport;
	private Airport returnAirport;
	private int passengers;
	private Seat seatPriority;
	
	
	// hotel
	private java.time.LocalDate checkInDate;
	private java.time.LocalDate checkOutDate;
	private Room roomType;
	
	
	// car
	private java.time.LocalDate takeDate;
	private java.time.LocalDate giveBackDate;
	private int carClass;
	
	// pre: nothing
	// post: instantiates the object
	public Entry() {
		this.departureAirport = null;
		this.returnDate = null;
		this.departureDate = null;
		this.returnAirport = null;
		this.passengers = 0;
		this.seatPriority = null;
		
		this.checkInDate = null;
		this.checkOutDate = null;
		this.roomType = null;
		
		this.takeDate = null;
		this.giveBackDate = null;
		this.carClass = 0;
	}
	
	// pre: nothing
	// post: return departureDate
	public java.time.LocalDate getDepartureDate() {
		return this.departureDate;
	}
	
	// pre: a Date departureDate
	// post: sets the field departureDate to the parameter departureDate
	public void setDepartureDate(java.time.LocalDate departureDate) {
		this.departureDate = departureDate;
	}
	
	// pre: nothing
	// post: returns returnDate
	public java.time.LocalDate getReturnDate() {
		return this.returnDate;
	}
	
	// pre: a LocalDate returnDate
	// post: sets the field returnDate to the parameter returnDate
	public void setReturnDate(java.time.LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	
	// pre: nothing
	// post: returns departureAirport
	public Airport getDepartureAirport() {
		return this.departureAirport;
	}
	
	// pre: an Airport departureAirport
	// post: sets the field departureAirport to the parameter departureAirport
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	
	// pre: nothing 
	// post: returns returnAirport
	public Airport getReturnAirport() {
		return this.returnAirport;
	}
	
	// pre: an Airport returnAirport
	// post: sets the field returnAirport to the parameter returnAirport
	public void setReturnAirport(Airport returnAirport) {
		this.returnAirport = returnAirport;
	}
	
	// pre: nothing
	// post: returns passengers
	public int getPassengers() {
		return this.passengers;
	}
	
	// pre: an int passengers
	// post: sets the field passengers to the parameter passengers
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	
	// pre: nothing
	// post: returns seatPriority
	public Seat getSeatPriority() {
		return this.seatPriority;
	}
	
	// pre: a Seat seatPriority
	// post: sets the field seatPriority to the parameter seatPriority
	public void setSeatPriority(Seat seatPriority) {
		this.seatPriority = seatPriority;
	}
	
	// pre: nothing
	// post returns checkInDate
	public java.time.LocalDate getCheckInDate() {
		return this.checkInDate;
	}
	
	// pre: a LocalDate checkInDate
	// post: sets the field checkInDate to the parameter checkInDate
	public void setCheckInDate(java.time.LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	
	// pre: nothing
	// post: returns checkOutDate
	public java.time.LocalDate getCheckOutDate() {
		return this.checkOutDate;
	}
	
	// pre: a LocalDate checkOutDate
	// post: sets teh field checkOutDate to the parameter checkOutDate
	public void setCheckOutDate(java.time.LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	
	// pre: nothing
	// post: returns roomType
	public Room getRoomType() {
		return this.roomType;
	}
	
	// pre: a Room roomType
	// post: sets the field roomType to the parameter roomType
	public void setRoomType(Room roomType) {
		this.roomType = roomType;
	}
	
	// pre: nothing
	// post: returns takeDate (takeDate of the car)
	public java.time.LocalDate getTakeDate() {
		return this.takeDate;
	}
	
	// pre: a LocalDate takeDate
	// post: sets the field takeDate to the parameter takeDate
	public void setTakeDate(java.time.LocalDate takeDate) {
		this.takeDate = takeDate;
	}
	
	// pre: nothing
	// post: returns giveBackDate
	public java.time.LocalDate getGiveBackDate() {
		return this.giveBackDate;
	}
	
	// pre: a LocalDate giveBackDate
	// post: sets the field giveBackDate to the parameter giveBackDate
	public void setGiveBackDate(java.time.LocalDate giveBackDate) {
		this.giveBackDate = giveBackDate;
	}
	
	// pre: nothing
	// post: returns carClass
	public int getCarClass() {
		return this.carClass;
	}
	
	// pre: an int carClass
	// post: sets the field carClass to the parameter carClass
	public void setCarClass(int carClass) {
		this.carClass = carClass;
	}	
}
