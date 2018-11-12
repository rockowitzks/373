package users;

import java.io.FileNotFoundException;
import java.util.Scanner;

import software.*;



public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		
		Website w1 = new Website();
		w1.fetchUserData();
		w1.createAccount();
		w1.logIn();
		
		Entry e1 = new Entry();
		Reservation r1 = new Reservation();
		System.out.println("Main Menu");
		e1.askFlight(input);
		e1.askHotel(input);
		e1.askCar(input);
		
		if(e1.getFlight()) {
			System.out.println("Flight Selection Menu");
			e1.askFlightDepartDate(input);
			e1.askFlightReturnDate(input);
			e1.askDepartCity(input);
			e1.askDestinationCity(input);
		}
		
		if(e1.getHotel()) {
			System.out.println("Hotel Selection Menu");
			e1.askHotelCheckInDate(input);
			e1.askHotelCheckOutDate(input);
			e1.askRoomType(input);
		}
		
		if(e1.getCar()) {
			System.out.println("Car Selection Menu");
			e1.askCarRentalDate(input);
			e1.askCarReturnDate(input);
			e1.askCarClass(input);
		}
		
		w1.findReservation();
		//finish this so that the arraylists are populated
		
		//write and call print flight from website
		
		

		//display departing flights/routes
		r1.setDepartingRoute(w1.getCurrentAccount().selectDepartingRoute(input));
		//display returning flights/routes
		r1.setReturningRoute(w1.getCurrentAccount().selectReturningRoute(input));
		r1.setHotel(w1.getCurrentAccount().selectHotel(input));
		r1.setCar(w1.getCurrentAccount().selectCar(input));
		input.close();
	}

}
