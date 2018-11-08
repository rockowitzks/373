package reservables.air;

import java.util.*;
import software.*;


public class Route {
	private Airport begin;
	private ArrayList<Flight> flights;
	private Airport end;
	private ArrayList<Layover> layoverList;
	private int totalTime;
	private double price;

	public Airport getBegin() {
		return this.begin;
	}

	public ArrayList<Flight> getFlights() {
		return this.flights;
	}

	public Airport getEnd() {
		return this.end;
	}

	public ArrayList<Layover> getLayoverList() {
		return this.layoverList;
	}

	public int getTotalTime() {
		return this.totalTime;
	}

	public void setBegin(Airport begin) {
		this.begin = begin;
	}

	public void setFlights(ArrayList<Flight> flights) {
		this.flights = flights;
	}

	public void setEnd(Airport end) {
		this.end = end;
	}

	public void setLayoverList(ArrayList<Layover> layoverList) {
		this.layoverList = layoverList;
	}

	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void calculatePrice(Entry entry) {
		
	}

	public boolean checkValidity( ) {
		return false;
		// TODO should be implemented
	}

	public void calcLayover( ) {
		// TODO should be implemented
	}

	public  Route() {
		// TODO should be implemented
	}
}
