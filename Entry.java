package software;

import reservables.air.*;
import reservables.hotels.*;
public class Entry {

	// flight
	private reservables.Date departureDate;
	private reservables.Date returnDate;
	private Airport departureAirport;
	private Airport returnAirport;
	private int passengers;
	Seat seatPriority;
	
	
	// hotel
	private reservables.Date checkInDate;
	private reservables.Date chechOutDate;
	private Room roomType;
	
	
	// car
	private reservables.Date takeDate;
	private reservables.Date giveBackDate;
	private int carClass;
	
	
	public Entry() {
		this.departureAirport = null;
		this.returnDate = null;
		this.departureDate = null;
		this.returnAirport = null;
		this.passengers = 0;
		this.seatPriority = null;
		
		this.checkInDate = null;
		this.chechOutDate = null;
		this.roomType = null;
		
		this.takeDate = null;
		this.giveBackDate = null;
		this.carClass = 0;
	}
	public reservables.Date getDepartureDate() {
		return departureDate;
	}
	
	public void setDepartureDate(reservables.Date departureDate) {
		this.departureDate = departureDate;
	}
	
	public reservables.Date getReturnDate() {
		return returnDate;
	}
	
	public void setReturnDate(reservables.Date returnDate) {
		this.returnDate = returnDate;
	}
	
	public Airport getDepartureAirport() {
		return departureAirport;
	}
	
	public void setDepartureAirport(Airport departureAirport) {
		this.departureAirport = departureAirport;
	}
	public Airport getReturnAirport() {
		return returnAirport;
	}
	public void setReturnAirport(Airport returnAirport) {
		this.returnAirport = returnAirport;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public Seat getSeatPriority() {
		return seatPriority;
	}
	public void setSeatPriority(Seat seatPriority) {
		this.seatPriority = seatPriority;
	}
	public reservables.Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(reservables.Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public reservables.Date getChechOutDate() {
		return chechOutDate;
	}
	public void setChechOutDate(reservables.Date chechOutDate) {
		this.chechOutDate = chechOutDate;
	}
	public Room getRoomType() {
		return roomType;
	}
	public void setRoomType(Room roomType) {
		this.roomType = roomType;
	}
	public reservables.Date getTakeDate() {
		return takeDate;
	}
	public void setTakeDate(reservables.Date takeDate) {
		this.takeDate = takeDate;
	}
	public reservables.Date getGiveBackDate() {
		return giveBackDate;
	}
	public void setGiveBackDate(reservables.Date giveBackDate) {
		this.giveBackDate = giveBackDate;
	}
	public int getCarClass() {
		return carClass;
	}
	public void setCarClass(int carClass) {
		this.carClass = carClass;
	}
	
	
	
}
