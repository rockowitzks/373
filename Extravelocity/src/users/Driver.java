package users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import reservables.air.*;
import reservables.cars.CarRentalLocation;
import reservables.cars.RentalCarCompany;
import software.*;




public class Driver {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		
		Website w1 = new Website();
		ArrayList<Airline> airlines = new ArrayList<Airline>();
		Airline united = new Airline();
		united.setName("United");
		united.setMultiplier(80);
		
		Airline emirates = new Airline();
		emirates.setName("Emirates");
		emirates.setMultiplier(100);
		
		Airline american = new Airline();
		american.setName("American");
		american.setMultiplier(90);
		
		Airline ryanAir = new Airline();
		ryanAir.setName("RyanAir");
		ryanAir.setMultiplier(20);
		
		airlines.add(united);
		airlines.add(emirates);
		airlines.add(american);
		airlines.add(ryanAir);
		
		ArrayList<RentalCarCompany> badersWheels = new ArrayList<RentalCarCompany>();
		badersWheels.add(new RentalCarCompany("Enterprise", 2.7, 1.1, 7777777,
			"enterprise@enterprise", new HashMap<String, CarRentalLocation>()));
		badersWheels.add(new RentalCarCompany("Avis", 3.2, 1.3, 2137777,
				"customersupport@Avis", new HashMap<String, CarRentalLocation>()));
		badersWheels.add(new RentalCarCompany("Hertz", 1.2, .7, 8913333,
				"trashbin@Hertz", new HashMap<String, CarRentalLocation>()));
		badersWheels.add(new RentalCarCompany("Budget", 5, 1.8, 1234567,
				"wecare@Budget", new HashMap<String, CarRentalLocation>()));
		w1.setCarCompanyList(badersWheels);
		
		w1.generateAirports(airlines);
		w1.fetchUserData();
		w1.createAccount(input);
		w1.logIn(input);
		
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
			e1.findAirportFromCity(w1);//find airport function that adds airport to entry.
			//dis
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
		
		//generate the departing flights
		w1.generateFlights(e1.getDepartureDate().atStartOfDay(), e1.getDepartureAirport());
		w1.generateFlights(e1.getReturnDate().atStartOfDay(), e1.getReturnAirport());
		//* breaks here **
		w1.calculateRoutes(e1);
		// post: prints out departing flights in standard form with index
		for(int i = 0; i < w1.getDepartureRouteList().size(); i++) {
			w1.getDepartureRouteList().get(i).calculatePrice(e1);
			System.out.print(i + " " + w1.getDepartureRouteList());
		}

		// post: user selects the route, is added to reseveration object
		r1.setDepartingRoute(w1.getCurrentAccount().selectDepartingRoute(input));
		
		//generate the departing flights
		w1.generateFlights(e1.getReturnDate().atStartOfDay(), e1.getReturnAirport());
		// post: prints out returning flights in standard form with index
		w1.printDepartureRoutes();
		
		// post: user selects the rout, is added to reservation object
		r1.setReturningRoute(w1.getCurrentAccount().selectReturningRoute(input));
		
		//write and call print flight from website
		
		
		//r1.setHotel(w1.getCurrentAccount().selectHotel(input));
		//r1.setCar(w1.getCurrentAccount().selectCar(input));
		input.close();
	}

}
