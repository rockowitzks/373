package users;

import java.time.*;
public class Test {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime later = LocalDateTime.now().plusSeconds(2000);
		boolean checkBefore = now.isBefore(later);
		boolean checkAfter = now.isAfter(later);
		System.out.println("Is now before later?: " +checkBefore);
		System.out.println("Is now after later?: " +checkAfter);
		

	}

}
