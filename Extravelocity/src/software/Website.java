package software;

import java.util.*;
import java.io.*;


import reservables.Company;
import reservables.air.Airport;
import reservables.air.Connection;
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

	public void createAccount() {
    	Scanner input = new Scanner(System.in);
    	while(true) {
    		System.out.println("Account Creation Menu");
	    	System.out.print("Create a new account? (y/n): ");
	    	String response = input.next();
	    	if(response.equals("y") || response.equals("Y")) {
	    		System.out.print("Please enter an account name: ");
	    		String accountName = input.next();
	    		if (userData.get(accountName) != null){
	    			System.out.println("Username already exists, please choose another");
	    			continue;
	    		}
	    		
	    		
	    		System.out.print("Please enter your name: ");
	    		String name = input.next();
	    		System.out.print("Please enter your email address: ");
	    		String email = input.next();

	    		System.out.print("Please enter a password: ");
	    		String password = input.next();
	    		Account a1 = new Account(name, email, accountName, password);
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

	public void logIn() {
		Scanner input = new Scanner(System.in);
    	while(true) {
    		System.out.println("Login Menu");
    		System.out.print("Would you like to login? (y/n): ");
	    	String response = input.next();
	    	if(response.equals("y") || response.equals("Y")) {
	    		System.out.println("Enter Username");
	    		String accountName = input.next();
	    		if (userData.get(accountName) == null){
	    			System.out.println("Username does not exist");
	    			continue;
	    		}
	    		System.out.println("Enter Password");
	    		String password = input.next();
	    		
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
	    	input.close();
    	}
	}

	public void findReservation( ) {
		// TODO should be implemented
	}

	public void calculateRoutes(Airport destination, Airport departing) {
		// TODO should be implemented
	}
	
	public void fetchUserData() throws FileNotFoundException {
		File file = new File("UserData.txt"); 
		
			    Scanner sc = new Scanner(file); 
			    
			    while (sc.hasNextLine()) {
			    	StringTokenizer line = new StringTokenizer(sc.nextLine(), " ");
			    	String name = line.nextToken();
			    	String email = line.nextToken();
			    	String accountName = line.nextToken();
			    	String password = line.nextToken();
			    	Account a1 = new Account(name, email, accountName, password);
			    	userData.put(accountName, a1);
			    }
			    sc.close();
	}
	public void generateAirports( ) throws IOException {
		int i = 0;
		String name;
		String city;
		String lat;
		String line;
		String ln;
		double multiplier;
		//Double mult;
		
		Airport na; 
		//ArrayList<Airport> airports = new ArrayList<Airport>();
		//String[] airportNames;// = ("PHX","JFK","LAX","WDC","SEA","POR","DEN","HOU","AUS","SYD","LON",TUC,SDG,SFC,PAR,REY,BER,MOS,STP,CHI,CHA,ATL,MIA,NAS,PHI,BEI,HOK,SAT,BOS,BOI,PRE,KWC,RIY,DFW,JOH,ADB,"CAI","ATH")
		FileInputStream in = null;
		FileOutputStream out = null;
		in = new FileInputStream("Airport_data.txt");
		out = new FileOutputStream("airport.ser");
		Scanner sc = new Scanner(in);
		while (sc.hasNext()) {
			name = sc.nextLine();
			city = sc.nextLine();
			lat = sc.nextLine();
			ln = sc.nextLine();
			//sc.nextLine();
			line = sc.nextLine();
			line.replaceAll("[^\\d.]", "");
			multiplier = Double.parseDouble(line);
			//sc.next();
			na = new Airport(name, city, lat, ln, multiplier);
			this.airportList.add(na);
		}
		sc.close();
		Connection cn;
		in.close();
		in = new FileInputStream("acm.csv");
		sc = new Scanner(in);
		//String line;
		String[] lineVector;
		//line = sc.nextLine();
		sc.nextLine();
		int j = 0;
		while (sc.hasNext()) {
			lineVector =  sc.nextLine().split(",");
			for (i = 0; i <  this.airportList.size() - 1; i++) {
				if (Integer.parseInt(lineVector[i+1]) != 0) {
					cn = new Connection(this.airportList.get(i), Integer.parseInt(lineVector[i+1]));
					this.airportList.get(j).addConnection(cn);
				}
				
			}
			j++;
			
		}
	sc.close();
	in.close();
	out.close();
	}
}

