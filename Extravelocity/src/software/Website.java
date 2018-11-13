package software;

import java.util.*;
import java.io.*;
import java.time.LocalDateTime;

import reservables.Location;
import reservables.air.Aircraft;
import reservables.air.Airline;
import reservables.air.Airport;
import reservables.air.Connection;
import reservables.air.Flight;
import reservables.air.Route;
//import reservables.cars.Car;
//import reservables.cars.CarRentalLocation;
import reservables.cars.*;
import reservables.hotels.Hotel;
import reservables.hotels.HotelCompany;
import reservables.hotels.Room;
import users.Account;

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
	
	
	// pre: nothing
	// post: instantiates the object Website
	public Website() {
		hotelCompanyList = new ArrayList<HotelCompany>();
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
	public ArrayList<HotelCompany> getHotelCompanyList() {
		return this.hotelCompanyList;
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
	public void generateHotels() {
		// will be replaced by hotel database in final code
		Random random = new Random(); 
		ArrayList<Room> randomRooms = new ArrayList<Room>();
		int randomInt = random.nextInt(100);
	    
	    // gen rooms with random room numbers
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
	
	public void setCarPrices(Entry e) {
		for(Car c: carList) {
			c.calculateCarPrice(e);
		}
	}
	
	public void setHotelPrices(Entry e) {
		for(Hotel h: hotelList) {
			h.calculateHotelPrice(e);
		}
	}
	//pre: user says where he wants to find cars
	//post: list of cars generated with is available and the company you can rent it from
		public void generateCars(String city) {
		Location asdf = new Location();
		asdf.setCity(city);
		asdf.setStreetAddress(city + " Airport");
		CarRentalLocation crl;
		for (int i = 0; i < this.getCarCompanyList().size(); i++) {
			if (!this.getCarCompanyList().get(i).getLocations().containsKey(city)) {
				crl = new CarRentalLocation(asdf);
				crl.addCar(new Car(1));
				crl.addCar(new Car(2));
				crl.addCar(new Car(3));
				crl.getCars().get(0).setRentalCarCompany(this.getCarCompanyList().get(i));
				crl.getCars().get(1).setRentalCarCompany(this.getCarCompanyList().get(i));
				crl.getCars().get(2).setRentalCarCompany(this.getCarCompanyList().get(i));
				this.getCarCompanyList().get(i).addLocation(crl);
			}
			//badersWheels.get(i).getLocations().put(.getCity());
		}
		
	}
		
	//pre generate cars run
	//carlist has list of available cars in city
	public void populateCarList(Entry data) {
		CarRentalLocation crl;
		for (int i = 0; i < this.getCarCompanyList().size(); i++) {
			crl =this.getCarCompanyList().get(i).getLocations().get(data.getDestinationCity());
			for (int j = 0; j < crl.getCars().size(); j++) {
				if (crl.getCars().get(j).getCarClass() == data.getCarClass())
					carList.add(crl.getCars().get(j));
			}
		}
	}
	// pre: nothing
	// post: returns currentAccount
	public Account getCurrentAccount() {
		return this.currentAccount;
	}

	public ArrayList<RentalCarCompany> getCarCompanyList() {
		return carCompanyList;
	}

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
	    		this.currentAccount = new Account(userData.get(accountName).getName(), userData.get(accountName).getEmail(), accountName, password, this);
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
			//makes sure flight is in the right day and not already goners
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
	
	//pre: files exist to be read from, generate called from driver
	//post: airportList generated airports have cities, latitude and longitude, connections, and names
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
}

