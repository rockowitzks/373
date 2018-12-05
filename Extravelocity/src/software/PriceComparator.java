package software;
import java.io.Serializable;
import java.util.*;
import reservables.air.*;
public class PriceComparator implements Comparator<Route>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4973976217229845829L;

	// pre: 2 Routes, route1 and route1
	// post: returns a comparison of the Routes' price
	public int compare(Route route1, Route route2) {
		double answer = (route1.getPrice() - route2.getPrice());
		if(answer < 0) {
			return -1;
		} else if(answer < 0.0000001 && answer >= 0) {
			return 0;
		} else {
			return 1;
		}	
	}

}
