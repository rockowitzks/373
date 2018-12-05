package software;
import java.util.*;
import reservables.air.*;

import java.io.Serializable;
import java.time.*;
public class TimeComparator implements Comparator<Route>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4249369402099325164L;

	// pre: 2 Routes, route1 and route2
	// post: returns a comparison of the Routes' departureDate
	public int compare(Route route1, Route route2) {
		LocalDateTime time1 = route1.getFlights().get(0).getDepartureDate();
		LocalDateTime time2 = route1.getFlights().get(0).getDepartureDate();
		if(time1.isBefore(time2)) {
			return -1;
		} else if (time1.isEqual(time2)) {
			return 0;
		} else {
			return 1;
		}
	}
}
