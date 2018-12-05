package software;

import java.util.*;
import reservables.cars.*;
public class CarComparator implements Comparator<Car> {

	public int compare(Car car1, Car car2) {
		double answer = (car1.getPrice() - car2.getPrice());
		if(answer < 0) {
			return -1;
		} else if(answer < 0.0000001 && answer >= 0) {
			return 0;
		} else {
			return 1;
		}	
	}
}
