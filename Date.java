package reservables;


public class Date {
	private int month;
	private int day;
	private int year;

	// pre: nothing
	// post: initializes the object Date with Date: 1/1/2018
	public Date() {
		this.setMonth(1);
		this.setDay(1);
		this.setYear(2018);
	}
	// pre: nothing
	// post: returns the object's month
	public int getMonth() {
		return this.month;
	}

	// pre: nothing
	// post: returns the object's day
	public int getDay() {
		return this.day;
	}

	// pre: nothing
	// post: returns the object's year
	public int getYear() {
		return this.year;
	}

	// pre: an int month
	// post: if the parameter month is between 1 and 12, sets the field month to the parameter month, otherwise, prints a message
	public void setMonth(int month) {
		if(month >= 1 && month <= 12) {
			this.month = month;
		}
	}

	// pre: an int day 
	// post: if the day is valid for its given month, sets the field day to the parameter day, otherwise prints an error message 
	public void setDay(int day) {
		if(this.month == 2 && day > 0 && day < 29) {
			this.day = day;
		} else if((month == 1 || month == 3 || month == 5 || month == 7 ||
				month == 8 || month == 10 || month == 12) && day > 0 && day < 32) {
			this.day = day;
		} else if((month == 4 || month == 6 || month == 9 || month == 11) && day > 0 && day < 31) {
			this.day = day;
		} else {
			System.out.println("The day inputed is not valid: " + day);
		}
	}

	// pre: an int year
	// post: if the parameter year is greater than zero, sets the field year to the parameter year
	public void setYear(int year) {
		if(year > 0) {
			this.year = year;
		} else {
			System.out.println("Error the year given, " + year + " is less than zero.");
		}
	}
	
	// pre: nothing
	// post: prints the date in the form of day/month/year
	public void PrintDate() {
		System.out.println(this.getDay() + "/" + this.getMonth() + "/" + this.getYear());
	}
}
