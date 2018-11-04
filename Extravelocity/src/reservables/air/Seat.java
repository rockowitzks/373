package reservables.air;
public class Seat {
	private int number;
	private boolean window;
	private boolean avail;
	private int priority;
	private double price;
	private Flight flight;

	public int getNumber() {
		return this.number;
	}

	public boolean getWindow() {
		return this.window;
	}

	public boolean getAvail() {
		return this.avail;
	}

	public int getPriority() {
		return this.priority;
	}

	public double getPrice() {
		return this.price;
	}

	public Flight getFlight() {
		return this.flight;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setWindow(boolean window) {
		this.window = window;
	}

	public void setAvail(boolean avail) {
		this.avail = avail;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public  Seat() {
		// TODO should be implemented
	}
}
