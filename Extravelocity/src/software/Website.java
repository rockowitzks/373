package software;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;
import java.time.LocalDateTime;
import users.*;

import reservables.Location;
import reservables.air.Aircraft;
import reservables.air.Airline;
import reservables.air.Airport;
import reservables.air.Connection;
import reservables.air.Flight;
import reservables.air.Route;
import reservables.cars.*;
import reservables.hotels.Hotel;
import reservables.hotels.HotelCompany;
import reservables.hotels.Room;

public class Website {
	private ArrayList<HotelCompany> hotelCompanyList;
	private ArrayList<RentalCarCompany> carCompanyList;
	private ArrayList<Airport> airportList;
	private ArrayList<Route> returnRouteList;
	private ArrayList<Route> departureRouteList;
	private ArrayList<Hotel> hotelList;
	private ArrayList<Car> carList;
	private Account currentAccount;
	private HashMap<String, Account> userData;
	private Entry entry;
	
	// pre: nothing
	// post: instantiates the object Website
	public Website() {
		hotelCompanyList = new ArrayList<HotelCompany>();
		airportList = new ArrayList<Airport>();
		returnRouteList = new ArrayList<Route>();
		departureRouteList = new ArrayList<Route>();
		hotelList = new ArrayList<Hotel>();
		carList = new ArrayList<Car>();
		currentAccount = new Account("Guest", "No Email", "Guest Name", "No Password", this, null);
		userData = new HashMap<String, Account>();
		entry = new Entry();
	}
	
	// pre: nothing
	// post: returns companyList
	public ArrayList<HotelCompany> getHotelCompanyList() {
		return this.hotelCompanyList;
	}
	
