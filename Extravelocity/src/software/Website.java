package software;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

import reservables.Company;
import reservables.air.Aircraft;
import reservables.air.Airline;
import reservables.air.Airport;
import reservables.air.Connection;
import reservables.air.Flight;
import reservables.air.Route;
import reservables.cars.Car;
import reservables.hotels.Hotel;
import users.Account;

public class Website {
	private ArrayList<Company> companyList;
	private ArrayList<Airport> airportList;
	private ArrayList<Route> returnRouteList;
	private ArrayList<Route> departureRouteList;
	private ArrayList<Hotel> hotelList;
	private ArrayList<Car> carList;
	private Account currentAccount;
	private HashMap<String, Account> userData;
	
	
	// pre: nothing
	// post: instantiates the object Website
	public Website() {
		companyList = new ArrayList<Company>();
		airportList = new ArrayList<Airport>();
		returnRouteList = new ArrayList<Route>();
		departureRouteList = new ArrayList<Route>();
		hotelList = new ArrayList<Hotel>();
		carList = new ArrayList<Car>();
		currentAccount = new Account();
		userData = new HashMap<String, Account>();
	}
	
	// pre: nothing
	// post: returns companyList
	public ArrayList<Company> getCompanyList() {
		return this.companyList;
	}

	// pre: nothing
	// post: returns airportList
	public ArrayList<Airport> getAirportList() {
		return this.airportList;
	}

	// pre: nothing
	// post: returns returnRouteList
	public ArrayList<Route> getReturnRouteList() {
		return this.returnRouteList;
	}

	// pre: nothing
	// post: returns departureRouteList
	public ArrayList<Route> getDepartureRouteList() {
		return this.departureRouteList;
	}

	// pre: nothing
	// post: returns hotelList
	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

	// pre: nothing
	// post: returns carList
	public ArrayList<Car> getCarList() {
		return this.carList;
	}
	//pre: user says where he wants to find cars
		//post: list of cars generated with is available and the company you can rent it from
//		public void generateCars(String city) {
//			ArrayList<RentalCarCompany> badersWheels = new ArrayList<RentalCarCompany>();
//			badersWheels.add(new RentalCarCompany("Enterprise", 2.7, 1.1, 7777777,
//				"enterprise@enterprise", new ArrayList<CarRentalLocation>()));
//			badersWheels.add(new RentalCarCompany("Avis", 3.2, 1.3, 2137777,
//					"customersupport@Avis", new ArrayList<CarRentalLocation>()));
//			badersWheels.add(new RentalCarCompany("Hertz", 1.2, .7, 8913333,
//					"trashbin@Hertz", new ArrayList<CarRentalLocation>()));
//			badersWheels.add(new RentalCarCompany("Budget", 5, 1.8, 1234567,
//					"wecare@Budget", new ArrayList<CarRentalLocation>()));
//			Location asdf = new Location();
//			asdf.setCity(city);
//			asdf.setStreetAddress(city.concat(" Airport"));
//			new car
//			for (int i = 0; i < badersWheels.size(); i++) {
//				badersWheels.get(i).getLocations().add(new CarRentalLocation(asdf));
//				
//			}
//		}
	// pre: nothing
	// post: returns currentAccount
	public Account getCurrentAccount() {
		return this.currentAccount;
	}

