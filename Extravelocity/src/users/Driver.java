package users;

import java.io.FileNotFoundException;

import software.*;



public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		Website w1 = new Website();
		w1.fetchUserData();
		w1.createAccount();
		w1.logIn();
		
		Entry e1 = new Entry();
		e1.askFlight();
		e1.askHotel();
		e1.askCar();
		if(e1.getFlight()) {
			System.out.println("Flight Selection Menu");
			e1.askFlightDepartDate();
			//return date
		}
		if(e1.getHotel()) {
			//hotel check in date
			//hotel check out date
		}
		if(e1.getCar()) {
			//car rental date
			//car return date
		}
		
		w1.findReservation();
		//finish this so that the arraylists are populated
		
		//write and call print flight from website
		
		Reservation r1 = new Reservation();
		r1.setReturningRoute(w1.getCurrentAccount().selectReturn());
		r1.setDepartingRoute(w1.getCurrentAccount().selectDepart());
		r1.setHotel(w1.getCurrentAccount().selectHotel());
		r1.setCar(w1.getCurrentAccount().selectCar());

	}

}
