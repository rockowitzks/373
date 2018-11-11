package users;

import java.io.FileNotFoundException;

import software.*;
import reservables.*;
import reservables.air.*;
import reservables.cars.*;
import reservables.hotels.*;
import users.*;



public class CreateAccountDriver {

	public static void main(String[] args) throws FileNotFoundException {
		Website w1 = new Website();
		w1.fetchUserData();
		w1.createAccount();
		w1.logIn();

	}

}
