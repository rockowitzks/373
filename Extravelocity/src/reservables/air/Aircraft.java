package reservables.air;

public class Aircraft {
	private String model;
	private double fuelEfficiency; 
	private double airspeed;

	// pre: nothing
	// post: sets the fields to the default values
	public Aircraft() {
		this.fuelEfficiency = 0;
		this.model = null;
	}
	
	// pre: parameters corresponding to fields
	// post: sets the fields to the parameters
	public Aircraft(double fuelEfficiency, String model) {
		this.fuelEfficiency = fuelEfficiency;
		this.model = model;
	}
	
	// pre: nothing
	// post: returns the fuelEfficiency
	public double getFuelEfficiency() {
		return this.fuelEfficiency;
	}

	// pre: a double fuelEfficiency
	// post: if fuelEfficiency is positive, sets the field fuelEfficiency to parameter fuelEfficiency
	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}
	
	// pre: nothing
	// post: returns airspeed
	public double getAirspeed() {
		return this.airspeed;
	}

	// pre: a double airspeed
	// post: sets the field airspeed to the parameter airspeed
	public void setAirspeed(double airspeed) {
		this.airspeed = airspeed;
	}

	// pre: nothing
	// post: returns model
	public String getModel() {
		return this.model;
	}

	// pre: a String model
	// post: sets the field model to the parameter model
	public void setModel(String model) {
		this.model = model;
	}
}
