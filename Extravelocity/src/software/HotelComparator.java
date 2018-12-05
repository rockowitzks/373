package software;

import java.util.*;
import reservables.hotels.*;
public class HotelComparator implements Comparator<Hotel> {

	public int compare(Hotel hotel1, Hotel hotel2) {

		double answer = (hotel1.getPrice() - hotel2.getPrice());
		if(answer < 0) {
			return -1;
		} else if(answer < 0.0000001 && answer >= 0) {
			return 0;
		} else {
			return 1;
		}	
	}
}
