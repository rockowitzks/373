package reservables.hotels;

public class Hotel {
	private ArrayList<> rooms;
	private ArrayList<> guests;
	private int stars;
	private int numServices;

	public ArrayList<> getRooms() {
		return this.rooms;
	}

	public ArrayList<> getGuests() {
		return this.guests;
	}

	public int getStars() {
		return this.stars;
	}

	public int getNumServices() {
		return this.numServices;
	}

	public void setRooms(ArrayList<> rooms) {
		this.rooms = rooms;
	}

	public void setGuests(ArrayList<> guests) {
		this.guests = guests;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public void setNumServices(int numServices) {
		this.numServices = numServices;
	}

	public  Hotel() {
		// TODO should be implemented
	}
}
