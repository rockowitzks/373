package users;

import java.io.IOException;
import java.util.*;

import reservables.air.*;
import reservables.cars.CarRentalLocation;
import reservables.cars.RentalCarCompany;
import software.*;




public class Driver {

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		

		Website website = new Website();
		Account guest = new Account("Guest", "No Email", "Guest Name", "No Password", website);
		website.setCurrentAccount(guest);
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
		website.setCarCompanyList(badersWheels);
		
		website.generateAirports(airlines);
		website.fetchUserData();
		website.createAccount(input);
		website.logIn(input);
		
		Entry entry = new Entry();
		Reservation reservation = new Reservation();
		System.out.println("Main Menu");
		entry.askFlight(input);
		entry.askHotel(input);
		entry.askCar(input);
		
		if(entry.getFlight()) {
			System.out.println("Flight Selection Menu");
			entry.askFlightDepartDate(input);
			entry.askFlightReturnDate(input);
			entry.askDepartCity(input);
			entry.askDestinationCity(input);
			entry.askSeatPriority(input);
			entry.findAirportFromCity(website);//find airport function that adds airport to entry.
			//dis
		}
		
		if(entry.getHotel()) {
			System.out.println("Hotel Selection Menu");
			entry.askHotelCheckInDate(input);
			entry.askHotelCheckOutDate(input);
			entry.askRoomType(input);
		}
		
		if(entry.getCar()) {
			System.out.println("Car Selection Menu");
			entry.askCarRentalDate(input);
			entry.askCarReturnDate(input);
			entry.askCarClass(input);
		}
		
				
		//generate the departing flights
		if(entry.getFlight()) { 
			website.generateFlights(entry.getDepartureDate().atStartOfDay(), entry.getDepartureAirport());
			website.generateFlights(entry.getReturnDate().atStartOfDay(), entry.getReturnAirport());
			
			/// calculates the routes
			website.calculateRoutes(entry);
			// this calculates price and prints the departing routes
			for(int i = 0; i < website.getDepartureRouteList().size(); i++) {
				website.getDepartureRouteList().get(i).calculatePrice(entry);
				System.out.print(i + " " + website.getDepartureRouteList().get(i));
			}
			// this selects the departing routes
			reservation.setDepartingRoute(website.getCurrentAccount().selectDepartingRoute(input));
			// this calculates price and prints the returning routes
			for(int i = 0; i < website.getReturnRouteList().size(); i++) {
				website.getReturnRouteList().get(i).calculatePrice(entry);
				System.out.print(i + " " + website.getReturnRouteList().get(i));
			}
		
			// this selects the returning routes
			reservation.setReturningRoute(website.getCurrentAccount().selectReturningRoute(input));
		}
		
		
		
		// start hotels
		if(entry.getHotel()) {
			website.generateHotels();
			for(int i = 0; i < website.getHotelList().size(); i++) {
				website.getHotelList().get(i).calculateHotelPrice(entry);
				System.out.println(i + " " + website.getHotelList().get(i));
			}
			reservation.setHotel(website.getCurrentAccount().selectHotel(input));
		}

			
			
		// start cars
			if(entry.getCar()) {
				website.generateCars(entry.getDestinationCity());
				website.populateCarList(entry);
				for(int i = 0; i < website.getCarList().size(); i++) {
					website.getCarList().get(i).calculateCarPrice(entry);
					System.out.println(i + " " + website.getCarList().get(i));
				}
				reservation.setCar(website.getCurrentAccount().selectCar(input));
			}

		// this confirms the reservation
		reservation.setAccount(website.getCurrentAccount());
		 website.getCurrentAccount().confirmReservation(reservation, input);

		input.close();
	}

}
