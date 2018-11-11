package software;

import java.util.*;
import java.io.*;


import reservables.Company;
import reservables.air.Airport;
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

	public ArrayList<Company> getCompanyList() {
		return this.companyList;
	}

	public ArrayList<Airport> getAirportList() {
		return this.airportList;
	}

	public ArrayList<Route> getReturnRouteList() {
		return this.returnRouteList;
	}

	public ArrayList<Route> getDepartureRouteList() {
		return this.departureRouteList;
	}

	public ArrayList<Hotel> getHotelList() {
		return this.hotelList;
	}

	public ArrayList<Car> getCarList() {
		return this.carList;
	}

	public Account getCurrentAccount() {
		return this.currentAccount;
	}

	public void setCompanyList(ArrayList<Company> companyList) {
		this.companyList = companyList;
	}

	public void setAirportList(ArrayList<Airport> airportList) {
		this.airportList = airportList;
	}

	public void setReturnRouteList(ArrayList<Route> returnRouteList) {
		this.returnRouteList = returnRouteList;
	}

	public void setDepartureRouteList(ArrayList<Route> departureRouteList) {
		this.departureRouteList = departureRouteList;
	}

	public void setHotelList(ArrayList<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	public void setCarList(ArrayList<Car> carList) {
		this.carList = carList;
	}

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
	    		    FileWriter fstream = new FileWriter("userData.txt", true); //true tells to append data.
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
	    		System.out.println("Account successfully created, Welcome " + name);
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

	public void logIn( ) {
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
	}

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
}
