package reservables.hotels;

public class Room {
	private String type;
	private double price;
	private boolean occupado;
	private int number;
	private Hotel hotel;

	public String getType() {
		return this.type;
	}

	public double getPrice() {
		return this.price;
	}

	public boolean getOccupado() {
		return this.occupado;
	}

	public int getNumber() {
		return this.number;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOccupado(boolean occupado) {
		this.occupado = occupado;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public  Room() {
		// TODO should be implemented
	}
}
