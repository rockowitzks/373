package software;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import reservables.air.Airport;
import reservables.air.Connection;
public class Airport_Creator {
	//pre files exist to be read and made into airport
	//post .ser file created with airport list class data
	public static void main(String[] args) throws IOException {
	int i = 0;
	String name;
	String city;
	String lat;
	String line;
	String ln;
	double multiplier;
	//Double mult;
	
	Airport na; 
	ArrayList<Airport> airports = new ArrayList<Airport>();
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
		airports.add(na);
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
		for (i = 0; i <  airports.size(); i++) {
			if (Integer.parseInt(lineVector[i+1]) != 0) {
				cn = new Connection(airports.get(i), Integer.parseInt(lineVector[i+1]));
				airports.get(j).addConnection(cn);
			}
			
		}
		j++;
		
	}
	sc.close();
	in.close();
	for (i = 0; i < airports.size(); i++) {
		airports.get(i).airportOut(out);
	}
	out.close();
	}
}