	// pre: nothing
	// post: adds a user to the userData hash map
	public void addNewUser(Account account) {
		this.userData.put(account.getAccountName(), account);
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
	
	// pre: nothing
	// post: generates hotel
	public void generateHotels() {
		// will be replaced by hotel database in final code
		Random random = new Random(); 
		ArrayList<Room> randomRooms = new ArrayList<Room>();
		int randomInt = random.nextInt(100);
	    
	    // generate rooms with random room numbers
		randomInt = random.nextInt(100);
	    Room r1 = new Room(1.0, false, randomInt, null, null);
	    randomInt = random.nextInt(100) + 100;
	    Room r2 = new Room(2.0, false, randomInt, null, null);
	    randomInt = random.nextInt(100) + 200;
	    Room r3 = new Room(3.0, false, randomInt, null, null);
	    
	    randomRooms.add(r1);
	    randomRooms.add(r2);
	    randomRooms.add(r3);
	    
	    HotelCompany hilton = new HotelCompany("Hilton", 5.0, 3.0, 0,
	    		"service@hilton.com", null);
	    HotelCompany bestWestern = new HotelCompany("Best Western", 3.0, 2.0, 0,
	    		"service@bestwestern.com", null);
	    HotelCompany travelLodge = new HotelCompany("Travel Lodge", 2.5, 1.75, 0,
	    		"service@travellodge.com", null);
	    HotelCompany motel6 = new HotelCompany("motel6", 2.0, 1.25, 0,
	    		"service@motel6.com", null);
	    HotelCompany windham = new HotelCompany("Windham", 3.0, 2.5, 0,
	    		"service@windham.com", null);
	    HotelCompany howardJohnson = new HotelCompany("Howard Johnson", 5.0, 3.2, 0,
	    		"service@howardjohnson.com", null);
	    
		Hotel h1 = new Hotel(randomRooms, null, 5, 3, hilton, 100, null);
		Hotel h2 = new Hotel(randomRooms, null, 3, 2, bestWestern, 60, null);
		Hotel h3 = new Hotel(randomRooms, null, 2, 2, travelLodge, 50, null);
		Hotel h4 = new Hotel(randomRooms, null, 1, 1, motel6, 40, null);
		Hotel h5 = new Hotel(randomRooms, null, 3, 3, windham, 70, null);
		Hotel h6 = new Hotel(randomRooms, null, 5, 3, howardJohnson, 95, null);
		

		hilton.addHotel(h1);
		
		bestWestern.addHotel(h2);
		travelLodge.addHotel(h3);
		motel6.addHotel(h4);
		windham.addHotel(h5);
		howardJohnson.addHotel(h6);
		
		this.hotelCompanyList.add(hilton);
		this.hotelCompanyList.add(bestWestern);
		this.hotelCompanyList.add(travelLodge);
		this.hotelCompanyList.add(motel6);
		this.hotelCompanyList.add(windham);
		this.hotelCompanyList.add(howardJohnson);
		
		this.hotelList.add(h1);
		this.hotelList.add(h2);
		this.hotelList.add(h3);
		this.hotelList.add(h4);
		this.hotelList.add(h5);
		this.hotelList.add(h6);
	
	}
	
	// pre: an Entry entry
	// post: calculates the car prices
	public void setCarPrices(Entry entry) {
		for(Car car: carList) {
			car.calculateCarPrice(entry);
		}
	}
	
	// pre: an Entry entry
	// post: calculates the hotel prices
	public void setHotelPrices(Entry entry) {
		for(Hotel hotel: hotelList) {
			hotel.calculateHotelPrice(entry);
		}
	}
	
	// pre: user says where he wants to find cars
	// post: list of cars generated with is available and the company you can rent it from
		public void generateCars(String city) {
		Location location = new Location();
		location.setCity(city);
		location.setStreetAddress(city + " Airport");
		CarRentalLocation carRentalLocation;
		for (int i = 0; i < this.getCarCompanyList().size(); i++) {
			if (!this.getCarCompanyList().get(i).getLocations().containsKey(city)) {
				carRentalLocation = new CarRentalLocation(location);
				carRentalLocation.addCar(new Car(1));
				carRentalLocation.addCar(new Car(2));
				carRentalLocation.addCar(new Car(3));
				carRentalLocation.getCars().get(0).setRentalCarCompany(this.getCarCompanyList().get(i));
				carRentalLocation.getCars().get(1).setRentalCarCompany(this.getCarCompanyList().get(i));
				carRentalLocation.getCars().get(2).setRentalCarCompany(this.getCarCompanyList().get(i));
				this.getCarCompanyList().get(i).addLocation(carRentalLocation);
			}
		}
		
	}
		
	// pre: generate cars run, an Entry data
	// post: a carlist has list of available cars in city
	public void populateCarList(Entry data) {
		CarRentalLocation carRentalLocation;
		for (int i = 0; i < this.getCarCompanyList().size(); i++) {
			carRentalLocation =this.getCarCompanyList().get(i).getLocations().get(data.getCarCity());
			for (int j = 0; j < carRentalLocation.getCars().size(); j++) {
				if (carRentalLocation.getCars().get(j).getCarClass() == data.getCarClass()) {
					carRentalLocation.getCars().get(j).calculateCarPrice(data);
					this.carList.add(carRentalLocation.getCars().get(j));
				}
					
			}
		}
	}
	
	// pre: nothing
	// post: returns currentAccount
	public Account getCurrentAccount() {
		return this.currentAccount;
	}
	
	// pre: nothing
	// post: returns the userData hash map
	public HashMap<String, Account> getUserData() {
		return this.userData;
	}

	// pre: nothing
	// post: returns car company list
	public ArrayList<RentalCarCompany> getCarCompanyList() {
		return this.carCompanyList;
	}

	// pre: an ArrayList of RentalCarCompany carCompanyList
	// post: sets the field carCompanyList to the parameter carCompanyList
	public void setCarCompanyList(ArrayList<RentalCarCompany> carCompanyList) {
		this.carCompanyList = carCompanyList;
	}

	// pre: an ArrayList of Company companyList
	// post: sets the field companyList to the parameter companyList
	public void setHotelCompanyList(ArrayList<HotelCompany> hotelCompanyList) {
		this.hotelCompanyList = hotelCompanyList;
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

	// pre: a scanner input
	// post: creates the account
	public void createAccount(Scanner input) {
    	while(true) {
    		System.out.println("Account Creation Menu");
	    	System.out.print("Create a new account? (y/n): ");
	    	String response = input.nextLine();
	    	if(response.equals("y") || response.equals("Y")) {
	    		System.out.print("Please enter an account name: ");
	    		String accountName = input.nextLine();
	    		if (this.userData.get(accountName) != null){
	    			System.out.println("Username already exists, please choose another");
	    			continue;
	    		}
	    		
	    		
	    		System.out.print("Please enter your name: ");
	    		String name = input.nextLine();
	    		System.out.print("Please enter your email address: ");
	    		String email = input.nextLine();

	    		System.out.print("Please enter a password: ");
	    		String password = input.nextLine();
	    		Account a1 = new Account(name, email, accountName, password, this, null);
	    		this.userData.put(accountName, a1);
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
	    		this.currentAccount = new Account(userData.get(accountName).getName(), userData.get(accountName).getEmail(), accountName, password, this, null);
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
	
	// pre: nothing
	// post: sets up airlines and car companies
	public void setUpDataBases(ArrayList<Airline> airlines, ArrayList<RentalCarCompany> 
	carCompanies) throws IOException {
		this.generateAirports(airlines);	
		this.setCarCompanyList(carCompanies);
	}

	// pre: a scanner input
	// post: logs in the user
	public void logIn(Scanner input) throws FileNotFoundException{
		this.fetchUserData();
		this.createAccount(input);
    	while(true) {
    		System.out.println("Login Menu");
    		System.out.print("Would you like to login? (y/n): ");
	    	String response = input.nextLine();
	    	if(response.equals("y") || response.equals("Y")) {
	    		System.out.println("Enter Username");
	    		String accountName = input.nextLine();
	    		if (this.userData.get(accountName) == null){
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


	// pre: airports and flights generated, user gives return date and departure dates, return and departure airports.
	// post: generates list of viable routes for passenger to take
	public void calculateRoutes(Entry data) {
		HashMap<String, Airport> routed = new HashMap<String,Airport>();
		double minPrice = 1000000000;
		LocalDateTime t1 = LocalDateTime.now();
		//Duration minDuration;
		ArrayList<Route> possibleRoutes = new ArrayList<Route>();
		routed.put(data.getDepartureAirport().getName(), data.getDepartureAirport());
		ArrayList<Route> routes = new ArrayList<Route>();
		for (int i = 0; i < data.getDepartureAirport().getDepartureList().size(); i++) {
			//makes sure flight is in the right day and not already goners
			if(data.getDepartureAirport().getDepartureList().get(i).getDepartureDate().isAfter(t1) && data.getDepartureAirport().getDepartureList().get(i).getDepartureDate().isAfter(data.getDepartureDate().atStartOfDay())
					&& data.getDepartureAirport().getDepartureList().get(i).getDepartureDate().isBefore(data.getDepartureDate().plusDays(1).atStartOfDay())) {
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
						&& possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).getArriving().getCity().equalsIgnoreCase(data.getDestinationCity())) {
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
		minPrice = 1000000000;
		routed.put(a.getName(), a);
		for (int i = 0; i < a.getDepartureList().size(); i++) { //now do the same thing but the other direction
			if(a.getDepartureList().get(i).getDepartureDate().isAfter(data.getReturnDate().atStartOfDay())
				&& a.getDepartureList().get(i).hasEnoughSeats(data.getPassengers(), data.getSeatPriority())
				&& a.getDepartureList().get(i).getDepartureDate().isBefore(data.getReturnDate().plusDays(1).atStartOfDay())) {
				if (a.getDepartureList().get(i).getArriving().getName().equalsIgnoreCase(b.getName())) {
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
						&& possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i).getArriving().getName().equalsIgnoreCase(b.getName())) {
					possibleRoutes.get(j).addFlight(possibleRoutes.get(j).getFlights().get(0).getArriving().getDepartureList().get(i));
					routes.add(possibleRoutes.get(j));
					break;
				}
			}
		}
		this.setReturnRouteList(routes);
		for(int i = 0; i < this.getDepartureRouteList().size(); i++) {
			this.getDepartureRouteList().get(i).calculatePrice(entry);
			
		}
		
		for(int i = 0; i < this.getReturnRouteList().size(); i++) {
			this.getReturnRouteList().get(i).calculatePrice(entry);
		}
	}
	
	// pre: airport list generated, date and base airport given
	// post: 3 days of flights generated at nexus and connecting airports.
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
								todo.get(j).getAirlineList().get(ThreadLocalRandom.current().nextInt(0, todo.get(j).getAirlineList().size())), craft, 
								aDate.plusHours((long) (Math.random() * 24)), "111", 300, 0);
						
					}
					
				}
			}
			aDate.equals(aDate.plusDays(1));
		}
	}
	// pre: receives user entered string for username
	// post: if username string matches stored username, return true, else return false
	public boolean validateUsername(String username) {
		if(this.userData.get(username) != null) {
			return true;
		}
		return false;
	}
	// pre: receives user entered string for username and password
	// post: if password string matches stored password at stored username, return true, else return false
	public boolean validatePassword(String username, String password) {
		if(this.userData.get(username).getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	// pre: nothing
	// post: retrieves the user account data
	public void fetchUserData() throws FileNotFoundException {
		File file = new File("userData.txt"); 
		
			    Scanner scanner = new Scanner(file); 
			    
			    while (scanner.hasNextLine()) {
			    	StringTokenizer line = new StringTokenizer(scanner.nextLine(), " ");
			    	String name = line.nextToken();
			    	String email = line.nextToken();
			    	String accountName = line.nextToken();
			    	String password = line.nextToken();
			    	Account account = new Account(name, email, accountName, password, this, null);
			    	this.userData.put(accountName, account);
			    }
			    scanner.close();	
	}
	
	// pre: files exist to be read from, generate called from driver
	// post: airportList generated airports have cities, latitude and longitude, connections, and names
	public void generateAirports(ArrayList<Airline> airLineList) throws IOException {
		String name = "", city = "", latitude = "", longitude = "", line = "";
		double multiplier = 0;		
		Airport airport = null; // maybe change this if there is a bug
		FileInputStream in = new FileInputStream("Airport_data.txt");
		// FileOutputStream out = new FileOutputStream("airport.ser");
		Scanner scanner = new Scanner(in);
		while (scanner.hasNext()) {
			name = scanner.nextLine();
			city = scanner.nextLine();
			latitude = scanner.nextLine();
			longitude = scanner.nextLine();
			//sc.nextLine();
			line = scanner.nextLine();
			line.replaceAll("[^\\d.]", "");
			multiplier = Double.parseDouble(line);
			//sc.next();
			airport = new Airport(name, city, latitude, longitude, multiplier);
			
			airport.setAirlineList(airLineList);
			this.airportList.add(airport);
		}
		scanner.close();
		Connection connection;
		in.close();
		in = new FileInputStream("acm.csv");
		scanner = new Scanner(in);
		//String line;
		String[] lineVector;
		//line = sc.nextLine();
		scanner.nextLine(); // Skips list of airport names
		int j = 0;
		while (scanner.hasNext()) {
			lineVector =  scanner.nextLine().split(",");
			for (int i = 0; i <  this.airportList.size() - 1; i++) {
				if (Integer.parseInt(lineVector[i+1]) != 0) {
					connection = new Connection(this.airportList.get(i), Integer.parseInt(lineVector[i+1]));
					this.airportList.get(j).addConnection(connection);
				}
				
			}
			j++;
			
		}
	scanner.close();
	in.close();
	//out.close();
	}
	

//	 pre: a Scanner input
//	 post: Asks the user for information to put into entry
	public Entry getEntry(Scanner input) {
		Entry entry = new Entry();
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
			entry.findAirportFromCity(this);//find airport function that adds airport to entry.
			// display
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
		
		if(!(entry.getFlight()) && !(entry.getCar()) && !(entry.getHotel())) {
			return null;
		}
		return entry;
	}
	
	public Entry getEntry() {
		return entry;
	}

	public void setEntry(Entry entry) {
		this.entry = entry;
	}

	// pre: a Scanner input
	// post: asks the user how they want their flights to be sorted. Returns true for price, flase for time
	public boolean askHowToSort(Scanner input) {
		System.out.println("Would you like to sort your flights by price, or by time?");
		String answer = "";
		while(true) {
			 answer = input.nextLine().trim();
			if(answer.equalsIgnoreCase("price") || answer.equalsIgnoreCase("p")) {
				return true;
			} else if (answer.equalsIgnoreCase("time") || answer.equalsIgnoreCase("t") 
					|| answer.equalsIgnoreCase("date") || answer.equalsIgnoreCase("d")) {
				return false;
			} else {
				System.out.println("Not a valid answer. Please enter price or time");
			}
		}
	}
	
	// pre: an ArrayList of Route routeList, and a boolean sortByPrice
	// post: either sorts the routeList by price or by time, and returns routeList
	public ArrayList<Route> SortRoute(ArrayList<Route> routeList, boolean sortByPrice) {
		if(sortByPrice) {
			Collections.sort(routeList, new PriceComparator());
		} else {
			Collections.sort(routeList, new TimeComparator());
		}
		return routeList;
	}
   
	// pre: an Entry entry and a Scanner input
	// post: creates a reservation based on the user's input to entry
	public void findReservation(Scanner input) {
		Entry entry = this.getEntry(input);
		if(entry == null) {
			System.out.println("You have chosen not to reserve anything. Ending program now.");
			return;
		}
		
		boolean sortByPrice = askHowToSort(input);
		Reservation reservation = new Reservation();
		//generate the departing flights
				if(entry.getFlight()) { 
					this.generateFlights(entry.getDepartureDate().atStartOfDay(), entry.getDepartureAirport());
					this.generateFlights(entry.getReturnDate().atStartOfDay(), entry.getReturnAirport());
					
					/// calculates the routes
					this.calculateRoutes(entry);
					// this calculates price and prints the departing routes

					
					for(int i = 0; i < this.getDepartureRouteList().size(); i++) {
						this.getDepartureRouteList().get(i).calculatePrice(entry);
					}
					
					this.setDepartureRouteList(this.SortRoute(this.getDepartureRouteList(), sortByPrice));

					for(int i = 0; i < this.getDepartureRouteList().size(); i++) {
						System.out.print(i + " " + this.getDepartureRouteList().get(i));
					}
					// this selects the departing routes
					reservation.setDepartingRoute(this.getCurrentAccount().selectDepartingRoute(input));
					// this calculates price and prints the returning routes
					
					for(int i = 0; i < this.getReturnRouteList().size(); i++) {
						this.getReturnRouteList().get(i).calculatePrice(entry);
					}
					
					this.setReturnRouteList(this.SortRoute(this.getReturnRouteList(), sortByPrice));
					for(int i = 0; i < this.getReturnRouteList().size(); i++) {
						System.out.print(i + " " + this.getReturnRouteList().get(i));
					}
				
					// this selects the returning routes
					reservation.setReturningRoute(this.getCurrentAccount().selectReturningRoute(input));
				}

									
				// start hotels
				if(entry.getHotel()) {
					this.generateHotels();
					for(int i = 0; i < this.getHotelList().size(); i++) {
						this.getHotelList().get(i).calculateHotelPrice(entry);
						System.out.println(i + " " + this.getHotelList().get(i));
					}
					reservation.setHotel(this.getCurrentAccount().selectHotel(input));
				}

				// start cars
					if(entry.getCar() && entry.getFlight()) { // changed this
						this.generateCars(entry.getDestinationCity());
						this.populateCarList(entry);
						for(int i = 0; i < this.getCarList().size(); i++) {
							this.getCarList().get(i).calculateCarPrice(entry);
							System.out.println(i + " " + this.getCarList().get(i));
						}
						reservation.setCar(this.getCurrentAccount().selectCar(input));
					}

				// this confirms the reservation
				reservation.setAccount(this.getCurrentAccount());
				 this.getCurrentAccount().confirmReservation(reservation, input);
	}
   
   // pre: a String string
   // post: returns true if it is numeric, false otherwise 
	public static boolean isNumeric(String string)  
	{  
	  try  
	  {  
	    int number = Integer.parseInt(string);  
	  }  
	  catch(NumberFormatException numberFormatException)  
	  {  
	    return false;  
	  }  
	  return true;  
	}


	
}