	// pre: an ArrayList of Company companyList
	// post: sets the field companyList to the parameter companyList
	public void setCompanyList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}

	// pre: an ArrayList of Airport airportList
	// post: sets the field airportList to the parameter airportList
	public void setAirportList(ArrayList<Airport> airportList) {
		this.airportList = airportList;
	}

	// pre: an ArrayList of Route returnRouteList
	// post: sets the field returnRouteList to the parameter returnRouteList
	public void setReturnRouteList(ArrayList<Route> returnRouteList) {
		this.returnRouteList = returnRouteList;
	}

	// pre: an ArrayList of Route departureRouteList
	// post: sets the field departureRouteList to the parameter departureRouteList
	public void setDepartureRouteList(ArrayList<Route> departureRouteList) {
		this.departureRouteList = departureRouteList;
	}

	// pre: an ArrayList of Hotel hotelList
	// post: sets the field hotelList to the parameter hotelList
	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	// pre: an ArrayList of Car carList
	// post: sets the field carList to the parameter carList
	public void setCarList(ArrayList<Car> carList) {
		this.carList = carList;
	}

	// pre: an Account currentAccount
	// post: sets the field currentAccount to the parameter currentAccount
	public void setCurrentAccount(Account currentAccount) {
		this.currentAccount = currentAccount;
	}

	// pre: a Scanner input
	// post: asks the user to create an account or if they refuse, ask to login, and continue if they refuse too
	public void createAccount(Scanner input) {
    	while(true) {
    		System.out.println("Account Creation Menu");
	    	System.out.print("Create a new account? (y/n): ");
	    	String response = input.nextLine();
	    	if(response.equals("y") || response.equals("Y")) {
	    		System.out.print("Please enter an account name: ");
	    		String accountName = input.nextLine();
	    		if (userData.get(accountName) != null){
	    			System.out.println("Username already exists, please choose another");
	    			continue;
	    		}
	    		
	    		
	    		System.out.print("Please enter your name: ");
	    		String name = input.nextLine();
	    		System.out.print("Please enter your email address: ");
	    		String email = input.nextLine();

	    		System.out.print("Please enter a password: ");
	    		String password = input.nextLine();
	    		Account a1 = new Account(name, email, accountName, password, this);
	    		userData.put(accountName, a1);
	    		BufferedWriter out = null;
	    		
	    		try {
	    		    FileWriter fstream = new FileWriter("userData.txt", true); // true tells to append data.
	    		    out = new BufferedWriter(fstream);
	    		    out.write(name + " " + email + " " + accountName + " " + password);
	    		    out.newLine();
	    		}

	    		catch (IOException e) {
	    		    System.err.println("Error: " + e.getMessage());
	    		}
	    		
	    		try {
					out.close();
				} catch (IOException f) {
					f.printStackTrace();
				}
	    		
	    		System.out.println("Account successfully created. Welcome " + name);
	    		return;
	    	}
	    	
	    	else if(response.equals("n") || response.equals("N")) {	
	    		return;
			}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    	}
	    	
	    	input.close();
    	}
	
	}

	// pre: a Scanner input
	// post: asks the user to login with username and password
	public void logIn(Scanner input) {
    	while(true) {
    		System.out.println("Login Menu");
    		System.out.print("Would you like to login? (y/n): ");
	    	String response = input.nextLine();
	    	if(response.equals("y") || response.equals("Y")) {
	    		System.out.println("Enter Username");
	    		String accountName = input.nextLine();
	    		if (userData.get(accountName) == null){
	    			System.out.println("Username does not exist");
	    			continue;
	    		}
	    		System.out.println("Enter Password");
	    		String password = input.nextLine();
	    		
	    		if(!userData.get(accountName).getPassword().equals(password)) {
	    			System.out.println("Incorrect Password");
	    			continue;
	    		}
	    		System.out.println("Login Successful. Welcome back " + userData.get(accountName).getName());
	    		return;
	    	}
	    	else if(response.equals("n") || response.equals("N")) {	
	    		return;
	    	}
	    	else {
	    		System.out.println("Please enter either (y/n): ");
	    	}
    	}
	}

	public void findReservation( ) {
		// TODO should be implemented
	}

	//pre: airports and flights generated, user gives return date and departure dates, return and departure airports.
	//post: generates list of viable routes for passenger to take
	public void calculateRoutes(Entry data) {
		HashMap<String, Airport> routed = new HashMap<String,Airport>();
		double minPrice = 1000000000;
		LocalDateTime t1 = LocalDateTime.now();
		//Duration minDuration;
		ArrayList<Route> possibleRoutes = new ArrayList<Route>();
		routed.put(data.getDepartureAirport().getName(), data.getDepartureAirport());
		ArrayList<Route> routes = new ArrayList<Route>();
		for (int i = 0; i < data.getDepartureAirport().getDepartureList().size(); i++) {
			// makes sure flight is in the right day and not already goners
			if(data.getDepartureAirport().getDepartureList().get(i).getDepartureDate().isAfter(t1) && data.getDepartureAirport().getDepartureList().get(i).getDepartureDate().isAfter(data.getDepartureDate().atStartOfDay()) && data.getDepartureAirport().getDepartureList().get(i).getDepartureDate().isBefore(data.getDepartureDate().plusDays(1).atStartOfDay())) {
			//if direct flight has available seats always shown, checks pricing to find minimum price.
			if (data.getDepartureAirport().getDepartureList().get(i).getArriving().getName() == data.getReturnAirport().getName() 
			&& data.getDepartureAirport().getDepartureList().get(i).hasEnoughSeats(data.getPassengers(), data.getSeatPriority())) {
				routes.add(new Route(data.getDepartureAirport().getDepartureList().get(i)));
			//	if (data.getDepartureAirport().getDepartureList().get(i).calculatePrice(data) < minDirectPrice) {
				//	minDirectPrice = data.getDepartureAirport().getDepartureList().get(i).calculatePrice(data);
				//}
				if (data.getDepartureAirport().getDepartureList().get(i).calculatePrice(data) < minPrice) {
					minPrice = data.getDepartureAirport().getDepartureList().get(i).calculatePrice(data);
				}
			} //if route through airport not already started being built start building, only if price less than default flight.
			else if (!routed.containsKey(data.getDepartureAirport().getDepartureList().get(i).getArriving().getName()) && data.getDepartureAirport().getDepartureList().get(i).hasEnoughSeats(data.getPassengers(), data.getSeatPriority())) {
				if (data.getDepartureAirport().getDepartureList().get(i).calculatePrice(data) < minPrice) {
					possibleRoutes.add(new Route(data.getDepartureAirport().getDepartureList().get(i)));
					routed.put(data.getDepartureAirport().getDepartureList().get(i).getArriving().getName(), data.getDepartureAirport().getDepartureList().get(i).getArriving());
				}
			}
			}
		}
		//Airport a; //literally do not even ask
		for (int j = 0; j < possibleRoutes.size(); j++) {
			//loops through possible routes looking for acceptable connections
			//checks if price is low enough, connection is available if so adds to connection.
			for (int i = 0; i < possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().size(); i++) {
				if (possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).getDepartureDate().isAfter(possibleRoutes.get(j).getFlights().get(0).getArrivalDate()) 
/*makes sure is cheap*/ && possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).calculatePrice(data) + possibleRoutes.get(j).getFlights().get(0).calculatePrice(data) < minPrice
						&& possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).getArriving().getName().equals(data.getDestinationCity())) {
					possibleRoutes.get(j).addFlight(possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i));
					routes.add(possibleRoutes.get(j));
					break;
				}
			}
		}
		this.setDepartureRouteList(routes);
		Airport a = data.getReturnAirport();
		Airport b = data.getDepartureAirport();
		possibleRoutes = new ArrayList<Route>();
		routes = new ArrayList<Route>();
		routed = new HashMap<String,Airport>();
		//minDirectPrice = 300000000;
		minPrice = 1000000000;
		routed.put(a.getName(), a);
		for (int i = 0; i < a.getDepartureList().size(); i++) { //now do the same thing but the other direction
			if(a.getDepartureList().get(i).getDepartureDate().isAfter(data.getReturnDate().atStartOfDay())
				&& a.getDepartureList().get(i).hasEnoughSeats(data.getPassengers(), data.getSeatPriority())
				&& a.getDepartureList().get(i).getDepartureDate().isBefore(data.getReturnDate().plusDays(1).atStartOfDay())) {
				if (a.getDepartureList().get(i).getArriving().getName().equals(b.getName())) {
					routes.add(new Route(a.getDepartureList().get(i)));
					if (a.getDepartureList().get(i).calculatePrice(data) < minPrice)
						minPrice = a.getDepartureList().get(i).calculatePrice(data);	
				}
				else if (!routed.containsKey(a.getDepartureList().get(i).getArriving().getName())) {
					if (a.getDepartureList().get(i).calculatePrice(data) < minPrice) {
						possibleRoutes.add(new Route(a.getDepartureList().get(i)));
						routed.put(a.getDepartureList().get(i).getArriving().getName(), a.getDepartureList().get(i).getArriving());
					}
				}
			}
		}
		for (int j = 0; j < possibleRoutes.size(); j++) {
			//loops through possible routes looking for acceptable connections
			//checks if price is low enough, connection is available if so adds to connection.
			for (int i = 0; i < possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().size(); i++) {
				if (possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).getDepartureDate().isAfter(possibleRoutes.get(j).getFlights().get(0).getArrivalDate()) 
/*makes sure is cheap*/ && possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).calculatePrice(data) + possibleRoutes.get(j).getFlights().get(0).calculatePrice(data) < minPrice
						&& possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).getArriving().getName().equals(b.getName())) {
					possibleRoutes.get(j).addFlight(possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i));
					routes.add(possibleRoutes.get(j));
					break;
				}
			}
		}
		this.setReturnRouteList(routes);
	}
	
	//pre: airport list generated, date and base airport given
	//post: 3 days of flights generated at nexus and connecting airports.
	public void generateFlights(LocalDateTime aDate, Airport nexus) {
		ArrayList<Airport> todo = new ArrayList<Airport>();
		todo.add(nexus);
		//Flight f = null;
		Aircraft craft = new Aircraft();
		craft.setAirspeed(987.84);
		craft.setModel("Boeing 747");
		//Random rand = new Random();
		for (int i = 0; i < nexus.getConnections().size(); i++) {
			todo.add(nexus.getConnections().get(i).getDestination());
		} //quadruple nested loop runs 3 times for 3 days through every todo and creates l flgihts for every connection
		for (int i = 0; i <3; i++) {
			for ( int j= 0; j < todo.size(); j++) {
				for (int k = 0; k < todo.get(j).getConnections().size(); k++) {
					for (int l = 0; l < todo.get(j).getConnections().get(k).getFlightsPerDay(); l++) {
						new Flight(todo.get(j), todo.get(j).getConnections().get(k).getDestination(), 
								todo.get(j).getAirlineList().get((int)Math.random() * todo.get(j).getAirlineList().size()), craft, 
								aDate.plusHours((long) (Math.random() * 24)), "111", 300, 0);	
					}
					
				}
			}
			aDate.equals(aDate.plusDays(1));
		}
	}
	
	// pre: nothing
	// post: retrieves the user account data
	public void fetchUserData() throws FileNotFoundException {
		File file = new File("UserData.txt"); 
		
			    Scanner scanner = new Scanner(file); 
			    
			    while (scanner.hasNextLine()) {
			    	StringTokenizer line = new StringTokenizer(scanner.nextLine(), " ");
			    	String name = line.nextToken();
			    	String email = line.nextToken();
			    	String accountName = line.nextToken();
			    	String password = line.nextToken();
			    	Account account = new Account(name, email, accountName, password, this);
			    	userData.put(accountName, account);
			    }
			    scanner.close();
	}
	
	// pre: files exist to be read from, generate called from driver
	// post: airportList generated airports have cities, latitude and longitude, connections, and names
	public void generateAirports(ArrayList<Airline> airLineList) throws IOException {
		String name = "", city = "", latitude = "", longitude = "", line = "";
		double multiplier = 0;		
		Airport airport = null; // maybe change this if there is a bug
		FileInputStream input = new FileInputStream("Airport_data.txt");
		// FileOutputStream out = new FileOutputStream("airport.ser");
		Scanner scanner = new Scanner(input);
		while (scanner.hasNext()) {
			name = scanner.nextLine();
			city = scanner.nextLine();
			latitude = scanner.nextLine();
			longitude = scanner.nextLine();
			// scanner.nextLine();
			line = scanner.nextLine();
			line.replaceAll("[^\\d.]", "");
			multiplier = Double.parseDouble(line);
			// scanner.next();
			airport = new Airport(name, city, latitude, longitude, multiplier);
			
			airport.setAirlineList(airLineList);
			this.airportList.add(airport);
		}
		scanner.close();
		Connection cn;
		input.close();
		input = new FileInputStream("acm.csv");
		scanner = new Scanner(input);
		//String line;
		String[] lineVector;
		//line = scanncer.nextLine();
		scanner.nextLine(); // Skips list of airport names
		int j = 0;
		while (scanner.hasNext()) {
			lineVector =  scanner.nextLine().split(",");
			for (int i = 0; i <  this.airportList.size() - 1; i++) {
				if (Integer.parseInt(lineVector[i+1]) != 0) {
					cn = new Connection(this.airportList.get(i), Integer.parseInt(lineVector[i+1]));
					this.airportList.get(j).addConnection(cn);
				}
				
			}
			j++;
			
		}
	scanner.close();
	input.close();
	//out.close();
	}
}

