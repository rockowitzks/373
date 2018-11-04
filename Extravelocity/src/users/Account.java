
public class Account {
	private String name;
	private String email;
	private String accountName;
	private String password;
	private ArrayList<> reservations;
	private Website website;

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public String getPassword() {
		return this.password;
	}

	public ArrayList<> getReservations() {
		return this.reservations;
	}

	public Website getWebsite() {
		return this.website;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setReservations(ArrayList<> reservations) {
		this.reservations = reservations;
	}

	public void setWebsite(Website website) {
		this.website = website;
	}

	public  Account() {
		// TODO should be implemented
	}

	public void createReservation( ) {
		// TODO should be implemented
	}

	public Hotel selectHotel( ) {
		// TODO should be implemented
	}

	public Car selectCar( ) {
		// TODO should be implemented
	}

	public Route selectDepart( ) {
		// TODO should be implemented
	}

	public Route selectReturn( ) {
		// TODO should be implemented
	}

	public boolean confirmReservation( ) {
		// TODO should be implemented
	}
}
