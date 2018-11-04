package reservables.air;
public class Route {
	private Airport begin;
	private ArrayList<> flights;
	private Airport end;
	private ArrayList<> layoverList;
	private int totalTime;

	public Airport getBegin() {
		return this.begin;
	}

	public ArrayList<> getFlights() {
		return this.flights;
	}

	public Airport getEnd() {
		return this.end;
	}

	public ArrayList<> getLayoverList() {
		return this.layoverList;
	}

	public int getTotalTime() {
		return this.totalTime;
	}

	public void setBegin(Airport begin) {
		this.begin = begin;
	}

	public void setFlights(ArrayList<> flights) {
		this.flights = flights;
	}

	public void setEnd(Airport end) {
		this.end = end;
	}

	public void setLayoverList(ArrayList<> layoverList) {
		this.layoverList = layoverList;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public boolean checkValidity( ) {
		// TODO should be implemented
	}

	public void calcLayover( ) {
		// TODO should be implemented
	}

	public  Route() {
		// TODO should be implemented
	}
}
