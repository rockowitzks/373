package users;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

import reservables.air.Airline;
import reservables.cars.*;
import software.*;

public class Driver implements Serializable{

	public static void main(String[] args) throws IOException {
		RunProgram();
		
	}
	
	// pre: nothing
	// post: runs the program
	public static void RunProgram() throws IOException {
		//Scanner input = new Scanner(System.in);
		Website website = new Website();
		website.fetchUserData();
		website.setUpDataBases(createAirlines(), createCarCompanies());
		//website.logIn(input);
		//website.findReservation(input);
		//input.close();
		new TravelGUI("ExTraveLux", website);
	}
	
	// pre: nothing
	// post: returns an ArrayList<Airline> called airlines
	public static ArrayList<Airline> createAirlines() {
		ArrayList<Airline> airlines = new ArrayList<Airline>();
		
		Airline united = new Airline("United", 50, "United@united.org");
		Airline emirates = new Airline("Emirates", 70, "EmiratesAir@Emirates.org");
		Airline american = new Airline("American", 60, "American@America.org");
		Airline ryanAir = new Airline("RyanAir", 20, "RyanAir@Ryanair.org");
		
		airlines.add(united);
		airlines.add(emirates);
		airlines.add(american);
		airlines.add(ryanAir);
		
		return airlines;
	}
	
	// pre: nothing
	// post: returns an ArrayList of RentalCarCopmany called rentalCarCompanyList
	public static ArrayList<RentalCarCompany> createCarCompanies() {
		ArrayList<RentalCarCompany> rentalCarCompanyList = new ArrayList<RentalCarCompany>();
		
		rentalCarCompanyList.add(new RentalCarCompany("Enterprise", 2.7, 1.1, 7777777,
			"enterprise@enterprise", new HashMap<String, CarRentalLocation>()));
		
		rentalCarCompanyList.add(new RentalCarCompany("Avis", 3.2, 1.3, 2137777,
				"customersupport@Avis", new HashMap<String, CarRentalLocation>()));
		
		rentalCarCompanyList.add(new RentalCarCompany("Hertz", 1.2, .7, 8913333,
				"trashbin@Hertz", new HashMap<String, CarRentalLocation>()));
		
		rentalCarCompanyList.add(new RentalCarCompany("Budget", 5, 1.8, 1234567,
				"wecare@Budget", new HashMap<String, CarRentalLocation>()));
		return rentalCarCompanyList;
	}
	
}
